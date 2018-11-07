package com.apsd.hspcloud.service;

import com.apsd.hspcloud.vo.Hospital;
import com.apsd.hspcloud.vo.HospitalVo;

import java.util.List;

public interface HospitalService {
    List<Hospital> getHospitalList(List<HospitalVo> hospitalList);
}
