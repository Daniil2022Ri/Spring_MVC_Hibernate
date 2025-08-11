package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoHibernate {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(User user) {
        entityManager.persist(user);
        return user.getId();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void update(Long id, String username, String email) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setUsername(username);
            user.setEmail(email);
        }
    }

    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
