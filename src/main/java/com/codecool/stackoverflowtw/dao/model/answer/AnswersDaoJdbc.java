package com.codecool.stackoverflowtw.dao.model.answer;

import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.question.NewQuestionDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AnswersDaoJdbc implements AnswerDAO {
    private final JdbcTemplate jdbcTemplate;

    public AnswersDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Answer> rowMapper = (rs, rowNum) -> {
        Answer answer = new Answer();
        answer.setAnswer_id(rs.getInt("answer_id"));
        answer.setQuestion_id(rs.getInt("question_id"));
        answer.setDescription(rs.getString("description"));
        answer.setCreated(rs.getTimestamp("created").toLocalDateTime());
        return answer;
    };

    @Override
    public void sayHi() {
        System.out.println("Hi DAO!");
    }

    @Override
    public List<AnswerDTO> getAllAnswers() {
        String sql = "SELECT answer_id, question_id, description, created from answer";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Answer answer = new Answer();
            answer.setAnswer_id(rs.getInt("answer_id"));
            answer.setQuestion_id(rs.getInt("question_id"));
            answer.setDescription(rs.getString("description"));
            answer.setCreated(rs.getTimestamp("created").toLocalDateTime());
            return new AnswerDTO(answer);
        });
    }

    @Override
    public Optional<AnswerDTO> findAnswerById(int id) {
        String sql = "SELECT * FROM answer WHERE answer_id = ?";
        AnswerDTO answerDTO = null;
        Answer answer;
        try {
            answer = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
            answerDTO = new AnswerDTO(answer);
        } catch (DataAccessException ex) {
            System.out.println("Question not found: " + id);
        }
        return Optional.ofNullable(answerDTO);
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
    public int addAnswer(NewQuestionDTO questionDTO) {
        String sql = "INSERT INTO question(title,description,created) values (?,?,?)";

        try (Connection c = jdbcTemplate.getDataSource().getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
