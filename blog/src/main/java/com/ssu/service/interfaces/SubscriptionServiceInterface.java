package com.ssu.service.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface SubscriptionServiceInterface<T> {

    void add(T entity);

    T getById(int id);

    void update(T entity);

    void delete(int id);

    List<T> getAll();

    ArrayList<Integer> getAllSubscribers(int creatorId);
}
