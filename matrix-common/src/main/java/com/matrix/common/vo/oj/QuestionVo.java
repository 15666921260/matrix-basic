package com.matrix.common.vo.oj;

import com.matrix.common.dto.oj.JudgeCase;
import com.matrix.common.dto.oj.JudgeConfig;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-10-15 00:43
 */
@Data
public class QuestionVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表(json数组)
     */
    private List<String> tags;

    /**
     * 答案
     */
    private String answer;

    /**
     * 判题配置
     */
    private JudgeConfig judgeConfig;

    /**
     * 判题用例
     */
    private List<JudgeCase> judgeCase;

}
