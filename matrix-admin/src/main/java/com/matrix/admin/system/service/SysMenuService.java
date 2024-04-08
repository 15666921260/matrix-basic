package com.matrix.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matrix.common.pojo.system.SysMenu;
import com.matrix.common.vo.system.menu.MenuTreeSelect;
import com.matrix.common.vo.system.menu.SysMenuDetail;
import com.matrix.common.vo.system.menu.SysMenuListVo;
import com.matrix.common.vo.system.menu.SysMenuTreeVo;

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

    /**
     * 获取菜单列表根据父id
     * @return 菜单列表
     */
    List<SysMenuListVo> getAllMenuListVo();

    /**
     * 获取树形下拉菜单
     * @return 结果
     */
    List<MenuTreeSelect> getMenuTreeSelect();

    /**
     * 新增或编辑菜单
     * @param menuDetail 新增或编辑的数据
     * @param loginId 登录用户的id
     * @return 结果
     */
    String addOrEditMenu(SysMenuDetail menuDetail, String loginId);

    /**
     * 根据id获取详情
     * @param menuId 菜单id
     * @return 结果
     */
    SysMenuDetail getMenuDetailById(Long menuId);

    /**
     * 根据菜单id删除菜单
     * @param menuId 菜单id
     * @return 处理结果
     */
    String deleteById(Long menuId);
}
