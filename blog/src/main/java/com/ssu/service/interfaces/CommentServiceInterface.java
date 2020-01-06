package com.ssu.service.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface CommentServiceInterface<T> {

    void add(T entity);

    T getById(int id);

    void update(T entity);

    void deleteById(int id);

    List<T> getAll();

    ArrayList<Integer> getAllUserId(int postId);
}
