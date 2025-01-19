package com.matrix.common.pojo.system;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 系统菜单实体类
 * @author liuweizhong
 * @since 2024-03-12
 */
@Data
@Table("sys_menu")
public class SysMenu {

    /**
     * id数据库自增
     */
    @Id(keyType = KeyType.Auto)
    @Column("id")
    private Long id;

    /**
     * 名称
     */
    @Column("title")
    private String title;

    /**
     * 父级id
     */
    @Column("parent_id")
    private Long parentId;

    /**
     * 菜单类型，1：目录，2：菜单，3：权限(按钮)
     */
    @Column("type")
    private Integer type;

    /**
     * 菜单编码(权限编码)
     */
    @Column("code")
    private String code;

    /**
     * 前端路由地址
     */
    @Column("route_url")
    private String routeUrl;

    /**
     * 重定向
     */
    @Column("route_redirect")
    private String routeRedirect;

    /**
     * 组件路径
     */
    @Column("component_path")
    private String componentPath;

    /**
     * 菜单图标
     */
    @Column("icon")
    private String icon;

    /**
     * 排序
     */
    @Column("sort")
    private Integer sort;

    /**
     * 状态，0：禁用，1：启用
     */
    @Column("status")
    private Boolean status;

    /**
     * 是否显示,0：不显示，1：显示
     */
    @Column("hidden")
    private Boolean hidden;

    @Column("remarks")
    private String remarks;

    @Column("create_id")
    private String createId;

    @Column("create_time")
    private LocalDateTime createTime;

    @Column("update_id")
    private String updateId;

    @Column("update_time")
    private LocalDateTime updateTime;

    @Column(value="deleted", isLogicDelete = true)
    private Integer deleted;

}
