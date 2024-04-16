package com.matrix.common.pojo.system;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户角色关联实体类
 * @author liuweizhong
 * @since 2024-04-16
 */
@Data
@TableName("sys_user_role")
public class SysUserRole {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField("user_id")
    private String userId;

    @TableField("role_id")
    private Long roleId;

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
