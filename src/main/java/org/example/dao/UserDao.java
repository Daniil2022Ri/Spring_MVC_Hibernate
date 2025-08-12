package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);

    public List<User> listUsers();

    public void removeUser(long id);

    public void getAllUsers(User user);

    public void wathingUsersTable(User user);
}
