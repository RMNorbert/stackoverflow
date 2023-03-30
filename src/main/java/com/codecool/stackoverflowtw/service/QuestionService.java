package com.codecool.stackoverflowtw.service;


import com.codecool.stackoverflowtw.dao.model.question.Question;
import com.codecool.stackoverflowtw.dao.model.question.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.question.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.question.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionsDAO questionsDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        return questionsDAO.getAllQuestion()
                .stream()
                .map(QuestionDTO::of)
                .toList();
    }

    public Optional<QuestionDTO> getQuestionById(int id) {
        return convertOptionalQuestionToOptionalQuestionDTO(questionsDAO.findQuestionById(id));
    }

    public boolean deleteQuestionById(int id) {
        return questionsDAO.deleteQuestionById(id);
    }

    public int addNewQuestion(NewQuestionDTO question) {
        return questionsDAO.addQuestion(new NewQuestionDTO(question.title(), question.description(), question.userID()));
    }

    private Optional<QuestionDTO> convertOptionalQuestionToOptionalQuestionDTO(Optional<Question> question) {
        return  question.map(QuestionDTO::of);
    }

}
