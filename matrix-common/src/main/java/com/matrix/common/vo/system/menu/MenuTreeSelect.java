package com.matrix.common.vo.system.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 下拉树形选择
 * @author liuweizhong
 * @since 2024-04-08
 */
@Data
@Schema(description = "下拉树形选择")
public class MenuTreeSelect {
    @Schema(name = "value", description = "菜单id")
    private Long value;
    @Schema(name = "label", description = "菜单名称")
    private String label;
    @Schema(name = "children", description = "菜单名称")
    private List<MenuTreeSelect> children;
}
