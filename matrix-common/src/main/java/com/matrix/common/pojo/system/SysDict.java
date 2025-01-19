package com.matrix.common.pojo.system;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 字典类
 * @author liuweizhong
 * @since 2024-03-21
 */
@Data
@Table("sys_dict")
public class SysDict {

    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    @Column("id")
    private String id;

    /**
     * 字典类型
     */
    @Column("type")
    private Integer type;

    /**
     * 字典名
     */
    @Column("dic_name")
    private String dicName;

    /**
     * 字典值
     */
    @Column("dic_value")
    private String dicValue;

    /**
     * 排序字段
     */
    @Column("sort_num")
    private Integer sortNum;

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
