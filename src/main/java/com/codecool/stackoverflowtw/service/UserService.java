package com.codecool.stackoverflowtw.service;

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

    public Optional<User> logInUser(String username) {
        Optional<User> user = userDAO.findUserByName(username);
        return user;
    }

    public boolean deleteUserById(int id) {
            return userDAO.deleteUserById(id);
    }

    public int addUser(String username, String password) {
        return userDAO.addUser(username,password);
    }
}
