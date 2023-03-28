package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.question.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.question.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class QuestionDTORowMapper implements RowMapper<QuestionDTO> {
    @Override
    public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new QuestionDTO(new Question(rs.getInt("question_id"), rs.getString("title"),
                rs.getString("description"), rs.getTimestamp("created").toLocalDateTime()));
    }
}
