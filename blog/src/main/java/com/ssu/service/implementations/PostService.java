package com.ssu.service.implementations;

import com.ssu.dao.interfaces.PostDaoInterface;
import com.ssu.model.Post;
import com.ssu.service.interfaces.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class PostService implements PostServiceInterface<Post> {

    private PostDaoInterface postDao;

    @Autowired
    public PostService(PostDaoInterface postDao){
        this.postDao = postDao;
    }

    @Override
    @Transactional
    public void add(Post entity) {
        postDao.add(entity);
    }

    @Override
    @Transactional
    public Post getById(int id) {
        return (Post) postDao.getById(id);
    }

    @Override
    @Transactional
    public void update(Post entity) {
        postDao.update(entity);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Post res = (Post) postDao.getById(id);
        postDao.delete(res);
    }

    @Override
    @Transactional
    public List<Post> getAll() {
        return postDao.getAll();
    }
}
