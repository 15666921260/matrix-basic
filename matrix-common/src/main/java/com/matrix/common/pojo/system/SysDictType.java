package com.matrix.common.pojo.system;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 字典类型
 * @author liuweizhong
 * @since 2024-03-21
 */
@Data
@Table("sys_dict_type")
public class SysDictType {

    /**
     * id数据库自增
     */
    @Id(keyType = KeyType.Auto)
    @Column("id")
    private Integer id;

    /**
     * 字典类型名
     */
    @Column("type_name")
    private String typeName;

    /**
     * 是否需要枚举类， true 需要， false 不需要
     */
    @Column("need_enum")
    private Boolean needEnum;

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

    /**
     * 是否禁用 true禁用 false 不禁用
     */
    @Column("disable")
    private Boolean disable;

}
