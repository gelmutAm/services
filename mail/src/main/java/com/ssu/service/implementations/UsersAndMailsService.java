package com.ssu.service.implementations;

import com.ssu.dao.interfaces.UsersAndMailsDaoInterface;
import com.ssu.model.UsersAndMails;
import com.ssu.service.interfaces.UsersAndMailsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class UsersAndMailsService implements UsersAndMailsServiceInterface<UsersAndMails> {

    private UsersAndMailsDaoInterface usersAndMailsDao;

    @Autowired
    public UsersAndMailsService(UsersAndMailsDaoInterface usersAndMailsDao){
        this.usersAndMailsDao = usersAndMailsDao;
    }

    @Override
    @Transactional
    public void add(UsersAndMails entity) {
        usersAndMailsDao.add(entity);
    }

    @Override
    @Transactional
    public UsersAndMails getById(int id) {
        return (UsersAndMails) usersAndMailsDao.getById(id);
    }

    @Override
    @Transactional
    public List<UsersAndMails> getAll() {
        return usersAndMailsDao.getAll();
    }
}
