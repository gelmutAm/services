package com.ssu.service.interfaces;

import java.util.List;

public interface PostServiceInterface<T> {

    void add(T entity);

    T getById(int id);

    void update(T entity);

    void deleteById(int id);

    List<T> getAll();
}
