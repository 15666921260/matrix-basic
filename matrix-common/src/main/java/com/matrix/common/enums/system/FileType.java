package com.matrix.common.enums.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文件类型枚举
 * @author liuweizhong
 * @since 2024-03-10
 */
@Getter
@AllArgsConstructor
public enum FileType {

    /**
     * 代表没有类型
     */
    NONE("none");

    private final String fileType;
}
