package com.codecool.stackoverflowtw.dao;


import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class QuestionsDaoJdbc implements QuestionsDAO {
    private final JdbcTemplate jdbcTemplate;

    public QuestionsDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void sayHi() {
        System.out.println("Hi DAO!");
    }

    @Override
    public List<QuestionDTO> getAllQuestion() {
        String sql = "SELECT question_id, title, description, created from question";

        return jdbcTemplate.query(sql, new QuestionDTORowMapper());
    }

    @Override
    public Optional<QuestionDTO> findQuestionById(int id) {
        String sql = "SELECT question_id,title,description, created FROM question WHERE question_id = ?";

        return jdbcTemplate.query(sql, new QuestionDTORowMapper(), id)
                .stream()
                .findFirst();
    }


    @Override
    public int addQuestion(NewQuestionDTO questionDTO) {
        String sql = "INSERT INTO question(title,description,created) values (?,?,?)";
        
        return jdbcTemplate.update(sql, questionDTO.title(), null, LocalDateTime.now());
    }

    @Override
    public boolean deleteQuestionById(int theId) {
        int delete = jdbcTemplate.update("delete from question where question_id = ?", theId);
        return delete == 1;
    }

    @Override
    public void update(QuestionDTO questionDTO, int id) {
        String sql = "UPDATE question set title = ? , description = ? WHERE question_id =" + id;
        // jdbcTemplate.update(sql, questionDTO.title(),questionDTO.description());
    }
}
