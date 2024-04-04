package com.matrix.common.vo.system.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 菜单列表展示类
 * @author liuweizhong
 * @since 2024-04-04
 */
@Data
@Schema(description = "菜单列表展示类")
public class SysMenuListVo {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "菜单名称")
    private String title;

    @Schema(description = "菜单类型，1：目录，2：菜单，3：权限")
    private Integer type;

    @Schema(description = "菜单类型，目录，菜单，权限")
    private String typeStr;

    @Schema(description = "状态，0：禁用，1：启用")
    private Boolean status;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "前端路由地址")
    private String routeUrl;

    @Schema(description = "组件路径")
    private String componentPath;

    @Schema(description = "是否显示在菜单栏,0：不显示，1：显示")
    private Boolean hidden;

    @Schema(description = "修改时间")
    private Date updateTime;

    @Schema(description = "子项个数")
    private Integer withItem;

    @Schema(description = "是否有子项")
    private Boolean isChild;

}
