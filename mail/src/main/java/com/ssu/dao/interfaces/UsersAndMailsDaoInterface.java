package com.ssu.dao.interfaces;

import java.util.List;

public interface UsersAndMailsDaoInterface<T> {

    void add(T entity);

    T getById(int id);

    List<T> getAll();
}
