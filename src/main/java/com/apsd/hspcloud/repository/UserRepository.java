package com.apsd.hspcloud.repository;


import com.apsd.hspcloud.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
