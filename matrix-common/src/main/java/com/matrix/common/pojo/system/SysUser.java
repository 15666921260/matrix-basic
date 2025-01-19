package com.matrix.common.pojo.system;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@Data
@Table("sys_user")
public class SysUser {

    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    @Column("id")
    private String id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("phone")
    private String phone;

    @Column("nick_name")
    private String nickName;

    @Column("real_name")
    private String realName;

    @Column("avatar_file_id")
    private String avatarFileId;

    @Column("user_type")
    private String userType;

    @Column("remarks")
    private String remarks;

    @Column("create_id")
    private String createId;

    @Column("create_time")
    private LocalDateTime createTime;

    @Column("update_id")
    private String updateId;

    @Column("update_time")
    private LocalDateTime updateTime;

    @Column(value="deleted", isLogicDelete = true)
    private Integer deleted;

}
