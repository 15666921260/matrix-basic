package com.matrix.common.vo.system.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author liuweizhong
 */
@Data
@Schema(name = "LoginParam", description = "登录参数封装类")
public class LoginParam {

    @Schema(name = "username", description = "用户名")
    private String username;
    @Schema(name = "password", description = "密码")
    private String password;
    @Schema(name = "captcha", description = "验证码")
    private String captcha;
    @Schema(name = "captchaId", description = "验证码id")
    private String captchaId;

}
