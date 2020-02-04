package com.entertainmentApp.dao;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    

    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx1= session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx1= session.beginTransaction();
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
        Session session=sessionFactory.getCurrentSession();
        List<Entertainment>users=session.createQuery("From User ").list();
        return users;
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Criteria criteria=session.createCriteria(User.class);
        User user =(User)criteria.add(Restrictions.eq("username",username)).uniqueResult();
        session.close();
        return user;
    }
}
