package com.matrix.common.pojo.system;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @author liuweizhong
 * @since 2024-02-28
 */
@Data
@TableName("sys_role")
public class SysRole {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("auth_name")
    private String roleName;

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
}
