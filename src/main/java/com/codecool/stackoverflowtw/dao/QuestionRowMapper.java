package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.question.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Question(
                rs.getInt("question_id"),
                rs.getInt("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getTimestamp("created").toLocalDateTime(),
                rs.getInt("numberOfAnswers")
        );
    }
}
