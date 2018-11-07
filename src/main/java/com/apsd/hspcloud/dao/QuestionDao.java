package com.apsd.hspcloud.dao;

import com.apsd.hspcloud.bean.Question;
import com.apsd.hspcloud.entity.MyQuestion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuestionDao {
    @Select("select * from question where doctor_id=#{doctor_id}")
    List<Question> getQuestionByDid(@Param("doctor_id") String doctor_id);
    @Select("select * from question as q ,doctor as d where q.doctor_id=d.doctor_id and q.user_id=#{user_id} order by q.question_time desc")
    List<MyQuestion> getMyQuestion(@Param("user_id")String user_id);
}
