package com.entertainmentApp.dao;

import com.entertainmentApp.domain.entertainment.Entertainment;
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
public class EntertainmentDaoImpl implements EntertainmentDao {

    private SessionFactory sessionFactory;

    public EntertainmentDaoImpl() {
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
        Session session = getSession();
        session.save(entertainment);
    }

    @Override
    public void delete(final Entertainment entertainment) {
        Session session = getSession();
        session.delete(entertainment);
    }

    @Override
    public void update(final Entertainment entertainment) {
        Session session = getSession();
        session.update(entertainment);
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
            Session session = getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Entertainment> cr = cb.createQuery(Entertainment.class);
            Root<Entertainment> root = cr.from(Entertainment.class);
            cr.select(root).
                    where(cb.like(root.get("name"), name));
            Query<Entertainment> query = session.createQuery(cr);
            results = query.getResultList();
        } catch (NoResultException ignored) {
        }
        return results;
    }

//    @Override
//    public List<Entertainment> findByDate(final @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
//        List<Entertainment> result = null;
//
//
//        try {
//            Session session = sessionFactory.openSession();
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Entertainment> cr = cb.createQuery(Entertainment.class);
//            Root<Entertainment> root = cr.from(Entertainment.class);
//            cr.select(root).
//                    where(cb.like(root.get("date"), (Expression<String>) date));
//            Query<Entertainment> query = session.createQuery(cr);
//            result = query.getResultList();
//            session.close();
//        } catch (NoResultException nre) {
//        }
//        return result;
//    }

    @SuppressWarnings("unchecked")
    public List<Entertainment> findAll() {
        Session session = getSession();
        return (List<Entertainment>) session.createQuery("From Entertainment ").list();

    }

}
