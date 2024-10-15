package com.matrix.admin.oj.controller;

import com.matrix.admin.oj.service.QuestionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweizhong
 * @since 2024-10-13 10:12
 */
@Tag(name = "QuestionController", description = "题目相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;



}
