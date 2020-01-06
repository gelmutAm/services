package com.ssu.service.implementations;

import com.ssu.dao.interfaces.MailDaoInterface;
import com.ssu.model.Mail;
import com.ssu.service.interfaces.MailServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class MailService implements MailServiceInterface<Mail> {

    private MailDaoInterface mailDao;

    @Autowired
    public MailService(MailDaoInterface mailDao){
        this.mailDao = mailDao;
    }

    @Override
    @Transactional
    public void add(Mail entity) {
        mailDao.add(entity);
    }

    @Override
    @Transactional
    public Mail getById(int id) {
        return (Mail) mailDao.getById(id);
    }

    @Override
    @Transactional
    public List<Mail> getAll() {
        return mailDao.getAll();
    }
}
