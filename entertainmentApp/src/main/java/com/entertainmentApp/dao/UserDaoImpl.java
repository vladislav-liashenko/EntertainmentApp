package com.entertainmentApp.dao;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Entertainment> findAll() {
        Session session = getSession();
        List<Entertainment> users = session.createQuery("From User ").list();
        return users;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> cr = cb.createQuery(User.class);
            Root<User> root = cr.from(User.class);
            cr.select(root).
                    where(cb.like(root.get("username"), username));
            Query<User> query = session.createQuery(cr);
            user = (User) query.getSingleResult();
            session.close();
        } catch (NoResultException nre) {
        }
        return user;
    }
}
