package com.matrix.admin.system.mappers;

import com.matrix.common.pojo.system.SysUserRole;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-04-16
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 根据用户ID，获取角色ID列表
     * @param userId 用户ID
     * @return 角色列表
     */
    List<Long> queryRoleIdByUserId(@Param("userId") String userId);

    /**
     * 删除用户和角色关联
     * @param userId 用户id
     * @param roleIds 角色ids
     */
    void deleteByUserIdAndRoleIds(@Param("userId") String userId, @Param("roleIds") List<Long> roleIds);
}
