package com.ssu.service.implementations;

import com.ssu.dao.interfaces.SubscriptionDaoInterface;
import com.ssu.model.Subscription;
import com.ssu.service.interfaces.SubscriptionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class SubscriptionService implements SubscriptionServiceInterface<Subscription> {

    private SubscriptionDaoInterface subscriptionDao;

    @Autowired
    public SubscriptionService(SubscriptionDaoInterface subscriptionDao){
        this.subscriptionDao = subscriptionDao;
    }

    @Override
    @Transactional
    public void add(Subscription entity) {
        subscriptionDao.add(entity);
    }

    @Override
    @Transactional
    public Subscription getById(int id) {
        return (Subscription) subscriptionDao.getById(id);
    }

    @Override
    @Transactional
    public void update(Subscription entity) {
        subscriptionDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Subscription subscription = this.getById(id);
        subscriptionDao.delete(subscription);
    }

    @Override
    @Transactional
    public List<Subscription> getAll() {
        return subscriptionDao.getAll();
    }

    @Override
    @Transactional
    public ArrayList<Integer> getAllSubscribers(int creatorId) {
        return subscriptionDao.getAllSubscribers(creatorId);
    }
}
