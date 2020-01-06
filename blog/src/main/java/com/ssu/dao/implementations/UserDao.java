package com.ssu.dao.implementations;

import com.ssu.dao.interfaces.UserDaoInterface;
import com.ssu.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class UserDao implements UserDaoInterface<User> {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public User getById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void update(User entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(User entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
    }
}
