package com.matrix.admin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.matrix.admin.system.service.SysUserService;
import com.matrix.common.enums.system.LoginStatus;
import com.matrix.common.pojo.basic.BaseResponse;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.utils.EncryptUtils;
import com.matrix.common.vo.LoginParam;
import com.matrix.common.vo.LoginResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@Slf4j
@Tag(name = "SysUserControllerApi", description = "用户管理")
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 登录接口
     * @param loginParam 用户名
     * @return 返回的信息
     */
    @Operation(summary = "登录接口")
    @PostMapping("/login")
    public BaseResponse<LoginResultVo> login(@RequestBody LoginParam loginParam){
        LoginResultVo login = sysUserService.login(loginParam.getUsername(), loginParam.getPassword());
        LoginStatus loginStatus = login.getLoginStatus();
        return BaseResponse.build(loginStatus.getCode(), loginStatus.getMessage(), login);
    }

    @Operation(summary = "退出登录接口")
    @PostMapping("/logOut")
    public BaseResponse<Boolean> logOut(){
        StpUtil.logout();
        return BaseResponse.success(Boolean.TRUE);
    }

    @Operation(summary = "测试")
    @GetMapping("/test")
    public BaseResponse<List<SysUser>> test(){
        return BaseResponse.success(sysUserService.queryAllUser());
    }
    @Operation(summary = "是否登录")
    @GetMapping("/isLogin")
    public BaseResponse<String> isLogin(){
        return BaseResponse.success("是否登录："+StpUtil.isLogin());
    }



}
