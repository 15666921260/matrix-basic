package com.matrix.admin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
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

    @PostMapping("/addOrEditRole")
    @Operation(summary = "添加或编辑角色")
    public BaseResponse<String> addOrEditRole(@RequestBody RoleVo roleVo){
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        return BaseResponse.success(sysRoleService.addOrEditRole(roleVo, loginId));
    }

    @PostMapping("/deleteRole")
    @Operation(summary = "删除指定角色")
    public BaseResponse<String> deleteRole(@RequestBody RoleVo roleVo){
        return BaseResponse.success(sysRoleService.deleteRole(roleVo));
    }

}
