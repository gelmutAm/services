package com.ssu.service.implementations;

import com.ssu.dao.interfaces.UserDaoInterface;
import com.ssu.model.User;
import com.ssu.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class UserService implements UserServiceInterface<User> {

    private UserDaoInterface userDao;

    @Autowired
    public UserService(UserDaoInterface userDao){
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public void add(User entity) {
        userDao.add(entity);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return (User) userDao.getById(id);
    }

    @Override
    @Transactional
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        User res = (User) userDao.getById(id);
        userDao.delete(res);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }
}
