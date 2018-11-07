package com.apsd.hspcloud.mapper;

import com.apsd.hspcloud.pojo.Answer;
import com.apsd.hspcloud.pojo.AnswerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerMapper {

    List<Answer> getAnswersByQuestionId(String question_id);

    int getCountById(String question_id);
    int countByExample(AnswerExample example);

    int deleteByExample(AnswerExample example);

    int deleteByPrimaryKey(Integer answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(Integer answerId);

    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}