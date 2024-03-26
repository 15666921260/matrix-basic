package com.matrix.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 删除字段的枚举
 * @author liuweizhong
 * @since 2024-03-27
 */
@Getter
@AllArgsConstructor
public enum DeletedEnum {

    /**
     *
     */
    DELETE_YES(0, "未删除"),
    DELETE_NO(1, "已删除");

    private final Integer value;
    private final String name;
}
