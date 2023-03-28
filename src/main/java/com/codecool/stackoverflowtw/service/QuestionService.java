package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.model.question.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.question.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.question.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        questionsDAO.getAllQuestion().forEach(question -> questionDTOS.add(new QuestionDTO(question)));
        return questionDTOS;
    }

    public Optional<QuestionDTO> getQuestionById(int id) {
        // TODO
        Optional<Question> question = questionsDAO.findQuestionById(id);
        return question.map(QuestionDTO::new);
    }

    public boolean deleteQuestionById(int id) {
        // TODO
        return questionsDAO.deleteQuestionById(id);
    }

    public int addNewQuestion(NewQuestionDTO question) {
        // TODo
        return questionsDAO.addQuestion(new NewQuestionDTO("asd"));
    }
}
