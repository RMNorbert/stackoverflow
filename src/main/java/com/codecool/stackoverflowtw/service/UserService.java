package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.user.NewUserDTO;
import com.codecool.stackoverflowtw.dao.model.user.User;
import com.codecool.stackoverflowtw.dao.model.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    public Optional<User> findUserById(int id) {
        Optional<User> user = userDAO.findUserByName(id);
        return user;
    }
    public Optional<User> logInUser(NewUserDTO userDTO) {
        Optional<User> user = userDAO.findUser(userDTO.username(), userDTO.password());
        return user;
    }

    public boolean deleteUserById(int id) {
            return userDAO.deleteUserById(id);
    }

    public int addUser(NewUserDTO userDTO) {
        return userDAO.addUser(userDTO);
    }
}
