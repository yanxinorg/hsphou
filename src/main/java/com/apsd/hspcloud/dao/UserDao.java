package com.apsd.hspcloud.dao;

import com.apsd.hspcloud.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserDao {
    @Select("select * from user where openid=#{openid}")
    User getUserById(@Param("openid") String openid);
}
