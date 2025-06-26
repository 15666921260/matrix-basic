package com.matrix.admin.system.service;

import com.matrix.common.pojo.system.SysRole;
import com.matrix.common.vo.system.param.QueryRoleParam;
import com.matrix.common.vo.system.role.RoleVo;
import com.matrix.common.vo.system.role.UserRoleAssociation;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;

import java.util.List;

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
    Page<RoleVo> pageRoleVo(QueryRoleParam param);

    /**
     * 添加或者编辑角色
     * @param roleVo 角色
     * @param userId 用户id
     * @return 结果
     */
    String addOrEditRole(RoleVo roleVo, String userId);

    /**
     * 删除指定的角色
     * @param roleVo 要删除的角色
     * @return 处理结果
     */
    String deleteRole(RoleVo roleVo);

    /**
     * 查询所有的角色
     * @return 角色集合
     */
    List<RoleVo> queryAllRoleVo();

    /**
     * 查询用户的角色
     * @param userId 用户id
     * @return 角色集合
     */
    List<RoleVo> queryRoleVoByUserId(String userId);

    /**
     * 查询用户的角色ids
     * @param userId 用户id
     * @return 角色id集合
     */
    List<Long> queryRoleIdByUserId(String userId);

    /**
     * 保存用户角色关联
     * @param userRoleAssociation 用户角色关联
     * @param loginId 登录id
     * @return 返回结果
     */
    String saveUserRoleAssociation(UserRoleAssociation userRoleAssociation, String loginId);
}
