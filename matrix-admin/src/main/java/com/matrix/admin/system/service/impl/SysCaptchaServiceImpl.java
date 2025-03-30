package com.matrix.admin.system.service.impl;

import cn.hutool.core.util.IdUtil;
import com.matrix.admin.middleware.RedisService;
import com.matrix.admin.system.service.SysCaptchaService;
import com.matrix.common.vo.system.captcha.CaptchaVo;
import jakarta.annotation.Resource;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liuweizhong
 * @since 2025-03-17 00:11
 */
@Service
public class SysCaptchaServiceImpl implements SysCaptchaService {
    @Resource
    private RedisService redisService;

    @Override
    public CaptchaVo getCaptcha() {
        String captchaId = IdUtil.getSnowflakeNextIdStr();
        String imgBase64 = "";

        CaptchaVo captchaVo = new CaptchaVo(imgBase64, captchaId);
        redisService.saveData(captchaId, "1234", 60);
        return captchaVo;
    }
}
