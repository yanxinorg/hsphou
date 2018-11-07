package com.apsd.hspcloud.pojo;

import java.util.Date;

public class Answer {
    private Integer answerId;

    private String content;

    private String doctorId;

    private Integer indnum;

    private String questionId;

    private Date questionTime;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public Integer getIndnum() {
        return indnum;
    }

    public void setIndnum(Integer indnum) {
        this.indnum = indnum;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public Date getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Date questionTime) {
        this.questionTime = questionTime;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", content='" + content + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", indnum=" + indnum +
                ", questionId='" + questionId + '\'' +
                ", questionTime=" + questionTime +
                '}';
    }
}