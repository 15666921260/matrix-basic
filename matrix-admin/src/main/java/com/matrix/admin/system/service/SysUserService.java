package com.matrix.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.vo.system.LoginResultVo;
import com.matrix.common.vo.system.SysUserVo;
import com.matrix.common.vo.system.param.QueryUserParam;
import org.springframework.web.bind.annotation.RequestBody;

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

    /**
     * 查询用户列表
     * @param queryUserParam 查询参数
     * @param userId 当前登录用户的id
     * @return 返回的数据
     */
    PageInfo<SysUserVo> queryUserList(QueryUserParam queryUserParam, String userId);
}
