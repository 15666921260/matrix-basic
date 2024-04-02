package com.matrix.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.admin.system.mappers.SysRoleMapper;
import com.matrix.admin.system.service.SysRoleService;
import com.matrix.common.enums.SysDefault;
import com.matrix.common.pojo.system.SysRole;
import com.matrix.common.vo.system.param.QueryRoleParam;
import com.matrix.common.vo.system.role.RoleVo;
import com.matrix.common.vo.system.user.SysUserVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author liuweizhong
 * @since 2024-03-12
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public PageInfo<RoleVo> pageRoleVo(QueryRoleParam param) {
        // 只有紧跟着PageHelper.startPage(pageNum,pageSize)的sql语句才被pagehelper起作用
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<RoleVo> roleVos = sysRoleMapper.selectByRoleName(param.getRoleName());
        return new PageInfo<>(roleVos);
    }

    @Override
    public String addOrEditRole(RoleVo roleVo, String userId) {
        LocalDateTime now = LocalDateTime.now();
        if (Objects.isNull(roleVo.getId())) {
            SysRole sysRole = new SysRole();
            this.roleVo2SysRole(sysRole, roleVo, now, userId);
            sysRole.setCreateId(userId);
            sysRole.setCreateTime(now);
            sysRoleMapper.insert(sysRole);
        } else {
            SysRole sysRole = sysRoleMapper.selectById(roleVo.getId());
            this.roleVo2SysRole(sysRole, roleVo, now, userId);
            sysRoleMapper.updateById(sysRole);
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
     * @return 转换结果
     */
    private void roleVo2SysRole(SysRole sysRole, RoleVo roleVo, LocalDateTime dateTime, String userId) {
        sysRole.setId(roleVo.getId());
        sysRole.setRoleName(roleVo.getRoleName());
        sysRole.setRoleType(roleVo.getRoleType());
        sysRole.setRemarks(roleVo.getRemarks());
        sysRole.setUpdateId(userId);
        sysRole.setUpdateTime(dateTime);
    }

}
