package com.hai.repository;

import com.hai.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Post> findAll() {
        TypedQuery<Post> query = em.createQuery("select p from Post p",Post.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Post findById(Long id) {
        TypedQuery<Post> query = em.createQuery("select p from Post p where p.id=:id",Post.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void saveOrUpdate(Post model) {
    if (model.getId() == null){
        em.persist(model);
    }else {
        em.merge(model);
    }
    }


    @Transactional
    @Override
    public void remove(Long id) {
        em.remove(findById(id));
    }
}
