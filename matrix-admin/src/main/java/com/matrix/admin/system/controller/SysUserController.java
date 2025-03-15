package com.matrix.admin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.matrix.admin.system.service.SysUserService;
import com.matrix.common.enums.system.HttpStatus;
import com.matrix.common.enums.system.LoginStatus;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.pojo.system.SysUser;
import com.matrix.common.vo.basic.response.PageResponse;
import com.matrix.common.vo.system.user.AddUserVo;
import com.matrix.common.vo.system.user.SysUserVo;
import com.matrix.common.vo.system.param.LoginParam;
import com.matrix.common.vo.system.LoginResultVo;
import com.matrix.common.vo.system.param.QueryUserParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
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

    @GetMapping("/tokenCode")
    @Operation(summary = "获取验证码")
    public BaseResponse<String> getTokenCode(@RequestParam("phone") String phone) {
        if (StringUtils.isEmpty(phone)) {
            return BaseResponse.error(HttpStatus.ERROR.getCode(), "手机号不能为空");
        }
        return BaseResponse.success(sysUserService.getTokenCode(phone));
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

    @Operation(summary = "查询用户数据")
    @PostMapping("/queryUserList")
    public PageResponse<SysUserVo> queryUserList(@RequestBody QueryUserParam queryUserParam) {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        return PageResponse.success(sysUserService.queryUserList(queryUserParam, loginId));
    }

    @Operation(summary = "根据用户id查询详情")
    @PostMapping("/detailUserById")
    public BaseResponse<AddUserVo> detailUserById(@RequestBody SysUserVo user){
        return BaseResponse.success(sysUserService.detailUserById(user));
    }

    @Operation(summary = "添加用户")
    @PostMapping("/addUser")
    public BaseResponse<String> addUser(@RequestBody AddUserVo addUserVo) {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        return BaseResponse.success(sysUserService.addUser(addUserVo, loginId));
    }

    @Operation(summary = "修改用户")
    @PostMapping("/editUser")
    public BaseResponse<String> editUser(@RequestBody AddUserVo addUserVo) {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        return BaseResponse.success(sysUserService.editUser(addUserVo, loginId));
    }

    @Operation(summary = "根据id删除单个用户")
    @PostMapping("/deleteUserById")
    public BaseResponse<String> deleteUserById(@RequestBody SysUserVo user){
        return BaseResponse.success(sysUserService.deleteUserById(user));
    }
}
