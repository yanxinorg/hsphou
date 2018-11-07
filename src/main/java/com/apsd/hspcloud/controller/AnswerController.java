package com.apsd.hspcloud.controller;

import com.apsd.hspcloud.common.wxResult;
import com.apsd.hspcloud.pojo.Answer;
import com.apsd.hspcloud.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/addAnswer")
    public wxResult addAnswer(Answer answer){
        System.out.println(answer);
       return answerService.addAnswer(answer);
    }

    @GetMapping("/getAnswers")
    public Object getAnswers(String question_id){
        return answerService.getAnswersByQuestionId(question_id);
    }
}
