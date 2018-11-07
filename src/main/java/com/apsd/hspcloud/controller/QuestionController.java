package com.apsd.hspcloud.controller;

import com.apsd.hspcloud.bean.Question;
import com.apsd.hspcloud.common.wxResult;
import com.apsd.hspcloud.entity.MyQuestion;
import com.apsd.hspcloud.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/addQuestion")
    public wxResult addQuestion(Question question){
        questionService.addQuestion(question);
        return wxResult.ok();
    }
    @GetMapping("/getQuestions")
    public Object getQuestions(String doctor_id){
        return questionService.getQuestions(doctor_id);
    }

    @GetMapping("/getMyQuestions")
    public Object getMyQuestions(String user_id){
        List<MyQuestion> MyQuestion = questionService.getMyQuestion(user_id);
        return MyQuestion;
    }
}
