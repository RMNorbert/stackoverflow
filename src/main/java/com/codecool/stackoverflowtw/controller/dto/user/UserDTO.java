package com.codecool.stackoverflowtw.controller.dto.user;

import com.codecool.stackoverflowtw.dao.model.user.User;

import java.time.LocalDateTime;

public class UserDTO {
    private int id;
    private String status;
    private String name;
    private LocalDateTime registration_date;
    private int number_of_questions;
    private int number_of_answers;

    public UserDTO(int id, String status, String name, LocalDateTime registration_date, int number_of_questions, int number_of_answers) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.registration_date = registration_date;
        this.number_of_questions = number_of_questions;
        this.number_of_answers = number_of_answers;
    }
}
