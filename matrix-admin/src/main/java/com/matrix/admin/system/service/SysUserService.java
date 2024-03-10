package com.matrix.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.vo.system.LoginResultVo;

import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 登录接口
     * @param username 用户名
     * @param password 密码
     * @return LoginResultVo
     */
    LoginResultVo login(String username, String password);

    /**
     * 查询全部用户
     * @return 查询全部用户
     */
    List<SysUser> queryAllUser();
}
