package com.matrix.common.pojo.oj;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 题目表
 * @TableName question
 * @author liuweizhong
 * @since 2020-03-11
 */
@TableName(value ="question")
@Data
public class Question implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    private String tags;

    /**
     * 点赞数
     */
    @TableField(value = "thumb_num")
    private Integer thumbNum;

    /**
     * 收藏数
     */
    @TableField(value = "collect_num")
    private Integer favourNum;

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
     * 删除标识 1是0否
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    /**
     * 答案
     */
    private String answer;

    /**
     * 判题配置
     */
    @TableField(value = "judge_config")
    private String judgeConfig;

    /**
     * 判题用例
     */
    @TableField(value = "judge_case")
    private String judgeCase;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}