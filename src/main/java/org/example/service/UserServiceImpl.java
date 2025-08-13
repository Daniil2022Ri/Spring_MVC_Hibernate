package org.example.service;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHibernate;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public List<User> listUser() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }
}
