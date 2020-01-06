package com.ssu.dao.implementations;

import com.ssu.dao.interfaces.SubscriptionDaoInterface;
import com.ssu.model.Subscription;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class SubscriptionDao implements SubscriptionDaoInterface<Subscription> {

    private SessionFactory sessionFactory;

    @Autowired
    public SubscriptionDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Subscription entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public Subscription getById(int id) {
        return sessionFactory.getCurrentSession().get(Subscription.class, id);
    }

    @Override
    public void update(Subscription entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(Subscription entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public List<Subscription> getAll() {
        return (List<Subscription>) sessionFactory.getCurrentSession().createQuery("from Subscription").list();
    }

    @Override
    public ArrayList<Integer> getAllSubscribers(int creatorId) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Integer> query = criteriaBuilder.createQuery(Integer.class);
        Root<Subscription> root = query.from(Subscription.class);
        query.select(root.get("subscriberId")).where(criteriaBuilder.equal(root.get("creatorId"), creatorId));
        Query q = sessionFactory.getCurrentSession().createQuery(query);

        return (ArrayList<Integer>) q.getResultList();
    }
}
