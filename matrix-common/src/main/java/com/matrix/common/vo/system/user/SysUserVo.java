package com.matrix.common.vo.system.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 用户前端展示类
 * @author liuweizhong
 * @since 2024-02-28
 */
@Data
@Schema(name = "SysUserVo", description = "用户展示封装类")
public class SysUserVo {
    @Schema(name = "id", description = "用户id")
    private String id;
    @Schema(name = "username", description = "用户名")
    private String username;
    @Schema(name = "nickName", description = "用户昵称")
    private String nickName;
    @Schema(name = "phone", description = "用户手机号")
    private String phone;
    @Schema(name = "realName", description = "用户真实姓名")
    private String realName;
    @Schema(name = "userType", description = "用户类型")
    private String userType;
    @Schema(name = "createTime", description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @Schema(name = "updateTime", description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
