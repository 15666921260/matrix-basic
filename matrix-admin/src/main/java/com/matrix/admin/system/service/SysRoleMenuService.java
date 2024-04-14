package com.matrix.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matrix.common.pojo.system.SysRoleMenu;
import com.matrix.common.vo.system.menu.RoleMenuAssociation;

/**
 * 角色关联service
 * @author liuweizhong
 * @since 2024-04-14
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 设置角色和菜单的关联
     * @param roleMenu 角色菜单关联类
     * @return 返回结果
     */
    String setRoleMenuAssociation(RoleMenuAssociation roleMenu, String loginId);

}
