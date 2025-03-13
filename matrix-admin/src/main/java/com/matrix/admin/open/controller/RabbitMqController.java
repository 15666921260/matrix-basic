package com.matrix.admin.open.controller;

import com.matrix.admin.open.service.RabbitMqService;
import com.matrix.common.enums.open.TypeStr;
import com.matrix.common.vo.basic.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweizhong
 * @since 2025-03-05 22:21
 */
@Tag(name = "RabbitMqControllerApi", description = "测试RabbitMq开放接口")
@RestController
@RequestMapping("/openApi/rabbitMq")
public class RabbitMqController {

    @Resource
    private RabbitMqService rabbitMqService;

    @GetMapping("/baseProducer")
    @Operation(summary = "测试生产者", description = "测试生产者")
    public BaseResponse<String> baseProducer(@RequestParam("stuId") TypeStr stuId) {
        return BaseResponse.success(rabbitMqService.baseProducer(stuId));
    }

}
