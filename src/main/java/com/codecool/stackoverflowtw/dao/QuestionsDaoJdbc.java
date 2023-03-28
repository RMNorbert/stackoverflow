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

    RowMapper<Question> rowMapper = (rs, rowNum) -> {
         Question question = new Question();
              question.setQuestion_id(rs.getInt("question_id"));
              question.setTitle(rs.getString("title"));
              question.setDescription( rs.getString("description"));
              question.setCreated( rs.getTimestamp ("created").toLocalDateTime());
        return question;
    };
    @Override
    public void sayHi() {
        System.out.println("Hi DAO!");
    }

    @Override
    public List<QuestionDTO> getAllQuestion() {
        String sql = "SELECT question_id, title, description, created from question";
        return jdbcTemplate.query(sql,(rs, rowNum) -> {
            Question question = new Question();
            question.setQuestion_id(rs.getInt("question_id"));
            question.setTitle(rs.getString("title"));
            question.setDescription(rs.getString("description"));
            question.setCreated(rs.getTimestamp("created").toLocalDateTime());
            QuestionDTO questionDTO = new QuestionDTO(question);
            return questionDTO;
        });
    }

    @Override
    public Optional<QuestionDTO> findQuestionById(int id) {
        String sql = "SELECT question_id,title,description, created FROM question WHERE question_id = ?";
        QuestionDTO questionDTO = null;
        Question question = null;
        try {
            question = jdbcTemplate.queryForObject(sql,new Object[]{id},rowMapper);
            questionDTO = new QuestionDTO(question);
        }catch (DataAccessException ex){
            System.out.println("Question not found: " + id);
        }
        return Optional.ofNullable(questionDTO);
    }

   /* @Override
    public int addQuestion(NewQuestionDTO questionDTO) {
        String sql = "INSERT INTO question(title,description,created) values (?,?,?)";
        int insert = jdbcTemplate.update(sql,questionDTO.title(),null, LocalDateTime.now());
    //TODO:
        RowMapper<Integer> countRowMapper = (rs, rowNum) -> {
            return rs.getInt("lastId");
        };
        String id = "SELECT MAX(question_id) as lastId from question";
        return jdbcTemplate.query(id,countRowMapper).get(0);

    }*/

    @Override
    public int addQuestion(NewQuestionDTO questionDTO) {
        String sql = "INSERT INTO question(title,description,created) values (?,?,?)";

        try (Connection c = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, questionDTO.title());
            ps.setString(2, null);
            ps.setString(3, LocalDateTime.now().toString());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            return generatedKey;

        } catch(SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    @Override
    public boolean deleteQuestionById(int theId) {
       int delete = jdbcTemplate.update("delete from question where question_id = ?",theId);
        return delete == 1;
    }

    @Override
    public void update(QuestionDTO questionDTO, int id) {
        String sql = "UPDATE question set title = ? , description = ? WHERE question_id =" + id;
       // jdbcTemplate.update(sql, questionDTO.title(),questionDTO.description());
    }
}
