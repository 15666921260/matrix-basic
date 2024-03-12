package com.matrix.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matrix.common.pojo.system.SysMenu;
import com.matrix.common.vo.system.SysMenuTreeVo;

import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-03-12
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 根据当前登录用户获取菜单树
     * @param userId 用户id
     * @return 菜单树
     */
    List<SysMenuTreeVo> getMenuTreeListByLoginUser(String userId);

}
