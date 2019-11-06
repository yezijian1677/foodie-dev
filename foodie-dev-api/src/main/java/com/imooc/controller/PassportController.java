package com.imooc.controller;

import com.imooc.service.UserService;
import com.imooc.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author augenye
 * @date 2019-11-05 22:11
 */

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

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
}
