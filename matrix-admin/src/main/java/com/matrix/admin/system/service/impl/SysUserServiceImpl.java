package com.matrix.admin.system.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.admin.system.mappers.SysUserMapper;
import com.matrix.admin.system.service.SysUserService;
import com.matrix.common.enums.system.LoginStatus;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.vo.system.LoginResultVo;
import com.matrix.common.vo.system.SysUserVo;
import com.matrix.common.vo.system.param.QueryUserParam;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public LoginResultVo login(String username, String password) {
        SysUser sysUser = sysUserMapper.queryByUsername(username);
        LoginResultVo resultVo = new LoginResultVo();
        if (Objects.isNull(sysUser)){
            resultVo.setLoginStatus(LoginStatus.ERROR);
            return resultVo;
        }

        if (password.equals(sysUser.getPassword())){
            StpUtil.login(sysUser.getId());
            resultVo.setUsername(sysUser.getUsername());
            resultVo.setNickName(sysUser.getNickName());
            resultVo.setAvatarFileId(sysUser.getAvatarFileId());
            resultVo.setLoginId(sysUser.getId());
            resultVo.setLoginStatus(LoginStatus.SUCCESS);
            // 此方法可以用于获取登录用户的信息 StpUtil.getTokenInfo()
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            resultVo.setToken(tokenInfo.getTokenValue());
        }else {
            resultVo.setLoginStatus(LoginStatus.ERROR);
        }
        return resultVo;
    }

    @Override
    public List<SysUser> queryAllUser() {
        return sysUserMapper.queryAllUser();
    }

    @Override
    public PageInfo<SysUserVo> queryUserList(QueryUserParam queryUserParam, String userId) {
        // 只有紧跟着PageHelper.startPage(pageNum,pageSize)的sql语句才被pagehelper起作用
        PageHelper.startPage(queryUserParam.getPageNum(), queryUserParam.getPageSize());
        List<SysUserVo> sysUserVos = sysUserMapper.queryUserList(queryUserParam);
        return new PageInfo<>(sysUserVos);
    }
}
