package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getLong("id"), rs.getString("status"),
                rs.getString("name"), rs.getTimestamp("registration_date").toLocalDateTime(),
                rs.getInt("number_of_questions"), rs.getInt("number_of_answers"));
    }
}
