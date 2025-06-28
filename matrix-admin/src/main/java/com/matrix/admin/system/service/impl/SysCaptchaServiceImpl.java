package com.matrix.admin.system.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.IdUtil;
import com.matrix.admin.middleware.RedisService;
import com.matrix.admin.system.service.SysCaptchaService;
import com.matrix.common.vo.system.captcha.CaptchaVo;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author liuweizhong
 * @since 2025-03-17 00:11
 */
@Service
public class SysCaptchaServiceImpl implements SysCaptchaService {
    @Resource
    private RedisService redisService;

    @Override
    public CaptchaVo getCaptcha(String captchaId) {
        // 如果有旧验证码覆盖掉旧验证码
        String newCaptchaId = StringUtils.isNotBlank(captchaId) ? captchaId : IdUtil.getSnowflakeNextIdStr();
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(180, 80);
        String imageBase64 = lineCaptcha.getImageBase64();
        CaptchaVo captchaVo = new CaptchaVo(imageBase64, newCaptchaId);
        redisService.saveData(newCaptchaId, lineCaptcha.getCode(), 60);
        return captchaVo;
    }
}
