package com.matrix.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.matrix.common.pojo.system.SysRole;
import com.matrix.common.vo.system.param.QueryRoleParam;
import com.matrix.common.vo.system.role.RoleVo;

/**
 * @author liuweizhong
 * @since 2024-03-12
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页查询角色
     * @param param 查询参数
     * @return 返回数据
     */
    PageInfo<RoleVo> pageRoleVo(QueryRoleParam param);

    /**
     * 添加或者编辑角色
     * @param roleVo 角色
     * @param userId 用户id
     * @return 结果
     */
    String addOrEditRole(RoleVo roleVo, String userId);
}
