package com.matrix.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.admin.system.mappers.SysRoleMapper;
import com.matrix.admin.system.mappers.SysUserRoleMapper;
import com.matrix.admin.system.service.SysRoleService;
import com.matrix.admin.system.service.SysUserRoleService;
import com.matrix.common.enums.SysDefault;
import com.matrix.common.pojo.system.SysRole;
import com.matrix.common.pojo.system.SysUserRole;
import com.matrix.common.vo.system.param.QueryRoleParam;
import com.matrix.common.vo.system.role.RoleVo;
import com.matrix.common.vo.system.role.UserRoleAssociation;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author liuweizhong
 * @since 2024-03-12
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysUserRoleService sysUserRoleService;

    @Override
    public PageInfo<RoleVo> pageRoleVo(QueryRoleParam param) {
        Page<RoleVo> page = PageHelper.startPage(param.getPageNum(), param.getPageSize())
                .doSelectPage(() -> sysRoleMapper.selectByRoleName(param.getRoleName()));
        return page.toPageInfo();
    }

    @Override
    public String addOrEditRole(RoleVo roleVo, String userId) {
        LocalDateTime now = LocalDateTime.now();
        if (Objects.isNull(roleVo.getId())) {
            SysRole sysRole = new SysRole();
            this.roleVo2SysRole(sysRole, roleVo, now, userId);
            sysRole.setCreateId(userId);
            sysRole.setCreateTime(now);
            this.save(sysRole);
        } else {
            SysRole sysRole = sysRoleMapper.selectById(roleVo.getId());
            if (Objects.isNull(sysRole)) {
                sysRole = new SysRole();
                roleVo.setId(null);
                sysRole.setCreateId(userId);
                sysRole.setCreateTime(now);
            }
            this.roleVo2SysRole(sysRole, roleVo, now, userId);
            this.saveOrUpdate(sysRole);
        }
        return SysDefault.SUCCESS.getValue();
    }

    @Override
    public String deleteRole(RoleVo roleVo) {
        sysRoleMapper.deleteById(roleVo.getId());
        return SysDefault.SUCCESS.getValue();
    }

    /**
     * roleVo到SysRole转换
     * @param roleVo 待转换数据
     * @param sysRole 转换结果数据
     * @param dateTime 时间
     * @param userId 登录用户的id
     */
    private void roleVo2SysRole(SysRole sysRole, RoleVo roleVo, LocalDateTime dateTime, String userId) {
        sysRole.setId(roleVo.getId());
        sysRole.setRoleName(roleVo.getRoleName());
        sysRole.setRoleType(roleVo.getRoleType());
        sysRole.setRemarks(roleVo.getRemarks());
        sysRole.setUpdateId(userId);
        sysRole.setUpdateTime(dateTime);
    }

    @Override
    public List<RoleVo> queryAllRoleVo() {
        return sysRoleMapper.queryAllRoleVo();
    }

    @Override
    public List<RoleVo> queryRoleVoByUserId(String userId) {
        return sysRoleMapper.queryRoleVoByUserId(userId);
    }

    @Override
    public List<Long> queryRoleIdByUserId(String userId) {
        return sysUserRoleMapper.queryRoleIdByUserId(userId);
    }

    @Override
    public String saveUserRoleAssociation(UserRoleAssociation userRoleAssociation, String loginId) {
        String userId = userRoleAssociation.getUserId();
        if (StringUtils.isBlank(userId)) {
            return "当前用户id为空，无法进行继续进行操作";
        }
        // 已关联的角色id集合
        List<Long> longs = sysUserRoleMapper.queryRoleIdByUserId(userId);
        // 当前关联的角色id集合
        List<Long> roleIds = userRoleAssociation.getRoleIds();
        // 获取两者共有的数据
        List<Long> pubRoleId = longs.stream().filter(roleIds::contains).toList();

        // 要添加的关联
        List<Long> addList = roleIds.stream().filter(x -> !pubRoleId.contains(x)).toList();
        // 要删除的关联
        List<Long> deleteList = longs.stream().filter(x -> !pubRoleId.contains(x)).toList();

        // 添加操作
        List<SysUserRole> sysUserRoleList = buildUserRoleAssociation(userId, addList, loginId);
        sysUserRoleService.saveBatch(sysUserRoleList);
        // 删除操作
        if (CollectionUtils.isNotEmpty(deleteList)) {
            sysUserRoleMapper.deleteByUserIdAndRoleIds(userId, deleteList);
        }
        return SysDefault.SUCCESS.getValue();
    }

    private List<SysUserRole> buildUserRoleAssociation(String userId, List<Long> roleIds, String loginId) {
        LocalDateTime now = LocalDateTime.now();
        return roleIds.stream().map(roleId -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRole.setCreateId(loginId);
            userRole.setCreateTime(now);
            return userRole;
        }).collect(Collectors.toList());
    }

}
