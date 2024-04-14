package com.matrix.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matrix.admin.system.mappers.SysMenuMapper;
import com.matrix.admin.system.mappers.SysUserMapper;
import com.matrix.admin.system.service.SysMenuService;
import com.matrix.common.enums.SysDefault;
import com.matrix.common.enums.system.MenuTypeEnum;
import com.matrix.common.enums.system.UserTypeEnum;
import com.matrix.common.pojo.system.SysMenu;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.vo.basic.TreeData;
import com.matrix.common.vo.system.menu.MenuTreeSelect;
import com.matrix.common.vo.system.menu.SysMenuDetail;
import com.matrix.common.vo.system.menu.SysMenuListVo;
import com.matrix.common.vo.system.menu.SysMenuTreeVo;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
                .peek(item -> item.setChildren(buildMenuTree(item.getId(), sysMenuTreeVos)))
                .collect(Collectors.toList());
    }

    @Override
    public List<SysMenuListVo> getAllMenuListVo() {
        List<SysMenuListVo> menuListVo = sysMenuMapper.getAllMenuListVo();
        for (SysMenuListVo listVo:menuListVo){
            MenuTypeEnum menuByType = MenuTypeEnum.getMenuByType(listVo.getType());
            if (Objects.nonNull(menuByType)) {
                listVo.setTypeStr(menuByType.getTypeName());
            }
        }
        return buildMenuListTree(0L, menuListVo);
    }

    @Override
    public List<MenuTreeSelect> getMenuTreeSelect() {
        List<SysMenuListVo> allMenuListVo = sysMenuMapper.getAllMenuListVo();
        List<MenuTreeSelect> res = new ArrayList<>();
        List<MenuTreeSelect> treeSelects = buildTreeSelectByMenuList(0L, allMenuListVo);
        MenuTreeSelect menuTreeSelect = new MenuTreeSelect();
        menuTreeSelect.setValue(0L);
        menuTreeSelect.setLabel("根节点");
        menuTreeSelect.setChildren(treeSelects);
        res.add(menuTreeSelect);
        return res;
    }

    private List<MenuTreeSelect> buildTreeSelectByMenuList(Long parentId, List<SysMenuListVo> sysMenuTreeVos) {
        List<MenuTreeSelect> treeSelects = new ArrayList<>();
        List<SysMenuListVo> collect = sysMenuTreeVos.stream().filter(vo -> vo.getParentId().equals(parentId)).toList();
        for (SysMenuListVo listVo:collect) {
            MenuTreeSelect treeSelect = new MenuTreeSelect();
            treeSelect.setValue(listVo.getId());
            treeSelect.setLabel(listVo.getTitle());
            treeSelect.setChildren(buildTreeSelectByMenuList(listVo.getId(), sysMenuTreeVos));
            treeSelects.add(treeSelect);
        }
        return treeSelects;
    }

    private List<SysMenuListVo> buildMenuListTree(Long parentId, List<SysMenuListVo> sysMenuTreeVos) {
        return sysMenuTreeVos.stream()
                .filter(vo -> vo.getParentId().equals(parentId))
                .peek(item -> item.setChildren(buildMenuListTree(item.getId(), sysMenuTreeVos)))
                .collect(Collectors.toList());
    }

    @Override
    public String addOrEditMenu(SysMenuDetail menuDetail, String loginId) {
        SysMenu menu = new SysMenu();
        menu.setId(menuDetail.getId());
        menu.setParentId(menuDetail.getParentId());
        menu.setCode(menuDetail.getCode());
        menu.setIcon(menuDetail.getIcon());
        menu.setHidden(menuDetail.getHidden());
        menu.setTitle(menuDetail.getTitle());
        menu.setType(menuDetail.getType());
        menu.setStatus(menuDetail.getStatus());
        menu.setSort(menuDetail.getSort());
        menu.setRouteUrl(menuDetail.getRouteUrl());
        menu.setRouteRedirect(menuDetail.getRouteRedirect());
        menu.setComponentPath(menuDetail.getComponentPath());
        menu.setRemarks(menuDetail.getRemarks());
        LocalDateTime now = LocalDateTime.now();
        if (Objects.isNull(menuDetail.getId())) {
            menu.setCreateId(loginId);
            menu.setCreateTime(now);
            menu.setUpdateId(loginId);
            menu.setUpdateTime(now);
            sysMenuMapper.insert(menu);
        }else {
            menu.setUpdateId(loginId);
            menu.setUpdateTime(now);
            sysMenuMapper.updateById(menu);
        }
        return SysDefault.SUCCESS.getValue();
    }

    @Override
    public SysMenuDetail getMenuDetailById(Long menuId) {
        SysMenu sysMenu = sysMenuMapper.selectById(menuId);
        SysMenuDetail detail = new SysMenuDetail();
        detail.setId(sysMenu.getId());
        detail.setParentId(sysMenu.getParentId());
        detail.setTitle(sysMenu.getTitle());
        detail.setType(sysMenu.getType());
        MenuTypeEnum menuByType = MenuTypeEnum.getMenuByType(sysMenu.getType());
        if (Objects.nonNull(menuByType)){
            detail.setTypeStr(menuByType.getTypeName());
        }
        detail.setStatus(sysMenu.getStatus());
        detail.setCode(sysMenu.getCode());
        detail.setIcon(sysMenu.getIcon());
        detail.setSort(sysMenu.getSort());
        detail.setRouteUrl(sysMenu.getRouteUrl());
        detail.setRouteRedirect(sysMenu.getRouteRedirect());
        detail.setComponentPath(sysMenu.getComponentPath());
        detail.setHidden(sysMenu.getHidden());
        detail.setRemarks(sysMenu.getRemarks());
        return detail;
    }

    @Override
    public String deleteById(Long menuId) {
        sysMenuMapper.deleteById(menuId);
        return SysDefault.SUCCESS.getValue();
    }

    @Override
    public List<TreeData> getAllMenuTreeData() {
        List<SysMenuListVo> allMenuListVo = sysMenuMapper.getAllMenuListVo();
        return this.buildBaseMenuTreeData(0L, allMenuListVo);
    }

    /**
     * 设置基础的TreeData的树形数据
     * @param parentId 父id
     * @param sysMenuTreeVos 菜单
     * @return 结果集
     */
    private List<TreeData> buildBaseMenuTreeData(Long parentId, List<SysMenuListVo> sysMenuTreeVos) {
        List<TreeData> treeDataList = new ArrayList<>();
        sysMenuTreeVos.stream().filter(vo -> vo.getParentId().equals(parentId)).forEach(vo -> {
            TreeData treeData = new TreeData();
            treeData.setId(vo.getId());
            treeData.setLabel(vo.getTitle());
            treeData.setChildren(buildBaseMenuTreeData(vo.getId(), sysMenuTreeVos));
            treeDataList.add(treeData);
        });
        return treeDataList;
    }

    @Override
    public List<Long> getMenuCheckedKeys(Long roleId) {
        List<SysMenuListVo> menuList = sysMenuMapper.getMenuListByRoleId(roleId);
        return menuList.stream().map(SysMenuListVo::getId).collect(Collectors.toList());
    }
}
