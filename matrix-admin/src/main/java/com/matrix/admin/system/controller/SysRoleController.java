package com.matrix.admin.system.controller;

import com.matrix.admin.system.service.SysRoleService;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.vo.basic.response.PageResponse;
import com.matrix.common.vo.system.param.QueryRoleParam;
import com.matrix.common.vo.system.role.RoleVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-03-12
 */
@Slf4j
@Tag(name = "SysRoleController", description = "系统角色管理(角色的设置功能)")
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @PostMapping("/pageRoleVo")
    @Operation(summary = "分页查询角色")
    public PageResponse<RoleVo> pageRoleVo(@RequestBody QueryRoleParam param) {
        return PageResponse.success(sysRoleService.pageRoleVo(param));
    }

}
