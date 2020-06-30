package com.entertainmentApp.dao;


import com.entertainmentApp.domain.entertainment.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void save(final Category category) {
        Session session = getSession();
        session.save(category);
    }

    @Override
    public void delete(final Category category) {
        Session session = getSession();
        session.delete(category);
    }

    @Override
    public void update(final Category category) {
        Session session = getSession();
        session.update(category);
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> findAll() {
        Session session = getSession();
        return (List<Category>) session.createQuery("From Category ").list();
    }

    @Override
    public Category findByName(final String name) {

        Category results = null;
        try {
            Session session = getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Category> cr = cb.createQuery(Category.class);
            Root<Category> root = cr.from(Category.class);
            cr.select(root).
                    where(cb.like(root.get("name"), name));
            Query<Category> query = session.createQuery(cr);
            results = query.getSingleResult();
        } catch (NoResultException ignored) {
        }
        return results;
    }
}
