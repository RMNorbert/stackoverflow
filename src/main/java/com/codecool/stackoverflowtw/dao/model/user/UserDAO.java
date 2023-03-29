package com.codecool.stackoverflowtw.dao.model.user;

import com.codecool.stackoverflowtw.controller.dto.user.NewUserDTO;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getAllUser();
    Optional<User> findUserByName(int id);
    Optional<User> findUser(String userName, String password);
    int addUser(NewUserDTO userDTO);
    boolean deleteUserById(int theId);
    void updateNumberOfQuestion(User user, int id);
    void updateNumberOfAnswers(User user, int id);

}
