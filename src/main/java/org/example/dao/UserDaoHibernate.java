package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoHibernate implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User" , User.class).getResultList();
    }

    @Override
    public void removeUser(long id) {

    }

    @Override
    public void getAllUsers(User user) {

    }

    @Override
    public void wathingUsersTable(User user) {

    }

    @Override
    public User getUserById(long id) {
        return null;
    }
}
