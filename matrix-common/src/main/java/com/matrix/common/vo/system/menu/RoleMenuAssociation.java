package com.matrix.common.vo.system.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 角色菜单关联封装类
 * @author liuweizhong
 * @since 2024-04-14
 */
@Data
@Schema(description = "角色菜单关联封装类")
public class RoleMenuAssociation {
    @Schema(name = "menuIds", description = "菜单ids")
    private List<Long> menuIds;
    @Schema(name = "roleId", description = "角色id")
    private Long roleId;
}
