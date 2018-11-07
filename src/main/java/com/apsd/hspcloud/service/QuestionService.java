package com.apsd.hspcloud.service;

import com.apsd.hspcloud.bean.Question;
import com.apsd.hspcloud.entity.MyQuestion;

import java.util.List;


public interface QuestionService {
     void addQuestion(Question question);
     List<Question> getQuestions(String doctor_id);
     List<MyQuestion> getMyQuestion(String user_id);
}
