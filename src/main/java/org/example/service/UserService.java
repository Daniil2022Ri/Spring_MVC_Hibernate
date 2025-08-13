package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public List<User> listUser();

    public void removeUser(long id);
}
