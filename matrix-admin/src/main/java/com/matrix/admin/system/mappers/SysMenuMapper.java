package com.matrix.admin.system.mappers;

import com.matrix.common.pojo.system.SysMenu;
import com.matrix.common.vo.system.menu.SysMenuListVo;
import com.matrix.common.vo.system.menu.SysMenuTreeVo;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-03-12
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 获取全部未禁用的菜单
     * @return 系统菜单集合
     */
    List<SysMenuTreeVo> getNotDisabledAllMenu();

    /**
     * 根据用户角色获取菜单列表
     * @param userId 用户id
     * @return 菜单列表
     */
    List<SysMenuTreeVo> getMenuByUserRole(@Param("userId") String userId);

    /**
     * 根据父id获取菜单列表
     * @param parentId 父id
     * @return 菜单列表
     */
    List<SysMenuListVo> getMenuListVoByParentId(@Param("parentId") Long parentId);

    /**
     * 根据ids获取菜单列表
     * @param ids ids
     * @return 列表集合
     */
    List<SysMenuTreeVo> getMenuListVoByIds(@Param("ids") List<Long> ids);

    /**
     * 获取全部菜单与权限列表
     * @return 菜单列表
     */
    List<SysMenuListVo> getAllMenuListVo();

    /**
     * 根据角色id返回菜单集合
     * @param roleId 角色id
     * @return 返回结果
     */
    List<SysMenuListVo> getMenuListByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据用户id获取权限码集合
     * @param userId 用户id
     * @return 权限码集合
     */
    List<String> getPermissionCodesByUserId(@Param("userId") String userId);

    /**
     * 获取所有权限码
     * @return 权限码集合
     */
    List<String> getAllPermissionCodes();
}
