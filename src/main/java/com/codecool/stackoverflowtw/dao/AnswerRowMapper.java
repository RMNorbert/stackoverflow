package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.answer.Answer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AnswerRowMapper implements RowMapper<Answer> {
    @Override
    public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Answer(
                rs.getInt("answer_id"),
                rs.getInt("question_id"),
                rs.getString("description"),
                rs.getTimestamp("created").toLocalDateTime()
        );
    }
}
