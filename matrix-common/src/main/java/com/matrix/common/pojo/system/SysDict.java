package com.matrix.common.pojo.system;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 字典类
 * @author liuweizhong
 * @since 2024-03-21
 */
@Data
@TableName("sys_dict")
public class SysDict {

    /**
     * id数据库自增
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 字典类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 字典名
     */
    @TableField("dic_name")
    private String dicName;

    /**
     * 字典值
     */
    @TableField("dic_value")
    private String dicValue;

    /**
     * 排序字段
     */
    @TableField("sort_num")
    private Integer sortNum;

    @TableField("remarks")
    private String remarks;

    @TableField("create_id")
    private String createId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_id")
    private String updateId;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableLogic(value="0",delval="1")
    private Integer deleted;

    /**
     * 是否禁用 true禁用 false 不禁用
     */
    @TableField("disable")
    private Boolean disable;
}
