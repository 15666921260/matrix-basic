package com.matrix.admin.system.service;

import com.matrix.common.pojo.system.SysFile;
import com.mybatisflex.core.service.IService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务
 * @author liuweizhong
 * @since 2024-03-10
 */
public interface SysFileService extends IService<SysFile> {

    /**
     * 获取文件
     *
     * @param fileId   文件Id
     * @param response Http
     */
    void imagePreview(String fileId, HttpServletResponse response);

    /**
     * 上传文件接口
     * @param file 上传的文件
     * @param userId 当前登录用户的id
     * @param request request
     * @return 结果
     */
    String uploadFile(MultipartFile file, String userId, HttpServletRequest request);
}
