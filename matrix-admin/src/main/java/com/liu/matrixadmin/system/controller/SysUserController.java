package com.liu.matrixadmin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.liu.matrixadmin.system.service.SysUserService;
import com.liu.matrixcommon.enums.system.LoginStatus;
import com.liu.matrixcommon.pojo.basic.BaseResponse;
import com.liu.matrixcommon.pojo.system.SysUser;
import com.liu.matrixcommon.vo.LoginParam;
import com.liu.matrixcommon.vo.LoginResultVo;
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
