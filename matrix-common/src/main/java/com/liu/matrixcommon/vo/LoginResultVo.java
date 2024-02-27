package com.liu.matrixcommon.vo;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.liu.matrixcommon.enums.system.LoginStatus;
import com.liu.matrixcommon.pojo.system.SysUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 登录成功返回实体类
 * @author liuweizhong
 * @since 2024-02-11
 */
@Data
@Schema(name = "LoginResultVo", description = "登录成功返回实体类")
public class LoginResultVo {

    /**
     * 登录权限id
     */
    @Schema(name = "loginId", description = "登录权限id")
    private Integer loginId;

    @Schema(name = "tokenInfo", description = "sa-token的信息")
    private SaTokenInfo tokenInfo;

    @Schema(name = "token", description = "token的内容")
    private String token;

    @Schema(name = "sysUserVo", description = "用户对象")
    private SysUserVo sysUserVo;

    /**
     * 登录状态
     */
    @Schema(name = "loginStatus", description = "登录状态")
    private LoginStatus loginStatus;

    /**
     * 权限集合
     */
    @Schema(name = "auths", description = "权限列表")
    private List<String> auths;

}
