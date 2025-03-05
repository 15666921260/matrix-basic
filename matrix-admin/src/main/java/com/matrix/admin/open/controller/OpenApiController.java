package com.matrix.admin.open.controller;

import com.matrix.admin.open.service.OpenApiService;
import com.matrix.common.vo.basic.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开放接口控制层
 * @author liuweizhong
 * @since 2024-02-11
 */
@Tag(name = "OpenApiControllerApi", description = "开放接口")
@RestController
@RequestMapping("/openApi")
public class OpenApiController {

    @Resource
    private OpenApiService openApiService;

    @GetMapping("/testFileStream")
    @Operation(summary = "测试文件流接口", description = "测试接口")
    public BaseResponse<String> testFileStream() {
        return BaseResponse.success(openApiService.testFileStream());
    }

}
