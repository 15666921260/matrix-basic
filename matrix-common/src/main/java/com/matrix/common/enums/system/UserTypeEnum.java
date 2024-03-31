package com.matrix.common.enums.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型 枚举类
 * @author liuweizhong
 * @since 2024-03-17
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

    /**
     * 超级管理员
     */
    ADMIN("admin", "超级管理员"),
    /**
     * 普通用户
     */
    NORMAL("normal", "普通用户")
    ;

    private final String userType;

    private final String typeName;
}
