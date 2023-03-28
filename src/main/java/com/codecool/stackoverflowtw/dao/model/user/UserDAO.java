package com.codecool.stackoverflowtw.dao.model.user;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getAllUser();
    Optional<User> findUserById(int id);
    int addUser(User user);
    boolean deleteUserById(int theId);
    void updateNumberOfQuestion(User user, int id);
    void updateNumberOfAnswers(User user, int id);

}
