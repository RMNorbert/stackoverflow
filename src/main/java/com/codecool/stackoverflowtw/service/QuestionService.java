package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionsDAO questionsDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        // TODO:
        return questionsDAO.getAllQuestion();
    }

    public Optional<QuestionDTO> getQuestionById(int id) {
        // TODO
        questionsDAO.sayHi();
        return questionsDAO.findQuestionById(id);
    }

    public boolean deleteQuestionById(int id) {
        // TODO
        return questionsDAO.deleteQuestionById(id);
    }

    public int addNewQuestion(NewQuestionDTO question) {
        // TODo
        int createdId = questionsDAO.addQuestion(question);
        System.out.println(createdId);
        return createdId;
    }
}
