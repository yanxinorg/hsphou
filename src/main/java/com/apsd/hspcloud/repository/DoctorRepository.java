package com.apsd.hspcloud.repository;

import com.apsd.hspcloud.bean.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,String> {
}
