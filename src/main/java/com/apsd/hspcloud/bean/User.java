package com.apsd.hspcloud.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    private String openid;

    private String nick_name;

    private String avatar_url;

    @Override
    public String toString() {
        return "User{" +
                "openid='" + openid + '\'' +
                ", nickName='" + nick_name + '\'' +
                ", avatarUrl='" + avatar_url + '\'' +
                '}';
    }

    public User() {

    }

    public User(String openId, String nickName, String avatarUrl) {
        this.openid = openId;
        this.nick_name = nickName;
        this.avatar_url = avatarUrl;
    }

    public String getOpenId() {
        return openid;
    }

    public void setOpenId(String openId) {
        this.openid = openId;
    }

    public String getNickName() {
        return nick_name;
    }

    public void setNickName(String nickName) {
        this.nick_name = nickName;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatar_url = avatarUrl;
    }
}
