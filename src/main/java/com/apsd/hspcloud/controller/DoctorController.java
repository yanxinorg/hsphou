package com.apsd.hspcloud.controller;

import com.apsd.hspcloud.bean.Doctor;
import com.apsd.hspcloud.common.wxResult;
import com.apsd.hspcloud.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/getDoctor")
    public Doctor getDoctor(String doctor_id){
        Doctor doctor = doctorService.getDoctor(doctor_id);
        return doctor;
    }
    @GetMapping("/getDoctors")
    public List<Doctor> getDoctors(){
        List<Doctor> doctors = doctorService.getDoctors();
        return doctors;
    }

    @PostMapping("/login")
    public wxResult doctorLogin(String phone_num , String password){
        return doctorService.doctorLogin(phone_num,password);
    }
    @GetMapping("/getDoctorsBySid")
    public List<Doctor> getDoctorsBySid(Integer sid){
        return doctorService.getDoctorsBySid(sid);
    }
}
