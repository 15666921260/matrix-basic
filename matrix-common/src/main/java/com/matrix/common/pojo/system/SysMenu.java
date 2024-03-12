package com.matrix.common.pojo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 系统菜单实体类
 * @author liuweizhong
 * @since 2024-03-12
 */
@Data
public class SysMenu {

    /**
     * id数据库自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    @TableField("title")
    private String title;

    /**
     * 父级id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 菜单类型，1：目录，2：菜单，3：权限(按钮)
     */
    @TableField("type")
    private Integer type;

    /**
     * 菜单编码
     */
    @TableField("code")
    private String code;

    /**
     * 前端路由地址
     */
    @TableField("route_url")
    private String routeUrl;

    /**
     * 重定向
     */
    @TableField("route_redirect")
    private String routeRedirect;

    /**
     * 组件路径
     */
    @TableField("component_path")
    private String componentPath;

    /**
     * 菜单图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 状态，0：禁用，1：启用
     */
    @TableField("status")
    private Boolean status;

    /**
     * 是否显示,0：不显示，1：显示
     */
    @TableField("hidden")
    private Boolean hidden;

    @TableField("remarks")
    private String remarks;

    @TableField("create_id")
    private String createId;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_id")
    private String updateId;

    @TableField("update_time")
    private Date updateTime;

    @TableLogic(value="0",delval="1")
    private Integer deleted;

}
