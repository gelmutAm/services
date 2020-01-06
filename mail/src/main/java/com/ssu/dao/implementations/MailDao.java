package com.ssu.dao.implementations;

import com.ssu.dao.interfaces.MailDaoInterface;
import com.ssu.model.Mail;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class MailDao implements MailDaoInterface<Mail> {

    private SessionFactory sessionFactory;

    @Autowired
    public MailDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Mail entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public Mail getById(int id) {
        return sessionFactory.getCurrentSession().get(Mail.class, id);
    }

    @Override
    public List<Mail> getAll() {
        return (List<Mail>) sessionFactory.getCurrentSession().createQuery("from Mail").list();
    }
}
