package com.apsd.hspcloud.service;

import com.apsd.hspcloud.bean.User;
import com.apsd.hspcloud.common.wxResult;

public interface UserService {
    wxResult register(User user);
    wxResult login(String openid);
    User getUser(String openid);
}
