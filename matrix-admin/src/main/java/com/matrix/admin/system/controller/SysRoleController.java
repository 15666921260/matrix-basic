package com.matrix.admin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.matrix.admin.system.service.SysRoleService;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.vo.basic.response.PageResponse;
import com.matrix.common.vo.system.param.QueryRoleParam;
import com.matrix.common.vo.system.role.RoleVo;
import com.matrix.common.vo.system.role.UserRoleAssociation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/queryAllRoleVo")
    @Operation(summary = "查询所有角色")
    public BaseResponse<List<RoleVo>> queryAllRoleVo() {
        return BaseResponse.success(sysRoleService.queryAllRoleVo());
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

    @GetMapping("/queryRoleVoByUserId")
    @Operation(summary = "根据用户id查询角色")
    public BaseResponse<List<RoleVo>> queryRoleVoByUserId(@RequestParam("userId") String userId) {
        return BaseResponse.success(sysRoleService.queryRoleVoByUserId(userId));
    }

    @GetMapping("/queryRoleIdByUserId")
    @Operation(summary = "根据用户id查询角色id集合")
    public BaseResponse<List<Long>> queryRoleIdByUserId(@RequestParam("userId") String userId) {
        return BaseResponse.success(sysRoleService.queryRoleIdByUserId(userId));
    }

    @PostMapping("/saveUserRoleAssociation")
    @Operation(summary = "保存用户角色关联关系")
    public BaseResponse<String> saveUserRoleAssociation(@RequestBody UserRoleAssociation userRoleAssociation) {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        return BaseResponse.success(sysRoleService.saveUserRoleAssociation(userRoleAssociation, loginId));
    }
}
