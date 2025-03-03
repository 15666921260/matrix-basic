package com.matrix.admin.system.service;

import com.github.pagehelper.PageInfo;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.vo.system.LoginResultVo;
import com.matrix.common.vo.system.user.AddUserVo;
import com.matrix.common.vo.system.user.SysUserVo;
import com.matrix.common.vo.system.param.QueryUserParam;
import com.mybatisflex.core.service.IService;

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

    /**
     * 获取当前登录用户
     * @return 返回结果
     */
    SysUser getLoginUser();

    /**
     * 添加用户
     * @param addUserVo 添加的用户数据
     * @param loginId 登录用户的id
     * @return 返回值
     */
    String addUser(AddUserVo addUserVo, String loginId);

    /**
     * 修改用户
     * @param addUserVo 添加的用户数据
     * @param loginId 登录用户的id
     * @return 返回值
     */
    String editUser(AddUserVo addUserVo, String loginId);

    /**
     * 根据用户id查询详情
     * @param user 参数里边只有id有用
     * @return 结果
     */
    AddUserVo detailUserById(SysUserVo user);

    /**
     * 根据id删除用户
     * @param user 要删除的用户
     * @return 处理结果
     */
    String deleteUserById(SysUserVo user);


    String getTokenCode(String phone);
}
