package com.liu.matrixcommon.enums.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局配置枚举
 * @author liuweizhong
 * @since 2024-02-27
 */
@Getter
@AllArgsConstructor
public enum ConfigStatus {
    /**
     *
     */
    // base64加密盐值配置 strValue
    ENCRYPT_BASE_SALT("Liu", 0),
    // base64加密次数配置 intValue
    ENCRYPT_BASE_REPEAT("", 2)
    ;


    private final String strValue;
    private final Integer intValue;
}
