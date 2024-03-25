package com.matrix.common.vo.system.param;

import com.matrix.common.vo.basic.PageQueryBaseParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liuweizhong
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "QueryDictItemParam", description = "分页查询字典项接口")
public class QueryDictItemParam extends PageQueryBaseParam {

    @Schema(name = "typeName", description = "字典类型名id")
    private Integer typeId;

}
