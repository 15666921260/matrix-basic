package com.matrix.common.dto.oj;

import lombok.Data;

/**
 * 题目用例
 * @author liuweizhong
 * @since 2024-10-13 20:34
 */
@Data
public class JudgeCase {
    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;
}
