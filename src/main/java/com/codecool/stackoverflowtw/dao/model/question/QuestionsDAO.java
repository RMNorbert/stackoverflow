package com.codecool.stackoverflowtw.dao.model.question;

import com.codecool.stackoverflowtw.controller.dto.question.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.question.QuestionDTO;

import java.util.List;
import java.util.Optional;

public interface QuestionsDAO {
    List<Question> getAllQuestion();
    Optional<Question> findQuestionById(int id);
    int addQuestion(NewQuestionDTO question, String author);
    List<Question> getAllQuestionByAuthor(String author);
    boolean deleteQuestionById(int theId);
    void update(QuestionDTO questionDTO, int id);

}
