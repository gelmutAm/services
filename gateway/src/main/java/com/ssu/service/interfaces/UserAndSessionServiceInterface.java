package com.ssu.service.interfaces;

public interface UserAndSessionServiceInterface<T> {

    void add(T entity);

    T getById(int id);

    void deleteById(int id);

    void deleteBySessionId(String sessionId);

    T getByUserId(int userId);
}
