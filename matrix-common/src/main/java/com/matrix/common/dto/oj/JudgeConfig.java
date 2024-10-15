package com.matrix.common.dto.oj;

import lombok.Data;

/**
 * 题目配置
 * @author liuweizhong
 * @since 2024-10-13 20:12
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制(ms)
     */
    private Long timeLimit;

    /**
     * 内存限制(KB)
     */
    private Long memoryLimit;

    /**
     * 堆栈限制(KB)
     */
    private Long stackLimit;
}
