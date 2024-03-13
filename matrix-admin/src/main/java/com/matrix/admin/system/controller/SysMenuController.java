package com.matrix.admin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.matrix.admin.system.service.SysMenuService;
import com.matrix.common.vo.basic.BaseResponse;
import com.matrix.common.vo.system.SysMenuTreeVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     *
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

}