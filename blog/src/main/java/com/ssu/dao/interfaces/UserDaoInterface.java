package com.ssu.dao.interfaces;

import java.util.List;

public interface UserDaoInterface<T> {

    void add(T entity);

    T getById(int id);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();
}
