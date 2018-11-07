package com.apsd.hspcloud.repository;

import com.apsd.hspcloud.bean.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,String> {

}
