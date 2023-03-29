package com.codecool.stackoverflowtw.dao.model.answer;

import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.answer.NewAnswerDTO;

import java.util.List;
import java.util.Optional;

public interface AnswerDAO {
    void sayHi();

    List<Answer> getAllAnswers();

    Optional<Answer> findAnswerById(int id);

    int addAnswer(NewAnswerDTO answer);

    boolean deleteAnswerById(int theId);

    void update(AnswerDTO answerDTO, int id);

}
