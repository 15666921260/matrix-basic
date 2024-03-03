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
    @Schema(name = "loginId", description = "登录权限id")
    private Integer loginId;
    @Schema(name = "token", description = "token的内容")
    private String token;
    @Schema(name = "username", description = "用户名")
    private String username;
    @Schema(name = "nickName", description = "昵称")
    private String nickName;
    @Schema(name = "avatar", description = "头像")
    private String avatar;
    @Schema(name = "loginStatus", description = "登录状态")
    private LoginStatus loginStatus;
    @Schema(name = "auths", description = "权限列表")
    private List<String> auths;

}
