package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.user.NewUserDTO;
import com.codecool.stackoverflowtw.controller.dto.user.UserDTO;
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


    public List<UserDTO> getAllUser() {
        return userDAO.getAllUser()
                .stream()
                .map(user -> new UserDTO( user.getId(), user.getStatus(), user.getName(), user.getRegistration_date(), user.getNumber_of_questions(), user.getNumber_of_answers()))
                .toList();
    }

    public Optional<UserDTO> findUserById(int id) {
        return userDAO.findUserByName(id)
                .map(user -> new UserDTO( user.getId(), user.getStatus(), user.getName(), user.getRegistration_date(), user.getNumber_of_questions(), user.getNumber_of_answers()));

    }
    public Optional<UserDTO> logInUser(NewUserDTO userDTO) {
        return userDAO.findUser(userDTO)
                .map(user -> new UserDTO( user.getId(), user.getStatus(), user.getName(), user.getRegistration_date(), user.getNumber_of_questions(), user.getNumber_of_answers()));
    }

    public boolean deleteUserById(int id) {
            return userDAO.deleteUserById(id);
    }

    public int addUser(NewUserDTO userDTO) {
        return userDAO.addUser(userDTO);
    }
}
