package com.matrix.admin.system.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matrix.common.pojo.system.SysMenu;
import com.matrix.common.vo.system.SysMenuTreeVo;

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

}
