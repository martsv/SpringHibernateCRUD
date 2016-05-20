package ru.martsv.dao;

import ru.martsv.model.User;

import java.util.List;

/**
 * Created by mart on 17.05.16.
 */
public interface UserDAO {

    void add(User user);
    void update(User user);
    List<User> findAll();
    List<User> findPart(Integer offset, Integer maxResults, String search);
    Long count();
    Long count(String search);
    List<User> findByName(String name);
    User getById(long id);
    void delete(long id);
}
