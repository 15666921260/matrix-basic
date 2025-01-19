package com.matrix.common.vo.system.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 角色展示类
 * @author liuweizhong
 * @since 2024-04-02
 */
@Data
@Schema(name = "RoleVo", description = "角色展示类")
public class RoleVo {

    @Schema(name = "id", description = "id")
    private Long id;

    @Schema(name = "roleName", description = "角色名")
    private String roleName;

    @Schema(name = "roleType", description = "角色类型字典id")
    private String roleType;

    @Schema(name = "roleTypeStr", description = "角色类型字符值")
    private String roleTypeStr;

    @Schema(name = "remarks", description = "备注")
    private String remarks;

    @Schema(name = "createTime", description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
