package com.ssu.dao.implementations;

import com.ssu.dao.interfaces.UserAndSessionDaoInterface;
import com.ssu.model.UserAndSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Primary
public class UserAndSessionDao implements UserAndSessionDaoInterface<UserAndSession> {

    private SessionFactory sessionFactory;

    @Autowired
    public UserAndSessionDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(UserAndSession entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public UserAndSession getById(int id) {
        UserAndSession userAndSession = null;

        try {
            userAndSession = sessionFactory.getCurrentSession().get(UserAndSession.class, id);
        }catch (NoResultException ex){}

        return userAndSession;
    }

    @Override
    public void delete(UserAndSession entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public UserAndSession getBySessionId(String sessionId){
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<UserAndSession> query = criteriaBuilder.createQuery(UserAndSession.class);
        Root<UserAndSession> root = query.from(UserAndSession.class);
        query.select(root).where(criteriaBuilder.equal(root.get("sessionId"), sessionId));
        Query q = sessionFactory.getCurrentSession().createQuery(query);

        return (UserAndSession) q.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public UserAndSession getByUserId(Integer userId){
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<UserAndSession> query = criteriaBuilder.createQuery(UserAndSession.class);
        Root<UserAndSession> root = query.from(UserAndSession.class);
        query.select(root).where(criteriaBuilder.equal(root.get("userId"), userId));
        Query q = sessionFactory.getCurrentSession().createQuery(query);

        return (UserAndSession) q.getResultList().stream().findFirst().orElse(null);
    }
}
