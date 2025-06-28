package com.matrix.admin.system.controller;

import com.matrix.admin.system.service.SysCaptchaService;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.vo.system.captcha.CaptchaVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweizhong
 * @since 2025-03-17 00:09
 */
@Tag(name = "SysCaptchaController", description = "验证码控制层")
@RestController
@RequestMapping("/captcha")
public class SysCaptchaController {
    @Resource
    private SysCaptchaService sysCaptchaService;

    /**
     * 图片验证码
     * @param captchaId 验证码id
     * @return 验证码存储对象
     */
    @GetMapping("/image/get")
    @Operation(summary = "获取验证码")
    public BaseResponse<CaptchaVo> getCaptcha(@RequestParam(value = "captchaId", required = false) String captchaId) {
        return BaseResponse.success(sysCaptchaService.getCaptcha(captchaId));
    }

}
