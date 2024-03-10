package com.matrix.admin.file.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.matrix.admin.file.service.SysFileService;
import com.matrix.common.enums.system.HttpStatus;
import com.matrix.common.pojo.basic.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @author liuweizhong
 * @since 2024-03-03
 */
@Slf4j
@Tag(name = "SysFileController", description = "系统文件管理(文件的上传、下载、图片预览功能)")
@RestController
@RequestMapping("/sysFile")
public class SysFileController {

    @Resource
    private SysFileService fileService;

    @GetMapping("/imagePreview")
    @Operation(summary = "获取文件")
    public BaseResponse<String> imagePreview(@RequestParam("fileId") String fileId, HttpServletResponse response) {
        String s = fileService.imagePreview(fileId, response);
        if (StringUtils.isBlank(s)){
            return BaseResponse.success("获取成功");
        }else {
            return BaseResponse.error(HttpStatus.ERROR.getCode(), s);
        }
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

}
