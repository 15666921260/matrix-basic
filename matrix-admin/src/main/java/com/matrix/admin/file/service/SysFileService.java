package com.matrix.admin.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matrix.common.pojo.basic.BaseResponse;
import com.matrix.common.pojo.system.SysFile;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务
 * @author liuweizhong
 * @since 2024-03-10
 */
public interface SysFileService extends IService<SysFile> {

    /**
     * 获取文件
     * @param fileId 文件Id
     * @param response Http
     * @return 返回数据 为空代表成功 有数据展示500与相应的数据
     */
    String imagePreview(String fileId, HttpServletResponse response);

    /**
     * 上传文件接口
     * @param file 上传的文件
     * @param userId 当前登录用户的id
     * @param request request
     * @return 结果
     */
    String uploadFile(MultipartFile file, String userId, HttpServletRequest request);
}
