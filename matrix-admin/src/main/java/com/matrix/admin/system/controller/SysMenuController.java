package com.matrix.admin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.matrix.admin.system.mappers.SysMenuMapper;
import com.matrix.admin.system.service.SysMenuService;
import com.matrix.admin.system.service.SysRoleMenuService;
import com.matrix.common.vo.basic.TreeData;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.vo.basic.response.ListResponse;
import com.matrix.common.vo.system.menu.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统菜单-权限管理
 * @author liuweizhong
 * @since 2024-03-12
 */
@Tag(name = "SysMenuController", description = "系统菜单管理(菜单的设置功能)")
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 获取当前用户的导航菜单
     * 采用目录-菜单-权限的设计方式，在获取菜单树时通过关联查询即可获取用户可访问到的菜单目录，可以使前端菜单与目录不在进行权限校验。
     * 只需对权限(按钮)进行校验
     * @return 菜单
     */
    @GetMapping("/getMenuTreeList")
    @Operation(summary = "获取当前用户的导航菜单")
    public ListResponse<SysMenuTreeVo> getMenuTreeList() {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        List<SysMenuTreeVo> list = sysMenuService.getMenuTreeListByLoginUser(loginId);
        return ListResponse.success(list);
    }

    /**
     * 根据父id获取菜单列表
     * @return 菜单列表
     */
    @GetMapping("/getAllMenuListVo")
    @Operation(summary = "获取菜单list")
    public BaseResponse<List<SysMenuListVo>> getAllMenuListVo() {
        return BaseResponse.success(sysMenuService.getAllMenuListVo());
    }

    /**
     * 获取树形下拉菜单
     * @return 菜单列表
     */
    @GetMapping("/getMenuTreeSelect")
    @Operation(summary = "获取树形下拉菜单")
    public ListResponse<MenuTreeSelect> getMenuTreeSelect() {
        return ListResponse.success(sysMenuService.getMenuTreeSelect());
    }

    @PostMapping("/addOrEditMenu")
    @Operation(summary = "新增或编辑菜单")
    public BaseResponse<String> addOrEditMenu(@RequestBody SysMenuDetail menuDetail){
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        return BaseResponse.success(sysMenuService.addOrEditMenu(menuDetail, loginId));
    }

    @GetMapping("/getMenuDetailById")
    @Operation(summary = "获取菜单详情")
    public BaseResponse<SysMenuDetail> getMenuDetailById(@RequestParam("menuId") Long menuId){
        return BaseResponse.success(sysMenuService.getMenuDetailById(menuId));
    }

    @GetMapping("/deleteById")
    @Operation(summary = "删除指定菜单")
    public BaseResponse<String> deleteById(@RequestParam("menuId") Long menuId){
        return BaseResponse.success(sysMenuService.deleteById(menuId));
    }

    @GetMapping("/getAllMenuTreeData")
    @Operation(summary = "获取菜单树形数据，用于编辑权限")
    public ListResponse<TreeData> getAllMenuTreeData() {
        return ListResponse.success(sysMenuService.getAllMenuTreeData());
    }

    @GetMapping("/getMenuCheckedKeys")
    @Operation(summary = "根据角色id获取选中菜单的id集合")
    public ListResponse<Long> getMenuCheckedKeys(@RequestParam("roleId") Long roleId) {
        return ListResponse.success(sysMenuService.getMenuCheckedKeys(roleId));
    }

    @PostMapping("/setRoleMenuAssociation")
    @Operation(summary = "设置角色和菜单的关联")
    public BaseResponse<String> setRoleMenuAssociation(@RequestBody RoleMenuAssociation roleMenu) {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        return BaseResponse.success(sysRoleMenuService.setRoleMenuAssociation(roleMenu, loginId));
    }

}
