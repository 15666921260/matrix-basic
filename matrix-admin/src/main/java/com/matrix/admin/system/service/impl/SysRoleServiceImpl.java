package com.matrix.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.admin.system.mappers.SysRoleMapper;
import com.matrix.admin.system.service.SysRoleService;
import com.matrix.common.pojo.system.SysRole;
import com.matrix.common.vo.system.param.QueryRoleParam;
import com.matrix.common.vo.system.role.RoleVo;
import com.matrix.common.vo.system.user.SysUserVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
