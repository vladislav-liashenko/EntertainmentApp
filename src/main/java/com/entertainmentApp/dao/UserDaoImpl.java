package com.entertainmentApp.dao;

import com.entertainmentApp.domain.user.User;
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
public class UserDaoImpl implements UserDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(final User user) {
        Session session = getSession();
        session.save(user);
    }

    @Override
    public void delete(final User user) {
        Session session = getSession();
        session.delete(user);
    }

    @Override
    public void update(final User user) {
        Session session = getSession();
        session.update(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Session session = getSession();
        return (List<User>) session.createQuery("From User ").list();
    }

    @Override
    public User findById(final Long id) {
        Session session = getSession();
        User user = null;
        try {
            user = (User) session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUsername(final String username) {
        User user = null;
        try {
            Session session = getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> cr = cb.createQuery(User.class);
            Root<User> root = cr.from(User.class);
            cr.select(root).
                    where(cb.like(root.get("username"), username));
            Query<User> query = session.createQuery(cr);
            user = (User) query.getSingleResult();
        } catch (NoResultException ignored) {
            ignored.printStackTrace();
        }
        return user;
    }

}
