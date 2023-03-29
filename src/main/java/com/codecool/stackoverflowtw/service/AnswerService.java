package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.answer.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.model.answer.AnswerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return answerDAO.getAllAnswers()
                .stream()
                .map(AnswerDTO::new)
                .toList();
    }

    public Optional<AnswerDTO> getAnswerById(int id) {

// answer = answerDAO.findAnswerById(id)
//        if (answer.isPresent()) {
//            return Optional.of(new AnswerDTO(answer.get()));
//        } else return Optional.empty();
        return answerDAO.findAnswerById(id).map(AnswerDTO::new); //apparently the same as above
    }

    public boolean deleteAnswerById(int id) {
        return answerDAO.deleteAnswerById(id);
    }

    public int addNewAnswer(NewAnswerDTO answer) {
        return answerDAO.addAnswer(answer);
    }
}
