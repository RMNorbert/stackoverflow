package com.codecool.stackoverflowtw.dao.model.user;


import com.codecool.stackoverflowtw.controller.dto.user.NewUserDTO;
import com.codecool.stackoverflowtw.dao.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoJdbc implements UserDAO {
    private final JdbcTemplate jdbcTemplate;

    public UserDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<User> getAllUser() {
        String sql = "SELECT id,password, status, name, registration_date,number_of_questions,number_of_answers" +
                " FROM \"user\"";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public Optional<User> findUserByName(int id) {
        String sql = "SELECT id, status,name, registration_date, number_of_questions, number_of_answers " +
                " FROM \"user\" WHERE id = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<User> findUser(String name, String password) {
        String sql = "SELECT name, id, status, password, registration_date, number_of_questions, number_of_answers " +
                " FROM \"user\" WHERE name = ? AND password = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), name,password)
                .stream()
                .findFirst();
    }
    @Override
    public int addUser(NewUserDTO userDTO) {
        String sql = "INSERT INTO \"user\"(name,password,registration_date,number_of_questions,number_of_answers) values (?,?,?,?,?)";
        return jdbcTemplate.update(sql,userDTO.username() ,userDTO.password(), LocalDateTime.now(),0,0);
    }

    @Override
    public boolean deleteUserById(int theId) {
       int delete = jdbcTemplate.update("delete from \"user\" where id = ?",theId);
        return delete == 1;
    }

    @Override
    public void updateNumberOfQuestion(User user, int id) {
        String sql = "UPDATE \"user\" set number_of_questions = ? ,  = ? WHERE id =" + id;
        jdbcTemplate.update(sql, user.getNumber_of_questions()+1);
    }
    public void updateNumberOfAnswers(User user, int id) {
        String sql = "UPDATE \"user\" set number_of_answers = ? ,  = ? WHERE id =" + id;
        jdbcTemplate.update(sql, user.getNumber_of_answers()+1);
    }
}
