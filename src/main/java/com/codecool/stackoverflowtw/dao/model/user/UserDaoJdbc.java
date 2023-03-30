package com.codecool.stackoverflowtw.dao.model.user;


import com.codecool.stackoverflowtw.controller.dto.user.NewUserDTO;
import com.codecool.stackoverflowtw.dao.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoJdbc implements UserDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
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
        String sql = "SELECT id,password, status,name, registration_date, number_of_questions, number_of_answers " +
                " FROM \"user\" WHERE id = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<User> findUser(NewUserDTO newUserDTO) {
        String sql = "SELECT name, id,registration_date, number_of_questions, number_of_answers " +
                " FROM \"user\" WHERE name = ? AND password = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), newUserDTO.username(),newUserDTO.password())
                .stream()
                .findFirst();
    }
    @Override
    public int addUser(NewUserDTO newUserDTO) {
        String sql = "INSERT INTO \"user\"(name,password,registration_date,number_of_questions,number_of_answers) values (?,?,?,?,?)";
        return jdbcTemplate.update(sql,newUserDTO.username() ,newUserDTO.password(), LocalDateTime.now(),0,0);
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
