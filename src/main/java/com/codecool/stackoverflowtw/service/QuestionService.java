package com.codecool.stackoverflowtw.service;


import com.codecool.stackoverflowtw.dao.model.question.Question;
import com.codecool.stackoverflowtw.dao.model.question.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.question.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.question.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.question.Question;
import com.codecool.stackoverflowtw.dao.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
//    private User user = new User();
    private QuestionsDAO questionsDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        return questionsDAO.getAllQuestion()
                .stream()
                .map(QuestionDTO::new)
                .toList();
    }

    public Optional<QuestionDTO> getQuestionById(int id) {
        Optional<Question> question = questionsDAO.findQuestionById(id);
        return question.map(QuestionDTO::new);
    }

    public boolean deleteQuestionById(int id) {
//        user.setName("Bethoven");///TODO: this check should be at front end
//
//        String authorOfQuestion = String.valueOf(getQuestionById(id).map(questionDTO -> questionDTO.question().getAuthor()));
//        if (user.getName().equals(authorOfQuestion)) {
//            return questionsDAO.deleteQuestionById(id);
//        }
//        return false;
        return questionsDAO.deleteQuestionById(id);
    }

    public int addNewQuestion(NewQuestionDTO question) {
        return questionsDAO.addQuestion(new NewQuestionDTO(question.title(), question.description(), question.userID()));
    }

}
