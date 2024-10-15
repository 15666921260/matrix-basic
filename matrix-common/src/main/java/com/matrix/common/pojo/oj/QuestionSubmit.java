package com.matrix.common.pojo.oj;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 题目提交
 * @author liuweizhong
 * @TableName question_submit
 */
@TableName(value ="question_submit")
@Data
public class QuestionSubmit implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 题目id
     */
    @TableField(value = "question_id")
    private Long questionId;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;

    /**
     * 判题信息
     */
    @TableField("judge_info")
    private Object judgeInfo;

    /**
     * 判题状态 0待判题 1判题中 2成功 3失败
     */
    private Integer status;

    /**
     * 创建用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 删除标识 1是 0否
     */
    @TableField(value = "is_delete")
    @TableLogic(value = "0", delval = "1")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}