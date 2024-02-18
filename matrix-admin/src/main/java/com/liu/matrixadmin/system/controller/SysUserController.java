package com.liu.matrixadmin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.liu.matrixadmin.system.service.SysUserService;
import com.liu.matrixcommon.enums.HttpStatus;
import com.liu.matrixcommon.enums.system.LoginStatus;
import com.liu.matrixcommon.pojo.basic.BaseResponse;
import com.liu.matrixcommon.pojo.system.SysUser;
import com.liu.matrixcommon.utils.ResultUtils;
import com.liu.matrixcommon.vo.LoginResultVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 登录接口
     * @param username 用户名
     * @param password 密码
     * @return 返回的信息
     */
    @PostMapping("/login")
    public BaseResponse<LoginResultVo> login(@RequestParam("username") String username,
                                             @RequestParam("password") String password){
        LoginResultVo login = sysUserService.login(username, password);
        LoginStatus loginStatus = login.getLoginStatus();
        return ResultUtils.build(loginStatus.getCode(), loginStatus.getMessage(), login);
    }

    @GetMapping("/test")
    public BaseResponse<List<SysUser>> test(){
        return ResultUtils.success(sysUserService.queryAllUser());
    }
    @GetMapping("/isLogin")
    public BaseResponse<String> isLogin(){
        return ResultUtils.success("是否登录："+StpUtil.isLogin());
    }



}
