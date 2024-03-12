package com.matrix.common.pojo.system;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@Data
@TableName("sys_user")
public class SysUser {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("phone")
    private String phone;

    @TableField("nick_name")
    private String nickName;

    @TableField("real_name")
    private String realName;

    @TableField("avatar_file_id")
    private String avatarFileId;

    @TableField("user_type")
    private String userType;

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
