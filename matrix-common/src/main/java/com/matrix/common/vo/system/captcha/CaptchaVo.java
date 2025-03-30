package com.matrix.common.vo.system.captcha;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuweizhong
 * @since 2025-03-17 00:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaptchaVo {

    /**
     * 图片base64编码
     */
    private String imgBase64;

    /**
     * 验证码id
     */
    private String captchaId;

}
