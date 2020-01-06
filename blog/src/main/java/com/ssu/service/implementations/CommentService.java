package com.ssu.service.implementations;

import com.ssu.dao.interfaces.CommentDaoInterface;
import com.ssu.model.Comment;
import com.ssu.service.interfaces.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class CommentService implements CommentServiceInterface<Comment> {

    private CommentDaoInterface commentDao;

    @Autowired
    public CommentService(CommentDaoInterface commentDao){
        this.commentDao = commentDao;
    }

    @Override
    @Transactional
    public void add(Comment entity) {
        commentDao.add(entity);
    }

    @Override
    @Transactional
    public Comment getById(int id) {
        return (Comment) commentDao.getById(id);
    }

    @Override
    @Transactional
    public void update(Comment entity) {
        commentDao.update(entity);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Comment res = (Comment) commentDao.getById(id);
        commentDao.delete(res);
    }

    @Override
    @Transactional
    public List<Comment> getAll() {
        return commentDao.getAll();
    }

    @Override
    @Transactional
    public ArrayList<Integer> getAllUserId(int postId){
        return commentDao.getAllUserId(postId);
    }
}
