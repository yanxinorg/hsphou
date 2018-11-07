package com.apsd.hspcloud.vo;

public class HospitalVo {
    private String id;
    private String title;
    private String address;
    private String tel;
    private String category;
    private int type;
    private LocationVo location;
    private int _distance;
    private Ad_infoVo ad_info;

    @Override
    public String toString() {
        return "HospitalVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", category='" + category + '\'' +
                ", type=" + type +
                ", location=" + location +
                ", _distance=" + _distance +
                ", ad_info=" + ad_info +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocationVo getLocation() {
        return location;
    }

    public void setLocation(LocationVo location) {
        this.location = location;
    }

    public int get_distance() {
        return _distance;
    }

    public void set_distance(int _distance) {
        this._distance = _distance;
    }

    public Ad_infoVo getAd_info() {
        return ad_info;
    }

    public void setAd_info(Ad_infoVo ad_info) {
        this.ad_info = ad_info;
    }
}
