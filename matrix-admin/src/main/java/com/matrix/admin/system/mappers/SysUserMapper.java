package com.matrix.admin.system.mappers;

import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.vo.system.user.AddUserVo;
import com.matrix.common.vo.system.user.SysUserVo;
import com.matrix.common.vo.system.param.QueryUserParam;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liuweizhong
 * @since 2024-02-11
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户实体类
     */
    SysUser queryByUsername(@Param("username") String username);

    /**
     * 查询全部用户数据
     * @return 查询全部用户数据结果
     */
    List<SysUser> queryAllUser();

    /**
     * 检测 username是否在数据库中存在
     * @param username
     * @return
     */
    Integer checkUserName(@Param("username") String username);

    /**
     * 根据userId查询数据
     * @param userId 条件
     * @return 结果
     */
    AddUserVo addUserVoById(@Param("userId") String userId);

}
