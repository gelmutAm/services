package com.ssu.service.implementations;

import com.ssu.dao.interfaces.UserAndSessionDaoInterface;
import com.ssu.model.UserAndSession;
import com.ssu.service.interfaces.UserAndSessionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Primary
public class UserAndSessionService implements UserAndSessionServiceInterface<UserAndSession> {

    private UserAndSessionDaoInterface userAndSessionDao;

    @Autowired
    public UserAndSessionService(UserAndSessionDaoInterface userAndSessionDao){
        this.userAndSessionDao = userAndSessionDao;
    }


    @Override
    @Transactional
    public void add(UserAndSession entity) {
        userAndSessionDao.add(entity);
    }

    @Override
    @Transactional
    public UserAndSession getById(int id) {
        return (UserAndSession) userAndSessionDao.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userAndSessionDao.delete(userAndSessionDao.getById(id));
    }

    @Override
    @Transactional
    public void deleteBySessionId(String sessionId) {
        userAndSessionDao.delete(userAndSessionDao.getBySessionId(sessionId));
    }

    @Override
    @Transactional
    public UserAndSession getByUserId(int userId) {
        return (UserAndSession) userAndSessionDao.getByUserId(userId);
    }
}
