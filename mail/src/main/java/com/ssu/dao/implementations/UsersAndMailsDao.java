package com.ssu.dao.implementations;

import com.ssu.dao.interfaces.UsersAndMailsDaoInterface;
import com.ssu.model.User;
import com.ssu.model.UsersAndMails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class UsersAndMailsDao implements UsersAndMailsDaoInterface<UsersAndMails> {

    private SessionFactory sessionFactory;

    @Autowired
    public UsersAndMailsDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(UsersAndMails entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public UsersAndMails getById(int id) {
        return sessionFactory.getCurrentSession().get(UsersAndMails.class, id);
    }

    @Override
    public List<UsersAndMails> getAll() {
        return (List<UsersAndMails>) sessionFactory.getCurrentSession().createQuery("from UsersAndMails").list();
    }
}
