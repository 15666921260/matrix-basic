package com.matrix.admin.config;

import cn.dev33.satoken.stp.StpInterface;
import com.matrix.admin.system.mappers.SysMenuMapper;
import com.matrix.admin.system.mappers.SysRoleMapper;
import com.matrix.common.vo.system.role.RoleVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuweizhong
 * @since 2025-03-16 05:00
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;

    /**
     * 获取权限列表
     * @param loginIdOb 登录账号id
     * @param s 登录账号类型
     * @return 权限列表
     */
    @Override
    public List<String> getPermissionList(Object loginIdOb, String s) {
        String loginId = (String) loginIdOb;
        return sysMenuMapper.getPermissionCodesByUserId(loginId);
    }

    /**
     * 获取角色列表, 角色id的字符串列表
     * @param loginIdOb 登录账号id
     * @param s 登录账号类型
     * @return 角色列表
     */
    @Override
    public List<String> getRoleList(Object loginIdOb, String s) {
        String loginId = (String) loginIdOb;
        List<RoleVo> roleVos = sysRoleMapper.queryRoleVoByUserId(loginId);
        return roleVos.stream().map(RoleVo::getId).map(String::valueOf).collect(Collectors.toList());
    }
}
