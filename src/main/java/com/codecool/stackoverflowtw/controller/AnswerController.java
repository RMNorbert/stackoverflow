package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.answer.NewAnswerDTO;
import com.codecool.stackoverflowtw.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("answers")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/all")
    public List<AnswerDTO> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("/{id}")
    public Optional<AnswerDTO> getAnswerById(@PathVariable int id) {
        return answerService.getAnswerById(id);
    }
    @CrossOrigin
    @GetMapping("/q/{id}")
    public List<AnswerDTO> getAllAnswersByQuestionId(@PathVariable int id){
        return answerService.getAllAnswersByQuestionId(id);
    }

    @PostMapping("/")
    @CrossOrigin
    public int addNewAnswer(@RequestBody NewAnswerDTO answerDTO) {
        return answerService.addNewAnswer(answerDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteQuestionById(@PathVariable int id) {
        return false;
    }
}
