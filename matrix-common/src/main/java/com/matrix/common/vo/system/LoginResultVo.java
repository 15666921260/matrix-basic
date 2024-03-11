package com.matrix.common.vo.system;

import com.matrix.common.enums.system.LoginStatus;
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
    private String loginId;
    @Schema(name = "token", description = "token的内容")
    private String token;
    @Schema(name = "username", description = "用户名")
    private String username;
    @Schema(name = "nickName", description = "昵称")
    private String nickName;
    @Schema(name = "avatarFileId", description = "头像文件id")
    private String avatarFileId;
    @Schema(name = "loginStatus", description = "登录状态")
    private LoginStatus loginStatus;
    @Schema(name = "auths", description = "权限列表")
    private List<String> auths;

}
