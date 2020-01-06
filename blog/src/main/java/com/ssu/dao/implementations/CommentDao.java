package com.ssu.dao.implementations;

import com.ssu.dao.interfaces.CommentDaoInterface;
import com.ssu.model.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class CommentDao implements CommentDaoInterface<Comment> {

    private SessionFactory sessionFactory;

    @Autowired
    public CommentDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Comment entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public Comment getById(int id) {
        return sessionFactory.getCurrentSession().get(Comment.class, id);
    }

    @Override
    public void update(Comment entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(Comment entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public List<Comment> getAll() {
        return (List<Comment>) sessionFactory.getCurrentSession().createQuery("from Comment").list();
    }

    @Override
    public ArrayList<Integer> getAllUserId(int postId){
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Integer> query = criteriaBuilder.createQuery(Integer.class);
        Root<Comment> root = query.from(Comment.class);
        query.select(root.get("userId")).where(criteriaBuilder.equal(root.get("postId"), postId));
        Query q = sessionFactory.getCurrentSession().createQuery(query);

        return (ArrayList<Integer>) q.getResultList();
    }
}
