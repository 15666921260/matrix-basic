package com.matrix.admin.system.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.exceptions.ValidateException;
import com.matrix.admin.system.mappers.SysMenuMapper;
import com.matrix.admin.system.mappers.SysUserMapper;
import com.matrix.admin.system.service.SysUserService;
import com.matrix.common.enums.SysDefault;
import com.matrix.common.enums.system.LoginStatus;
import com.matrix.common.enums.system.UserTypeEnum;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.utils.EncryptUtils;
import com.matrix.common.utils.ThrowUtils;
import com.matrix.common.vo.system.LoginResultVo;
import com.matrix.common.vo.system.user.AddUserVo;
import com.matrix.common.vo.system.user.SysUserVo;
import com.matrix.common.vo.system.param.QueryUserParam;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static com.matrix.common.pojo.system.table.Tables.SYS_DICT;
import static com.matrix.common.pojo.system.table.Tables.SYS_USER;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;

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
        if (sysUser.getUserType().equals(UserTypeEnum.ADMIN.getTypeId())) {
            List<String> allPermissionCodes = sysMenuMapper.getAllPermissionCodes();
            resultVo.setPermissions(allPermissionCodes);
        } else {
            List<String> permissions = sysMenuMapper.getPermissionCodesByUserId(sysUser.getId());
            if (CollectionUtils.isNotEmpty(permissions)) {
                resultVo.setPermissions(permissions);
            }
        }
        return resultVo;
    }

    @Override
    public List<SysUser> queryAllUser() {
        return sysUserMapper.queryAllUser();
    }

    @Override
    public Page<SysUserVo> queryUserList(QueryUserParam queryUserParam, String userId) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(SYS_USER.ID, SYS_USER.USERNAME, SYS_USER.NICK_NAME, SYS_USER.PHONE, SYS_USER.REAL_NAME, SYS_USER.CREATE_TIME, SYS_USER.UPDATE_TIME)
                .select(SYS_DICT.DIC_NAME.as(SysUserVo::getUserType))
                .from(SYS_USER)
                .leftJoin(SYS_DICT).on(SYS_USER.USER_TYPE.eq(SYS_DICT.ID))
                .where(SYS_USER.USERNAME.like(queryUserParam.getUsername()))
                .orderBy(SYS_USER.CREATE_TIME.asc());
        if (StringUtils.isNotBlank(queryUserParam.getUsername())) {
            queryWrapper.where(SYS_USER.USERNAME.like(queryUserParam.getUsername()));
        }
        return sysUserMapper.paginateAs(queryUserParam.getPageNum(), queryUserParam.getPageSize(), queryWrapper, SysUserVo.class);
    }

    @Override
    public SysUser getLoginUser() {
        return sysUserMapper.selectOneById((String) StpUtil.getLoginId());
    }

    @Override
    public String addUser(AddUserVo addUserVo, String loginId) {
        ThrowUtils.throwIf(StringUtils.isBlank(addUserVo.getUsername()) && StringUtils.isBlank(addUserVo.getPassword()), "用户名或密码是空");
        SysUser sysUserDb = sysUserMapper.queryByUsername(addUserVo.getUsername());
        ThrowUtils.throwIf(Objects.nonNull(sysUserDb), "该用户名已存在");
        SysUser sysUser = new SysUser();
        addUserVo2SysUser(addUserVo, sysUser);
        LocalDateTime now = LocalDateTime.now();
        sysUser.setCreateId(loginId);
        sysUser.setCreateTime(now);
        sysUser.setUpdateId(loginId);
        sysUser.setUpdateTime(now);
        this.save(sysUser);
        return  SysDefault.SUCCESS.getValue();
    }

    @Override
    public String editUser(AddUserVo addUserVo, String loginId) {
        boolean isAllNull = StringUtils.isBlank(addUserVo.getId()) && StringUtils.isBlank(addUserVo.getUsername())
                && StringUtils.isBlank(addUserVo.getPassword());
        ThrowUtils.throwIf(isAllNull, "用户名或密码是空");
        SysUser sysUserDb = sysUserMapper.queryByUsername(addUserVo.getUsername());
        ThrowUtils.throwIf(Objects.nonNull(sysUserDb) && !sysUserDb.getId().equals(addUserVo.getId()), "该用户名已存在");
        SysUser sysUser = new SysUser();
        LocalDateTime now = LocalDateTime.now();
        addUserVo2SysUser(addUserVo, sysUser);
        sysUser.setUpdateId(loginId);
        sysUser.setUpdateTime(now);
        this.updateById(sysUser);
        return  SysDefault.SUCCESS.getValue();
    }

    @Override
    public AddUserVo detailUserById(SysUserVo user) {
        return sysUserMapper.addUserVoById(user.getId());
    }

    @Override
    public String deleteUserById(SysUserVo user) {
        sysUserMapper.deleteById(user.getId());
        return SysDefault.SUCCESS.getValue();
    }

    @Override
    public String getTokenCode(String phone) {
        ThrowUtils.throwIfEmpty(phone, "手机号不能为空!");
        return "success";
    }

    private void addUserVo2SysUser(AddUserVo addUserVo, SysUser sysUser) {
        if (StringUtils.isNotBlank(addUserVo.getId())) {
            sysUser.setId(addUserVo.getId());
        }
        sysUser.setUsername(addUserVo.getUsername());
        if (StringUtils.isBlank(addUserVo.getPassword())) {
            sysUser.setPassword(SysDefault.PASSWORD.getValue());
        }else {
            sysUser.setPassword(EncryptUtils.encryptMd5(addUserVo.getPassword()));
        }
        sysUser.setNickName(addUserVo.getNickName());
        sysUser.setPhone(addUserVo.getPhone());
        sysUser.setRealName(addUserVo.getRealName());
        sysUser.setRemarks(addUserVo.getRemarks());
        if (StringUtils.isBlank(addUserVo.getUserType())) {
            addUserVo.setUserType(UserTypeEnum.NORMAL.getUserType());
        }
        sysUser.setUserType(addUserVo.getUserTypeId());
    }
}
