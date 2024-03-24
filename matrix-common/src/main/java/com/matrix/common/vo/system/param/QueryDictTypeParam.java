package com.matrix.common.vo.system.param;

import com.matrix.common.vo.basic.PageQueryBaseParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询字典类型接口
 * @author liuweizhong
 * @since 2024-03-24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "QueryDictTypeParam", description = "分页查询字典类型接口")
public class QueryDictTypeParam extends PageQueryBaseParam {

    @Schema(name = "typeName", description = "字典类型名")
    private String typeName;

}
