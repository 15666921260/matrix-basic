package com.matrix.common.enums.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登录状态枚举类
 * @author liuweizhong
 * @since 2024-02-11
 */
@Getter
@AllArgsConstructor
public enum LoginStatus {

    /**
     *
     */
    SUCCESS(200, "登录成功!"),
    ERROR(401, "用户名或密码错误!");


    private final Integer code;
    private final String message;

}
