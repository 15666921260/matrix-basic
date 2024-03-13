package com.matrix.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matrix.admin.system.mappers.SysMenuMapper;
import com.matrix.admin.system.service.SysMenuService;
import com.matrix.common.pojo.system.SysMenu;
import com.matrix.common.vo.system.SysMenuTreeVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuweizhong
 * @since 2024-03-12
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenuTreeVo> getMenuTreeListByLoginUser(String userId) {
        List<SysMenuTreeVo> sysMenuTreeVos = sysMenuMapper.getNotDisabledAllMenu();
        return buildMenuTree(0L, sysMenuTreeVos);
    }

    /**
     * 构建菜单树 todo 待修改
     * @param parentId 父级id
     * @param sysMenuTreeVos 系统菜单集合
     * @return 菜单树
     */
    private List<SysMenuTreeVo> buildMenuTree(Long parentId, List<SysMenuTreeVo> sysMenuTreeVos) {
        return sysMenuTreeVos.stream()
                .filter(vo -> vo.getParentId().equals(parentId))
                .map(item -> {
                    item.setChildren(buildMenuTree(item.getId(), sysMenuTreeVos));
                    return item;
                })
                .collect(Collectors.toList());
    }
}