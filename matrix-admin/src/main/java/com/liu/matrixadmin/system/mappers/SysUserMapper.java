package com.liu.matrixadmin.system.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.matrixcommon.pojo.system.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//import org.apache.ibatis.annotations.Param;
/**
 * @author liuweizhong
 * @since 2024-02-11
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    SysUser queryByUsername(@Param("username") String username);

    /**
     * 查询全部用户数据
     * @return 查询全部用户数据结果
     */
    List<SysUser> queryAllUser();
}
