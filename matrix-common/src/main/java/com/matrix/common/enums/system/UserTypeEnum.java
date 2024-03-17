package com.matrix.common.enums.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liuweizhong
 * @since 2024-03-17
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

    /**
     * 超级管理员
     */
    ADMIN("admin"),
    /**
     * 普通用户
     */
    NORMAL("normal")
    ;

    private final String userType;
}
