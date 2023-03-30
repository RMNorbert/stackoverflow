package com.codecool.stackoverflowtw.dao.model.question;


import com.codecool.stackoverflowtw.controller.dto.question.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.question.QuestionDTO;

import com.codecool.stackoverflowtw.dao.QuestionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class QuestionsDaoJdbc implements QuestionsDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public QuestionsDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Question> getAllQuestion() {
        String sql = "SELECT question.question_id, user_id, title, question.description, question.created, COUNT(answer_id) as numberOfAnswers " +
                " FROM question" +
                "    LEFT JOIN answer a on question.question_id = a.question_id " +
                " GROUP BY question.question_id";

        return jdbcTemplate.query(sql, new QuestionRowMapper());
    }

    @Override
    public Optional<Question> findQuestionById(int id) {
        String sql = "SELECT question.question_id,user_id, title, question.description, question.created, COUNT(answer_id) as numberOfAnswers " +
                " FROM question " +
                "    LEFT JOIN answer a on question.question_id = a.question_id " +
                " WHERE question.question_id = ? " +
                " GROUP BY question.question_id ";

        return jdbcTemplate.query(sql, new QuestionRowMapper(), id)
                .stream()
                .findFirst();
    }
    @Override
    public List<Question> getAllQuestionByUserID(int userID) {
        String sql = "SELECT question_id, user_id, title, description, created from question WHERE user_id = ?";
        return jdbcTemplate.query(sql, new QuestionRowMapper(),userID);
    }
    @Override
    public int addQuestion(NewQuestionDTO newQuestionDTO) {
        String sql = "INSERT INTO question(user_id,title,description,created) values (?,?,?)";

        return jdbcTemplate.update(sql,newQuestionDTO.userID(), newQuestionDTO.title(), newQuestionDTO.description(), LocalDateTime.now());
    }

    @Override
    public boolean deleteQuestionById(int theId) {
       int delete = jdbcTemplate.update("delete from question where question_id = ?",theId);
        return delete == 1;
    }

    @Override
    public void update(QuestionDTO questionDTO, int id) {
        String sql = "UPDATE question set title = ? , description = ? WHERE question_id =" + id;
        jdbcTemplate.update(sql, questionDTO.getTitle(),questionDTO.getDescription());
    }
}
