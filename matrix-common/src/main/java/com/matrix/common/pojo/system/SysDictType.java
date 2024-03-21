package com.matrix.common.pojo.system;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 字典类型
 * @author liuweizhong
 * @since 2024-03-21
 */
@Data
@TableName("sys_dict_type")
public class SysDictType {

    /**
     * id数据库自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字典类型名
     */
    @TableField("type_name")
    private String typeName;

    /**
     * 是否需要枚举类， true 需要， false 不需要
     */
    @TableField("need_enum")
    private Boolean needEnum;

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
