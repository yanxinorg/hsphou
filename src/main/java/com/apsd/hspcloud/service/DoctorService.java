package com.apsd.hspcloud.service;

import com.apsd.hspcloud.bean.Doctor;
import com.apsd.hspcloud.common.wxResult;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctors();
    Doctor getDoctor(String doctor_id);
    wxResult doctorLogin(String phone_num, String password);
    List<Doctor> getDoctorsBySid(Integer sid);
}
