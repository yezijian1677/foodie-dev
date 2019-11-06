package com.imooc.controller;

import com.imooc.bo.UserBo;
import com.imooc.service.UserService;
import com.imooc.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author augenye
 * @date 2019-11-05 22:11
 */

@Api(value = "注册登陆", tags = {"用于注册登录相关的接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public Result userNameIsExist(@RequestParam String username) {

        if (StringUtils.isNotEmpty(username)) {
            return Result.errorMsg("用户名不能为空");
        }

        boolean isExist = userService.queryUsernameIsExist(username);

        if (isExist) {
            return Result.errorMsg("用户名已存在");
        }

        return Result.ok();
    }


    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/register")
    public Result register(@RequestBody UserBo userBo) {
        String username = userBo.getUsername();
        String password = userBo.getPassword();
        String confirmPwd = userBo.getConfirmPassword();

        // 0. 判断用户名密码不为空
        if (StringUtils.isBlank(username)||
                StringUtils.isBlank(password)||
                StringUtils.isBlank(confirmPwd)) {
            return Result.errorMsg("用户名或者密码不能为空");
        }
        // 1. 查询使用名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return Result.errorMsg("用户名已存在");
        }
        // 2. 判断密码的长度不能少于6位
        if (password.length() < 6) {
            return Result.errorMsg("密码长度不能少于6");
        }
        // 3.  判断两次密码是否一致
        if (!password.equals(confirmPwd)) {
            return Result.errorMsg("两次密码输入不一致");
        }
        // 4. 实现注册
        userService.createUser(userBo);

        return Result.ok();
    }
}
