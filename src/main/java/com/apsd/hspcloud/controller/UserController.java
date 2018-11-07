package com.apsd.hspcloud.controller;


import com.apsd.hspcloud.bean.User;
import com.apsd.hspcloud.common.wxResult;
import com.apsd.hspcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public wxResult register(String openid, String nickName, String avatarUrl){
        User user = new User(openid,nickName,avatarUrl);
        return userService.register(user);
    }
    @GetMapping("/login")
    public wxResult login(String openid){
        return userService.login(openid);
    }
    @GetMapping("/getUser")
    public User get(String openid){
        User user = userService.getUser(openid);
        return user;
    }
}
