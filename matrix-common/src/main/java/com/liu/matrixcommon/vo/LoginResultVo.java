package com.liu.matrixcommon.vo;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.liu.matrixcommon.enums.HttpStatus;
import com.liu.matrixcommon.enums.system.LoginStatus;
import com.liu.matrixcommon.pojo.system.SysUser;
import lombok.Data;

import java.util.List;

/**
 * 登录成功返回实体类
 * @author liuweizhong
 * @since 2024-02-11
 */
@Data
public class LoginResultVo {

    /**
     * 登录权限id
     */
    private Integer loginId;

    private SaTokenInfo tokenInfo;

    private SysUser sysUser;

    /**
     * 登录状态
     */
    private LoginStatus loginStatus;

    /**
     * 权限集合
     */
    private List<String> auths;

}
