package com.ssu.dao.interfaces;

public interface UserAndSessionDaoInterface<T> {

    void add(T entity);

    T getById(int id);

    void delete(T entity);

    T getBySessionId(String sessionId);

    T getByUserId(Integer userId);
}
