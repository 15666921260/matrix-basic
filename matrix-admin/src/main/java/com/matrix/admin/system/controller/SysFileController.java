package com.matrix.admin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.matrix.admin.system.service.SysFileService;
import com.matrix.common.enums.system.HttpStatus;
import com.matrix.common.vo.basic.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author liuweizhong
 * @since 2024-03-03
 */
@Tag(name = "SysFileController", description = "系统文件管理(文件的上传、下载、图片预览功能)")
@RestController
@RequestMapping("/sysFile")
public class SysFileController {

    @Resource
    private SysFileService fileService;

    @GetMapping("/imagePreview/{fileId}")
    @Operation(summary = "获取文件")
    public void imagePreview(@PathVariable("fileId") String fileId, HttpServletResponse response) {
        fileService.imagePreview(fileId, response);
    }

    @PostMapping("/upload")
    @Operation(summary = "获取文件, 成功返回文件上传的id")
    public BaseResponse<String> uploadFile(MultipartFile file, HttpServletRequest request) {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        String upload = fileService.uploadFile(file, loginId, request);
        if (StringUtils.isNotBlank(upload)){
            return BaseResponse.success(upload);
        }else {
            return BaseResponse.error(HttpStatus.ERROR.getCode(), "文件上传失败！");
        }

    }

    /**
     * 文件服务器连接测试接口
     * 文件上传、预览前一刻调用测试，是否正常链接到服务器
     * @return 是否访问成功
     */
    @GetMapping("/fileConnectTest")
    @Operation(summary = "文件服务器连接测试接口")
    public BaseResponse<Boolean> fileConnectTest(){
        return BaseResponse.success(Boolean.TRUE);
    }
}
