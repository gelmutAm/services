package com.ssu.dao.implementations;

import com.ssu.dao.interfaces.PostDaoInterface;
import com.ssu.model.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class PostDao implements PostDaoInterface<Post> {

    private SessionFactory sessionFactory;

    @Autowired
    public PostDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Post entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public Post getById(int id) {
        return sessionFactory.getCurrentSession().get(Post.class, id);
    }

    @Override
    public void update(Post entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(Post entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public List<Post> getAll() {
        return (List<Post>) sessionFactory.getCurrentSession().createQuery("from Post").list();
    }
}
