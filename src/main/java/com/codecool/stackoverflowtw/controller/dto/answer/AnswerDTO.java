package com.codecool.stackoverflowtw.controller.dto.answer;

import com.codecool.stackoverflowtw.dao.model.answer.Answer;

import java.time.LocalDateTime;

public class AnswerDTO {
    private final int answer_id;
    private final int question_id;
    private String description;
    private LocalDateTime created;

    private AnswerDTO(int answer_id,
                     int question_id,
                     String description,
                     LocalDateTime created) {
        this.answer_id = answer_id;
        this.question_id = question_id;
        this.description = description;
        this.created = created;
    }
    public static AnswerDTO of(Answer answer){
        return new AnswerDTO(
                answer.getAnswer_id(),
                answer.getQuestion_id(),
                answer.getDescription(),
                answer.getCreated()
        );
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
