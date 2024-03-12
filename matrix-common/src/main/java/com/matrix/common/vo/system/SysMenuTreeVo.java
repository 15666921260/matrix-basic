package com.matrix.common.vo.system;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 菜单用户树展示的实体类
 * @author liuweizhong
 * @since 2024-03-12
 */
@Data
public class SysMenuTreeVo {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "菜单名称")
    private String title;

    @Schema(description = "父id")
    private Long parentId;

    @Schema(description = "菜单编码")
    private String code;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "菜单类型，1：目录，2：菜单，3：权限")
    private Integer type;

    @Schema(description = "状态，0：禁用，1：启用")
    private Boolean status;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "前端路由地址")
    private String routeUrl;

    @Schema(description = "重定向")
    private String routeRedirect;

    @Schema(description = "组件路径")
    private String componentPath;

    @Schema(description = "是否显示,0：不显示，1：显示")
    private Boolean hidden;

    @Schema(description = "子菜单集合")
    private List<SysMenuTreeVo> children;

    @Schema(description = "创建人ID")
    private String createId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "修改人ID")
    private String updateId;

    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

}
