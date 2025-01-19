package com.matrix.admin.system.mappers;

import com.matrix.common.pojo.system.SysRole;
import com.matrix.common.vo.system.role.RoleVo;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-03-12
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据角色名模糊查询角色信息
     * @param roleName 角色名
     * @return 返回值
     */
    List<RoleVo> selectByRoleName(@Param("roleName") String roleName);

    /**
     * 查询所有角色信息
     * @return 结果集
     */
    List<RoleVo> queryAllRoleVo();

    /**
     * 根据用户id查询角色信息
     * @param userId 用户
     * @return 角色信息
     */
    List<RoleVo> queryRoleVoByUserId(@Param("userId") String userId);

}
