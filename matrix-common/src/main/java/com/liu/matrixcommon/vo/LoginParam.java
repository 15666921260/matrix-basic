package com.liu.matrixcommon.vo;

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

}
