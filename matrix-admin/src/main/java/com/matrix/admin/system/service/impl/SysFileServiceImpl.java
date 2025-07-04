package com.matrix.admin.system.service.impl;

import com.martix.util.DateUtils;
import com.matrix.admin.system.mappers.SysFileMapper;
import com.matrix.admin.system.service.SysFileService;
import com.matrix.common.constant.SpecialStr;
import com.matrix.common.enums.system.FileType;
import com.matrix.common.exception.BusinessException;
import com.matrix.common.pojo.system.SysFile;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * @author liuweizhong
 * @since 2024-03-10
 */
@Slf4j
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {

    /**
     * 文件上传的路径
     */
    @Value("${file.local.upload-path}")
    private String uploadPath;

    @Resource
    private SysFileMapper sysFileMapper;

    @Override
    public void imagePreview(String fileId, HttpServletResponse response) {
        if (SpecialStr.ZERO.equals(fileId)) {
            return;
        }
        if (StringUtils.isBlank(fileId)){
            return;
        }
        SysFile sysFile = sysFileMapper.selectOneById(fileId);
        if (Objects.isNull(sysFile)) {
            return;
        }
        String filePath = uploadPath + sysFile.getFileUrl();
        File file = new File(filePath);
        response.setHeader("Content-Disposition", "attachment; filename=" + sysFile.getFileTempName());
        response.setContentType("image/" + sysFile.getFileType());
        try (
                FileInputStream fis = new FileInputStream(file);
                ServletOutputStream out = response.getOutputStream()
        ){
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }catch (IOException e) {
            log.error("文件获取失败！", e);
            throw new BusinessException("文件获取失败！");
        }

    }

    @Override
    public String uploadFile(MultipartFile file, String userId, HttpServletRequest request) {
        // 拼接文件目录
        String folderYearMonth = DateUtils.date2StrFormat(new Date(), "yyyyMM");
        String folderDay = DateUtils.date2StrFormat(new Date(), "dd");

        String filePath = File.separator + folderYearMonth + File.separator + folderDay + File.separator;

        File folder = new File(uploadPath + filePath);
        // 目录为空则创建
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // 获取文件类型 默认无类型
        String fileType = FileType.NONE.getFileType();
        String fileSourceName = file.getOriginalFilename();
        if (StringUtils.isNotBlank(fileSourceName)){
            String[] split = fileSourceName.split(SpecialStr.POINT_SPLIT);
            if (split.length != 0) {
                fileType = split[split.length - 1];
            }
        }

        // 上传文件
        String fileTempName = DateUtils.date2StrFormat(new Date(), "yyyyMMddHHmmssSSS") + SpecialStr.POINT + fileType;
        try {
            file.transferTo(new File(folder, fileTempName));
        } catch (IOException e) {
            log.error("\n文件上传错误，路径：{}，文件名：{}", filePath, fileTempName, e);
            return "";
        }

        SysFile sysFile = new SysFile();
        LocalDateTime now = LocalDateTime.now();
        sysFile.setFileType(fileType);
        sysFile.setFileUrl(filePath + fileTempName);
        sysFile.setFileTempName(fileTempName);
        sysFile.setFileSourceName(fileSourceName);
        sysFile.setCreateId(userId);
        sysFile.setCreateTime(now);
        sysFile.setUpdateId(userId);
        sysFile.setUpdateTime(now);
        sysFileMapper.insert(sysFile);
        return sysFile.getId();
    }
}
