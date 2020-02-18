package com.entertainmentApp.dao;

import com.entertainmentApp.domain.Entertainment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EntertainDaoImpl implements EntertainDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    public EntertainDaoImpl() {
    }

    @Override
    public void save(Entertainment entertainment) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entertainment);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Entertainment entertainment) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entertainment);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Entertainment entertainment) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entertainment);
        tx1.commit();
        session.close();
    }

    @Override
    public Entertainment findById(Long id) {
        Session session = getSession();
        return (Entertainment) session.get(Entertainment.class, id);
    }

    @Override
    public List<Entertainment> findByName(String name) {
        List<Entertainment> results = null;
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Entertainment> cr = cb.createQuery(Entertainment.class);
            Root<Entertainment> root = cr.from(Entertainment.class);
            cr.select(root).
                    where(cb.like(root.get("name"), name));
            Query<Entertainment> query = session.createQuery(cr);
            results = query.getResultList();
            session.close();
        } catch (NoResultException nre) {
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    public List<Entertainment> findAll() {
        Session session = getSession();
        List<Entertainment> entertainments = session.createQuery("From Entertainment ").list();
        return entertainments;

    }

}