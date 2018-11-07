package com.apsd.hspcloud.vo;

import java.io.Serializable;

public class SocketMsg implements Serializable {
   private String msg;
   private String to;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
