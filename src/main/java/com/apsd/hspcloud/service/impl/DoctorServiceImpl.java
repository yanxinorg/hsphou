package com.apsd.hspcloud.service.impl;

import com.apsd.hspcloud.bean.Doctor;

import com.apsd.hspcloud.common.wxResult;
import com.apsd.hspcloud.dao.DoctorDao;
import com.apsd.hspcloud.repository.DoctorRepository;
import com.apsd.hspcloud.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorDao doctorDao;
    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctor(String doctor_id) {
        return doctorDao.getDoctorById(doctor_id);
    }

    @Override
    public wxResult doctorLogin(String phone_num, String password) {
        Doctor doctor = doctorDao.getDoctorBynum(phone_num);
        if (doctor!=null){
            String password_  = doctor.getPassword();
            if (password.trim().equals(password_)){
                return wxResult.ok(doctor);
            }
            else
                return wxResult.build(300,"用户名或者密码不正确");
        }else
            return wxResult.build(300,"用户名或者密码不正确");
    }

    @Override
    public List<Doctor> getDoctorsBySid(Integer sid) {
        return doctorDao.getDoctorsBySid(sid);
    }
}
