package com.apsd.hspcloud.service.impl;

import com.apsd.hspcloud.common.wxResult;
import com.apsd.hspcloud.mapper.AnswerMapper;
import com.apsd.hspcloud.pojo.Answer;
import com.apsd.hspcloud.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    private AnswerMapper answerMapper;



    public wxResult addAnswer(Answer answer) {
        String question_id=answer.getQuestionId();

        answer.setQuestionTime(new Date());
        answer.setIndnum(answerMapper.getCountById(question_id)+1);
        answerMapper.insert(answer);
        return wxResult.ok();
    }

    @Override
    public  List<Answer> getAnswersByQuestionId(String question_id) {
        List<Answer> answerslist = answerMapper.getAnswersByQuestionId(question_id);
        return answerslist;
    }
}
