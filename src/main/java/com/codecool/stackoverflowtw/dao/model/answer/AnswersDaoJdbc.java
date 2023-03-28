package com.codecool.stackoverflowtw.dao.model.answer;

import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.answer.NewAnswerDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
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
    public List<Answer> getAllAnswers() {
        String sql = "SELECT answer_id, question_id, description, created from answer";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Answer answer = new Answer();
            answer.setAnswer_id(rs.getInt("answer_id"));
            answer.setQuestion_id(rs.getInt("question_id"));
            answer.setDescription(rs.getString("description"));
            answer.setCreated(rs.getTimestamp("created").toLocalDateTime());
            return answer;
        });
    }

    @Override
    public Optional<Answer> findAnswerById(int id) {
        String sql = "SELECT * FROM answer WHERE answer_id = ?";
        AnswerDTO answerDTO = null;
        Answer answer = null;
        try {
            answer = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (DataAccessException ex) {
            System.out.println("Question not found: " + id);
        }
        return Optional.ofNullable(answer);
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
    public int addAnswer(NewAnswerDTO answerDTO) {
        String sql = "INSERT INTO question(description,created) values (?,?)";

        try (Connection c = jdbcTemplate.getDataSource().getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, answerDTO.description());
            ps.setString(2, LocalDateTime.now().toString());
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

    @Override
    public boolean deleteAnswerById(int theId) {
        int delete = jdbcTemplate.update("delete from answer where answer_id = ?", theId);
        return delete == 1;
    }

    @Override
    public void update(AnswerDTO answerDTO, int id) {
        String sql = "UPDATE answer set title = ? , description = ? WHERE question_id =" + id;
        // jdbcTemplate.update(sql, questionDTO.title(),questionDTO.description());
    }
}
