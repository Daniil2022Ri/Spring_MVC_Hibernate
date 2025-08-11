package org.example.service;

import org.example.dao.UserDaoHibernate;
import org.example.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDaoHibernate userDao;

    public UserService(UserDaoHibernate userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public Long createUser(String name, String email) {
        User u = new User();
        u.setUsername(name);
        u.setEmail(email);
        return userDao.save(u);
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Transactional
    public void updateUser(Long id, String name, String email) {
        userDao.update(id, name, email);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDao.delete(id);
    }
}
