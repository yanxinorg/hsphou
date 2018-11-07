package com.apsd.hspcloud.dao;

import com.apsd.hspcloud.bean.Doctor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DoctorDao {
    @Select("select * from doctor where doctor_id=#{doctor_id}")
    Doctor getDoctorById(@Param("doctor_id") String doctor_id);

    @Select("select * from doctor where phone_num=#{phone_num}")
    Doctor getDoctorBynum(@Param("phone_num")String phone_num);

    @Select("select * from doctor where subject_id=#{sid}")
    List<Doctor> getDoctorsBySid(@Param("sid")Integer sid);
}
