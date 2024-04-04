package com.matrix.admin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.matrix.admin.system.service.SysMenuService;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.vo.system.menu.SysMenuListVo;
import com.matrix.common.vo.system.menu.SysMenuTreeVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统菜单管理
 * @author liuweizhong
 * @since 2024-03-12
 */
@Slf4j
@Tag(name = "SysMenuController", description = "系统菜单管理(菜单的设置功能)")
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;

    /**
     * 获取当前用户的导航菜单
     * 采用目录-菜单-权限的设计方式，在获取菜单树时通过关联查询即可获取用户可访问到的菜单目录，可以使前端菜单与目录不在进行权限校验。
     * 只需对权限(按钮)进行校验
     * @return 菜单
     */
    @GetMapping("/getMenuTreeList")
    @Operation(summary = "获取当前用户的导航菜单")
    public BaseResponse<List<SysMenuTreeVo>> getMenuTreeList() {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        List<SysMenuTreeVo> list = sysMenuService.getMenuTreeListByLoginUser(loginId);
        return BaseResponse.success(list);
    }

    /**
     * 根据父id获取菜单列表
     * @param parentId 父id
     * @return 菜单列表
     */
    @GetMapping("/getMenuListVoByParentId")
    @Operation(summary = "获取菜单list")
    public BaseResponse<List<SysMenuListVo>> getMenuListVoByParentId(@RequestParam("parentId") Long parentId) {
        return BaseResponse.success(sysMenuService.getMenuListVoByParentId(parentId));
    }

}
