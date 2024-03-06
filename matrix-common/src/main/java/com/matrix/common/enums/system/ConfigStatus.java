package com.matrix.common.enums.system;

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
    // base64加密次数配置 intValue 大于等于1
    ENCRYPT_BASE_REPEAT("", 1)
    ;


    private final String strValue;
    private final Integer intValue;
}
