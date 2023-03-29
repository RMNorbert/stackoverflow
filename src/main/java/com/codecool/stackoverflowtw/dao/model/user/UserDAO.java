package com.codecool.stackoverflowtw.dao.model.user;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getAllUser();
    Optional<User> findUserByName(String userName);
    int addUser(String username, String password);
    boolean deleteUserById(int theId);
    void updateNumberOfQuestion(User user, int id);
    void updateNumberOfAnswers(User user, int id);

}
