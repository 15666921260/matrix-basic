package com.matrix.common.dto.oj;

import lombok.Data;

/**
 * 判题信息
 * @author liuweizhong
 * @since 2024-10-14 01:35
 */
@Data
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存(KB)
     */
    private Long memoryLimit;

    /**
     * 消耗时间
     */
    private Long time;
}
