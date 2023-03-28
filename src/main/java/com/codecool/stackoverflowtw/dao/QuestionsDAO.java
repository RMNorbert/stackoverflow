package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionsDAO {
    void sayHi();
    List<QuestionDTO> getAllQuestion();
    Optional<QuestionDTO> findQuestionById(int id);
    int addQuestion(NewQuestionDTO question);
    boolean deleteQuestionById(int theId);
    void update(QuestionDTO questionDTO, int id);

}
