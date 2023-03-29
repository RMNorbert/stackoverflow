package com.codecool.stackoverflowtw.dao.model.question;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer question_id;
    private int userID;
    private String title;
    private String description;
    private LocalDateTime created;
    private int numberOfAnswers;

    public Question(Integer question_id, int userID, String title, String description, LocalDateTime created, int numberOfAnswers) {
        this.question_id = question_id;
        this.userID = userID;
        this.title = title;
        this.description = description;
        this.created = created;
        this.numberOfAnswers = numberOfAnswers;
    }

    public Question() {}


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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }
}
