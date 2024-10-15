package com.matrix.admin.oj.controller;

import cn.hutool.http.server.HttpServerRequest;
import com.matrix.admin.oj.service.QuestionSubmitService;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.vo.oj.QuestionSubmitVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweizhong
 * @since 2024-10-13 10:14
 */
@Tag(name = "QuestionSubmitController", description = "题目提交相关接口")
@RestController
@RequestMapping("/question/submit")
public class QuestionSubmitController {
    @Resource
    private QuestionSubmitService questionSubmitService;

    @PostMapping("/submit/question")
    @Operation(summary = "提交题目", description = "提交题目")
    public BaseResponse<String> submitQuestion(@RequestBody QuestionSubmitVo questionSubmit, HttpServerRequest request) {
        return BaseResponse.success(questionSubmitService.submitQuestion(questionSubmit));
    }

}
