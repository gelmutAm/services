package com.ssu.dao.interfaces;

import java.util.List;

public interface MailDaoInterface<T> {

    void add(T entity);

    T getById(int id);

    List<T> getAll();
}
