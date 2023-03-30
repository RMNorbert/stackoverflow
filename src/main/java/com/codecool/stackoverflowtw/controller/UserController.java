package com.codecool.stackoverflowtw.controller;


import com.codecool.stackoverflowtw.controller.dto.user.NewUserDTO;
import com.codecool.stackoverflowtw.controller.dto.user.UserDTO;
import com.codecool.stackoverflowtw.dao.model.user.User;
import com.codecool.stackoverflowtw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/create")
    public int addNewUser(@RequestBody NewUserDTO userDTO) {
        return userService.addUser(userDTO);
    }
    @GetMapping("/login")
    public Optional<UserDTO> loginUser(@RequestBody NewUserDTO userDTO) {
        return userService.logInUser(userDTO);
    }
    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
