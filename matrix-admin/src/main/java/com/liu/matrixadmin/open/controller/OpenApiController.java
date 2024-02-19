package com.liu.matrixadmin.open.controller;

import com.liu.matrixadmin.open.service.OpenApiService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开放接口控制层
 * @author liuweizhong
 * @since 2024-02-11
 */
@Tag(name = "开放接口")
@RestController
@RequestMapping("/openApi")
public class OpenApiController {

    @Resource
    private OpenApiService openApiService;


}
