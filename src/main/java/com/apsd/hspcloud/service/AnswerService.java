package com.apsd.hspcloud.service;

import com.apsd.hspcloud.common.wxResult;
import com.apsd.hspcloud.pojo.Answer;

import java.util.List;

public interface AnswerService {
    wxResult addAnswer(Answer answer);

    List<Answer> getAnswersByQuestionId(String question_id);
}
