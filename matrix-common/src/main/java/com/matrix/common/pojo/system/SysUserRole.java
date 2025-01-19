package com.matrix.common.pojo.system;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户角色关联实体类
 * @author liuweizhong
 * @since 2024-04-16
 */
@Data
@Table("sys_user_role")
public class SysUserRole {

    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    @Column("id")
    private String id;

    @Column("user_id")
    private String userId;

    @Column("role_id")
    private Long roleId;

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
