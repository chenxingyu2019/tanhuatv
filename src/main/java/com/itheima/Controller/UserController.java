package com.itheima.Controller;

import com.itheima.Service.UserService;
import com.itheima.common.R;
import com.itheima.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public R register(@RequestBody User user) {
        if (userService.registerUser(user)) {
            return R.ok().message("注册成功");
        } else {
            return R.error().message("用户名已存在");
        }
    }

    @PostMapping("/update-password")
    public R updatePassword(@RequestParam String username, @RequestParam String email, @RequestParam String newPassword) {
        if (userService.updatePassword(username, email, newPassword)) {
            return R.ok().message("密码更新成功");
        } else {
            return R.error().message("用户名或邮箱不正确");
        }
    }
}
