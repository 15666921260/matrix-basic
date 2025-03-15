package com.matrix.admin.system.service.impl;

import com.matrix.admin.system.mappers.SysRoleMenuMapper;
import com.matrix.admin.system.service.SysMenuService;
import com.matrix.admin.system.service.SysRoleMenuService;
import com.matrix.common.enums.SysDefault;
import com.matrix.common.pojo.system.SysRoleMenu;
import com.matrix.common.utils.ThrowUtils;
import com.matrix.common.vo.system.menu.RoleMenuAssociation;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色关联service
 * @author liuweizhong
 * @since 2024-04-14
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Resource
    private SysMenuService sysMenuService;
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    @Transactional
    public String setRoleMenuAssociation(RoleMenuAssociation roleMenu, String loginId) {
        Long roleId = roleMenu.getRoleId();
        ThrowUtils.throwIf(roleId.equals(0L), "角色id为0，无效角色 -->检测是否正确传值");
        // 之前已选数据
        List<Long> menuCheckedKeys = sysMenuService.getMenuCheckedKeys(roleId);
        // 更新已选数据
        List<Long> menuIds = roleMenu.getMenuIds();

        // 获取两者共有的数据
        List<Long> pubMenuIds = menuIds.stream().filter(menuCheckedKeys::contains).toList();

        // 声明需要添加关联的菜单id集合  -- menuIds 有的 menuCheckedKeys 中没有的数据
        List<Long> addList = this.getListNotDataBySourceList(pubMenuIds, menuIds);
        // 声明需要取消关联的菜单id集合  -- menuCheckedKeys 有的 menuIds 中没有的数据
        List<Long> deleteList = this.getListNotDataBySourceList(pubMenuIds, menuCheckedKeys);
        // 添加操作
        List<SysRoleMenu> addSysRoleMenus = this.buildRoleMenuByAssociation(addList, roleId, loginId);
        this.saveBatch(addSysRoleMenus);
        // 删除操作
        if(CollectionUtils.isNotEmpty(deleteList)) {
            sysRoleMenuMapper.deleteByRoleIdAndMenuIds(roleId, deleteList);
        }

        return SysDefault.SUCCESS.getValue();
    }

    /**
     * 构建关联实体类集合
     * @param associationData 关联数据
     * @param roleId 角色id
     * @param loginId 操作用户
     * @return 实体类集合
     */
    private List<SysRoleMenu> buildRoleMenuByAssociation(List<Long> associationData, Long roleId, String loginId){
        List<SysRoleMenu> res = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        associationData.forEach(x -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(roleId);
            sysRoleMenu.setMenuId(x);
            sysRoleMenu.setCreateId(loginId);
            sysRoleMenu.setCreateTime(now);
            res.add(sysRoleMenu);
        });
        return res;
    }

    /**
     * 获取在sourceList中不存在的dataList的数据
     * @param sourceList sourceList
     * @param dataList dataList
     * @return 结果集
     */
    private List<Long> getListNotDataBySourceList(List<Long> sourceList, List<Long> dataList){
        List<Long> res = new ArrayList<>();
        dataList.forEach(x -> {
            if (!sourceList.contains(x)) {
                res.add(x);
            }
        });
        return res;
    }
}
