package ru.martsv.service;

import ru.martsv.model.User;

import java.util.List;

/**
 * Created by mart on 17.05.16.
 */
public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    List<User> findAllUsers();
    List<User> findPartUsers(Integer offset, Integer maxResults, String search);
    List<User> findUsersByName(String name);
    Long count();
    Long count(String search);
    User getUserById(long id);
    void deleteUser(long id);
}
