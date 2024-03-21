package com.matrix.admin.system.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.admin.system.mappers.SysUserMapper;
import com.matrix.admin.system.service.SysUserService;
import com.matrix.common.enums.system.LoginStatus;
import com.matrix.common.enums.system.UserTypeEnum;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.utils.EncryptUtils;
import com.matrix.common.vo.system.LoginResultVo;
import com.matrix.common.vo.system.user.AddUserVo;
import com.matrix.common.vo.system.user.SysUserVo;
import com.matrix.common.vo.system.param.QueryUserParam;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
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

        String s = EncryptUtils.encryptMd5(password);
        if (s.equals(sysUser.getPassword())){
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

    @Override
    public SysUser getLoginUser() {
        return sysUserMapper.selectById((String) StpUtil.getLoginId());
    }

    @Override
    public String addUser(AddUserVo addUserVo) {
        if (StringUtils.isBlank(addUserVo.getUsername()) && StringUtils.isBlank(addUserVo.getPassword())) {
            return "error";
        }
        SysUser sysUser = new SysUser();
        addUserVo2SysUser(addUserVo, sysUser);
        this.save(sysUser);
        return "success";
    }

    @Override
    public String editUser(AddUserVo addUserVo) {
        if (StringUtils.isBlank(addUserVo.getId()) && StringUtils.isBlank(addUserVo.getUsername())
                && StringUtils.isBlank(addUserVo.getPassword())) {
            return "error";
        }
        SysUser sysUser = new SysUser();
        addUserVo2SysUser(addUserVo, sysUser);
        this.updateById(sysUser);
        return "success";
    }

    private void addUserVo2SysUser(AddUserVo addUserVo, SysUser sysUser) {
        if (StringUtils.isNotBlank(addUserVo.getId())) {
            sysUser.setId(addUserVo.getId());
        }
        sysUser.setUsername(addUserVo.getUsername());
        sysUser.setPassword(EncryptUtils.encryptMd5(addUserVo.getPassword()));
        sysUser.setNickName(addUserVo.getNickName());
        sysUser.setPhone(addUserVo.getPhone());
        if (StringUtils.isBlank(addUserVo.getUserType())) {
            addUserVo.setUserType(UserTypeEnum.NORMAL.getUserType());
        }
        sysUser.setUserType(addUserVo.getUserType());
    }
}
