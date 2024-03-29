package com.codecool.stackoverflowtw.dao.model.answer;

import java.time.LocalDateTime;

public class Answer {
    private Integer answer_id;
    private Integer question_id;
    private String description;
    private LocalDateTime created;

    public Answer() {}

    public Answer(Integer answer_id, Integer question_id, String description, LocalDateTime created) {
        this.answer_id = answer_id;
        this.question_id = question_id;
        this.description = description;
        this.created = created;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
