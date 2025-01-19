package com.matrix.common.vo.system.dict;

import com.mybatisflex.annotation.Column;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 字典展示类
 * @author liuweizhong
 * @since 2024-03-21
 */
@Data
@Schema(name = "DictVo", description = "字典展示类")
public class DictVo {

    @Schema(name = "id", description = "字典id")
    private String id;

    @Schema(name = "typeName", description = "字典类型名")
    private String typeName;

    @Schema(name = "type", description = "字典类型id")
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

    @Schema(name = "remarks", description = "备注")
    private String remarks;

    /**
     * 是否禁用 true禁用 false 不禁用
     */
    @Schema(name = "disable", description = "是否禁用")
    private Boolean disable = false;

}
