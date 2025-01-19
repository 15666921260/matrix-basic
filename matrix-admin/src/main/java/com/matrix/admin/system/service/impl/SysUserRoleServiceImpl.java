package com.matrix.admin.system.service.impl;

import com.matrix.admin.system.mappers.SysUserRoleMapper;
import com.matrix.admin.system.service.SysUserRoleService;
import com.matrix.common.pojo.system.SysUserRole;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户角色关联服务
 * @author liuweizhong
 * @since 2024-04-16
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
}
