package com.ssu.dao.implementations;

import com.ssu.dao.interfaces.UserDaoInterface;
import com.ssu.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public List<User> getAll() {
        return (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public Integer getEmailId(String email){
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Integer> query = criteriaBuilder.createQuery(Integer.class);
        Root<User> root = query.from(User.class);
        query.select(root.get("id")).where(criteriaBuilder.equal(root.get("email"), email));
        Query q = sessionFactory.getCurrentSession().createQuery(query);
        Integer result = (Integer) q.getSingleResult();

        return result;
    }
}
