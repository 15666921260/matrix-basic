package com.matrix.common.pojo.system;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @author liuweizhong
 * @since 2024-02-28
 */
@Data
@Table("sys_role")
public class SysRole {

    @Id(keyType = KeyType.Auto)
    @Column("id")
    private Long id;

    @Column("role_name")
    private String roleName;

    @Column("role_type")
    private String roleType;

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
