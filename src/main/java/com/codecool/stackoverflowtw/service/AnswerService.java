package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.answer.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.model.answer.Answer;
import com.codecool.stackoverflowtw.dao.model.answer.AnswerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerDAO answerDAO;

    @Autowired
    public AnswerService(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    public List<AnswerDTO> getAllAnswers() {
        // TODO:
        List<AnswerDTO> answerDTOS = new ArrayList<>();
        answerDAO.getAllAnswers().forEach(answer -> answerDTOS.add(new AnswerDTO(answer)));
        return answerDTOS;
    }

    public Optional<AnswerDTO> getAnswerById(int id) {
        // TODO
        answerDAO.sayHi();
        Optional<Answer> answer = answerDAO.findAnswerById(id);

//        if (answer.isPresent()) {
//            return Optional.of(new AnswerDTO(answer.get()));
//        } else return Optional.empty();
        return answer.map(AnswerDTO::new); //apparently the same as above
    }

    public boolean deleteAnswerById(int id) {
        // TODO
        return answerDAO.deleteAnswerById(id);
    }

    public int addNewAnswer(NewAnswerDTO answer) {
        // TODo
        int createdId = answerDAO.addAnswer(answer);
        System.out.println(createdId);
        return createdId;
    }
}
