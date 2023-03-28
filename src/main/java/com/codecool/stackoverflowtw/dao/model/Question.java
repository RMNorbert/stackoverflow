package com.codecool.stackoverflowtw.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Question {

    public Question(Integer question_id, String title, String description, LocalDateTime created) {
        this.question_id = question_id;
        this.title = title;
        this.description = description;
        this.created = created;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer question_id;
    private String title;
    private String description;
    private LocalDateTime created;
    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
