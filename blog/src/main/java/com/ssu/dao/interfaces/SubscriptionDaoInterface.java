package com.ssu.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface SubscriptionDaoInterface<T> {

    void add(T entity);

    T getById(int id);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();

    ArrayList<Integer> getAllSubscribers(int creatorId);
}
