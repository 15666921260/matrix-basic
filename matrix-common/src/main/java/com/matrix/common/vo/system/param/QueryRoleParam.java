package com.matrix.common.vo.system.param;

import com.matrix.common.vo.basic.PageQueryBaseParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询角色参数
 * @author liuweizhong
 * @since 2024-04-02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "QueryRoleParam", description = "分页查询角色参数")
public class QueryRoleParam extends PageQueryBaseParam {

    @Schema(name = "roleName", description = "角色名称")
    private String roleName;

}
