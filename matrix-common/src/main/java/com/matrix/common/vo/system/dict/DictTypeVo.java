package com.matrix.common.vo.system.dict;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 字典类型数据封装
 * @author liuweizhong
 * @since 2024-03-21
 */
@Data
@Schema(name = "DictTypeVo", description = "字典类型数据封装")
public class DictTypeVo {

    @Schema(name = "id", description = "字典类型主键")
    private Integer id;

    @Schema(name = "typeName", description = "字典类型名")
    private String typeName;

    /**
     * 是否需要枚举类， true 需要， false 不需要
     */
    @Schema(name = "needEnum", description = "是否需要枚举类")
    private Boolean needEnum;

    @Schema(name = "remarks", description = "备注")
    private String remarks;

    /**
     * 是否禁用 true禁用 false 不禁用
     */
    @Schema(name = "disable", description = "是否禁用")
    private Boolean disable = false;

}
