package com.matrix.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 特殊字符枚举
 * @author liuweizhong
 * @since 2024-02-04
 */
@Getter
@AllArgsConstructor
public enum SpecialStrEnum {

    /**
     *
     */
    POINT("."),
    /**
     * split 方法使用
     */
    POINT_SPLIT("\\.");

    private final String str;

}
