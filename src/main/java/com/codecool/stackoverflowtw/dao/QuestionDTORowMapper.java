package com.codecool.stackoverflowtw.dao;
import com.codecool.stackoverflowtw.dao.model.question.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDTORowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Question(rs.getInt("question_id"), rs.getString("title"),
                rs.getString("description"), rs.getTimestamp("created").toLocalDateTime());
    }
}
