package com.ssu.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface CommentDaoInterface<T> {

    void add(T entity);

    T getById(int id);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();

    ArrayList<Integer> getAllUserId(int postId);
}
