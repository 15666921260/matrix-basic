package com.matrix.common.vo.system.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 菜单详情类
 * @author liuweizhong
 * @since 2024-04-05
 */
@Data
@Schema(description = "菜单详情类")
public class SysMenuDetail {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "父级id")
    private Long parentId;
    @Schema(description = "菜单名")
    private String title;
    @Schema(description = "菜单类型")
    private Integer type;
    @Schema(description = "菜单类型字符串")
    private String typeStr;
    @Schema(description = "状态是否禁用")
    private Boolean status;
    @Schema(description = "菜单编码(权限编码)")
    private String code;
    @Schema(description = "菜单图标")
    private String icon;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "前端路由地址")
    private String routeUrl;
    @Schema(description = "重定向路由地址")
    private String routeRedirect;
    @Schema(description = "组件位置路径")
    private String componentPath;
    @Schema(description = "是否显示")
    private Boolean hidden;
    @Schema(description = "备注")
    private String remarks;
}
