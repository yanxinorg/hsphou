package com.apsd.hspcloud.service.impl;

import com.apsd.hspcloud.bean.Doctor;
import com.apsd.hspcloud.bean.Question;
import com.apsd.hspcloud.dao.QuestionDao;
import com.apsd.hspcloud.entity.MyQuestion;
import com.apsd.hspcloud.repository.QuestionRepository;
import com.apsd.hspcloud.service.QuestionService;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionDao questionDao;

    public void addQuestion(Question question){
        question.setQuestion_id(UUID.randomUUID().toString());
        question.setQuestion_time(new Date());
        question.setAlive(true);
        questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestions(String doctor_id) {
       return questionDao.getQuestionByDid(doctor_id);
    }

    @Override
    public List<MyQuestion> getMyQuestion(String user_id) {

        List<MyQuestion> MyQuestion = questionDao.getMyQuestion(user_id);
        return MyQuestion;
    }
}
