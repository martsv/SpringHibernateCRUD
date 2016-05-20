package ru.martsv.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.martsv.dao.UserDAO;
import ru.martsv.model.User;

import java.util.List;

/**
 * Created by mart on 17.05.16.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDAO.add(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDAO.update(user);
    }

    @Override
    @Transactional
    public List<User> findAllUsers() {
        return this.userDAO.findAll();
    }

    @Override
    @Transactional
    public List<User> findPartUsers(Integer offset, Integer maxResults, String search) { return this.userDAO.findPart(offset, maxResults, search); }

    @Override
    @Transactional
    public Long count() { return this.userDAO.count(); }

    @Override
    @Transactional
    public Long count(String seacrh) { return this.userDAO.count(seacrh); }

    @Override
    @Transactional
    public List<User> findUsersByName(String name) {
        return this.userDAO.findByName(name);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return this.userDAO.getById(id);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        this.userDAO.delete(id);
    }
}
