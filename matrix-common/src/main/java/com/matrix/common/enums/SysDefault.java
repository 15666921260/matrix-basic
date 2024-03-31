package com.matrix.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统默认值
 * @author liuweizhong
 * @since 2024-03-31
 */
@Getter
@AllArgsConstructor
public enum SysDefault {

    /**
     * 系统默认密码，加密后的
     */
    PASSWORD("系统默认密码", "634d6cb6778c4f2d1d2470ff898d0430");

    private final String illustrate;

    private final String value;

}
