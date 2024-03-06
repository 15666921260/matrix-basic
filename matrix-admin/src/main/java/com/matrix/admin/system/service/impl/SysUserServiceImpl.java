package com.matrix.admin.system.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matrix.admin.system.mappers.SysUserMapper;
import com.matrix.admin.system.service.SysUserService;
import com.matrix.common.enums.system.LoginStatus;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.vo.LoginResultVo;
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
            resultVo.setAvatar(sysUser.getAvatar());
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
}
