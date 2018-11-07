package com.apsd.hspcloud.vo;

import java.util.List;

public class ApiBody {
    private List<Hospital> hospitalList;
    private String ret_code;

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    @Override
    public String toString() {
        return "ApiBody{" +
                "hospitalList=" + hospitalList +
                ", ret_code='" + ret_code + '\'' +
                '}';
    }
}
