package com.ssu.service.interfaces;

import java.util.List;

public interface UsersAndMailsServiceInterface<T> {

    void add(T entity);

    T getById(int id);

    List<T> getAll();
}
