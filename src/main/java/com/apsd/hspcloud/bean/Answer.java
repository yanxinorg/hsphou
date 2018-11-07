package com.apsd.hspcloud.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private int answer_id;
    private String doctor_id;
    private String question_id;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date question_time;
    private int indnum;
    public Answer() {
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer_id='" + answer_id + '\'' +
                ", doctor_id='" + doctor_id + '\'' +
                ", question_id='" + question_id + '\'' +
                ", content='" + content + '\'' +
                ", question_time=" + question_time +
                ", indnum=" + indnum +
                '}';
    }

    public int getIndnum() {
        return indnum;
    }

    public void setIndnum(int indnum) {
        this.indnum = indnum;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getQuestion_time() {
        return question_time;
    }

    public void setQuestion_time(Date question_time) {
        this.question_time = question_time;
    }
}
