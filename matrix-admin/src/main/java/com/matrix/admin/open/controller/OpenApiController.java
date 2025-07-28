package com.matrix.admin.open.controller;

import com.matrix.admin.open.service.OpenApiService;
import com.matrix.common.vo.basic.response.BaseResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开放接口控制层
 * @author liuweizhong
 * @since 2024-02-11
 */
@RestController
@RequestMapping("/open/api")
public class OpenApiController {

    @Resource
    private OpenApiService openApiService;

    @GetMapping("/test")
    public BaseResponse<String> test() {
        return BaseResponse.success(openApiService.test());
    }

    @GetMapping("/testThreadPool")
    public BaseResponse<String> testThreadPool() {
        return BaseResponse.success(openApiService.testThreadPool());
    }

}
