package com.entertainmentApp.dao;

import com.entertainmentApp.domain.Entertainment;
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
public class EntertainDaoImpl implements EntertainDao {

    private SessionFactory sessionFactory;

    public EntertainDaoImpl() {
    }

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
    public void save(final Entertainment entertainment) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entertainment);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(final Entertainment entertainment) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entertainment);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(final Entertainment entertainment) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entertainment);
        tx1.commit();
        session.close();
    }

    @Override
    public Entertainment findById(final Long id) {
        Session session = getSession();
        return (Entertainment) session.get(Entertainment.class, id);
    }

    @Override
    public List<Entertainment> findByName(final String name) {
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
        } catch (NoResultException ignored) {
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    public List<Entertainment> findAll() {
        Session session = getSession();
        return (List<Entertainment>) session.createQuery("From Entertainment ").list();

    }
}
