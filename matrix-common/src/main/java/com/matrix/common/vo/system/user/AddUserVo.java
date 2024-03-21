package com.matrix.common.vo.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 添加用户数据封装类
 * @author liuweizhong
 * @since 2024-03-21
 */
@Data
@Schema(name = "AddUserVo", description = "添加用户数据封装类")
public class AddUserVo {
    @Schema(name = "id", description = "主键")
    private String id;
    @Schema(name = "username", description = "用户名")
    private String username;
    @Schema(name = "password", description = "密码")
    private String password;
    @Schema(name = "nickName", description = "用户昵称")
    private String nickName;
    @Schema(name = "phone", description = "用户手机号")
    private String phone;
    @Schema(name = "realName", description = "用户真实姓名")
    private String realName;
    @Schema(name = "userType", description = "用户类型")
    private String userType;
}
