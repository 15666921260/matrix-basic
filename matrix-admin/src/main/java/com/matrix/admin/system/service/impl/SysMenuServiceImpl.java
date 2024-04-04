package com.matrix.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matrix.admin.system.mappers.SysDictMapper;
import com.matrix.admin.system.mappers.SysMenuMapper;
import com.matrix.admin.system.mappers.SysUserMapper;
import com.matrix.admin.system.service.SysMenuService;
import com.matrix.common.enums.system.MenuTypeEnum;
import com.matrix.common.enums.system.UserTypeEnum;
import com.matrix.common.pojo.system.SysMenu;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.vo.system.menu.SysMenuListVo;
import com.matrix.common.vo.system.menu.SysMenuTreeVo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author liuweizhong
 * @since 2024-03-12
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysMenuTreeVo> getMenuTreeListByLoginUser(String userId) {
        if (StringUtils.isBlank(userId)){
            return new ArrayList<>();
        }
        List<SysMenuTreeVo> sysMenuTreeVos;
        // 判断是否是超级管理员
        SysUser sysUser = sysUserMapper.selectById(userId);
        if (Objects.nonNull(sysUser) && UserTypeEnum.ADMIN.getTypeId().equals(sysUser.getUserType())){
            sysMenuTreeVos = sysMenuMapper.getNotDisabledAllMenu();
        }else {
            sysMenuTreeVos = sysMenuMapper.getMenuByUserRole(userId);
        }
        return buildMenuTree(0L, sysMenuTreeVos);
    }

    /**
     * 构建菜单树
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

    @Override
    public List<SysMenuListVo> getMenuListVoByParentId(Long parentId) {
        List<SysMenuListVo> menuListVo = sysMenuMapper.getMenuListVoByParentId(parentId);
        for (SysMenuListVo listVo:menuListVo){
            if (listVo.getWithItem() > 0) {
                listVo.setIsChild(Boolean.TRUE);
            } else {
                listVo.setIsChild(Boolean.FALSE);
            }
            MenuTypeEnum menuByType = MenuTypeEnum.getMenuByType(listVo.getType());
            if (Objects.nonNull(menuByType)) {
                listVo.setTypeStr(menuByType.getTypeName());
            }
        }
        return menuListVo;
    }

}
