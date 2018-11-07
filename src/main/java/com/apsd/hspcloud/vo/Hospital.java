package com.apsd.hspcloud.vo;

public class Hospital {
    private String id;
    private String img;
    private String hosName;
    private String addr;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id='" + id + '\'' +
                ", img='" + img + '\'' +
                ", hosName='" + hosName + '\'' +
                ", addr='" + addr + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
