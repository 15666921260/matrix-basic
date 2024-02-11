package com.liu.matrixadmin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.matrixcommon.pojo.system.SysUser;
import com.liu.matrixcommon.vo.LoginResultVo;

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
     * @return
     */
    LoginResultVo login(String username, String password);

    /**
     * 查询全部用户
     * @return 查询全部用户
     */
    List<SysUser> queryAllUser();
}
