package com.entertainmentApp.dao;

import com.entertainmentApp.domain.Entertainment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EntertainDaoImpl implements EntertainDao {

    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public EntertainDaoImpl(){}

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
    Transaction tx1= session.beginTransaction();
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
    public Entertainment findByName(String name){
        Session session = sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Entertainment.class);
       Entertainment entertainment =(Entertainment) criteria.add(Restrictions.eq("name",name)).uniqueResult();
        return entertainment;
    }

    @SuppressWarnings("unchecked")
    public List<Entertainment> findAll() {
        Session session=sessionFactory.getCurrentSession();
        List<Entertainment>entertainments=session.createQuery("From Entertainment ").list();
        return entertainments;

    }



}