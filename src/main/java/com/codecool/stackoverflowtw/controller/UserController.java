package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.answer.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.model.user.User;
import com.codecool.stackoverflowtw.service.AnswerService;
import com.codecool.stackoverflowtw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/create")
    public int addNewUser(@RequestBody String name, String password) {
        return userService.addUser(name,password);
    }

    /*@DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }*/
}
