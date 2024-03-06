package com.matrix.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户前端展示类
 * @author liuweizhong
 * @since 2024-02-28
 */
@Data
@Schema(name = "SysUserVo", description = "用户展示封装类")
public class SysUserVo {

    @Schema(name = "id", description = "用户id")
    private Integer id;
    @Schema(name = "username", description = "用户名")
    private String username;
    @Schema(name = "phone", description = "用户手机号")
    private String phone;
    @Schema(name = "nickName", description = "用户昵称")
    private String nickName;
    @Schema(name = "realName", description = "用户真实姓名")
    private String realName;
    @Schema(name = "userType", description = "用户类型")
    private String userType;
    @Schema(name = "remarks", description = "备注")
    private String remarks;

}
