package com.apsd.hspcloud.service.impl;

import com.apsd.hspcloud.bean.User;
import com.apsd.hspcloud.common.wxResult;
import com.apsd.hspcloud.dao.UserDao;
import com.apsd.hspcloud.repository.UserRepository;
import com.apsd.hspcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    public wxResult register(User user){
        User s = userRepository.save(user);
        return wxResult.ok(s);
    }

    public wxResult login(String openid){
        User user = userDao.getUserById(openid);
        return wxResult.ok(user);
    }
    public User getUser(String openid){
        return userDao.getUserById(openid);
    }
}
