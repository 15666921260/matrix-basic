package com.matrix.common.vo.oj;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuweizhong
 * @since 2024-10-15 01:15
 */
@Data
public class QuestionSubmitVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;
}
