package com.matrix.admin.system.mappers;

import com.matrix.common.pojo.system.SysRoleMenu;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单mapper
 * @author liuweizhong
 * @since 2024-04-14
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 删除角色菜单关联项，根据roleId和menuId集合
     * @param roleId roleId
     * @param menuIds menuId集合
     */
    void deleteByRoleIdAndMenuIds(@Param("roleId") Long roleId, @Param("menuIds") List<Long> menuIds);

}
