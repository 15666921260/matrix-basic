package com.matrix.admin.system.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matrix.common.pojo.system.SysMenu;
import com.matrix.common.vo.system.menu.SysMenuListVo;
import com.matrix.common.vo.system.menu.SysMenuTreeVo;
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
     * 获取全部菜单列表
     * @return 菜单列表
     */
    List<SysMenuListVo> getAllMenuListVo();
}
