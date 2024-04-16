package com.matrix.common.vo.system.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 用户角色关联封装类
 * @author liuweizhong
 * @since 2024-04-16
 */
@Data
@Schema(description = "用户角色关联封装类")
public class UserRoleAssociation {
    @Schema(name = "userId", description = "用户id")
    private String userId;
    @Schema(name = "roleIds", description = "角色ids")
    private List<Long> roleIds;
}
