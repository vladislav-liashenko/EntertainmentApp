package com.entertainmentApp.service;

import com.entertainmentApp.dao.EntertainmentDao;
import com.entertainmentApp.domain.entertainment.Entertainment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntertainmentServiceImpl implements EntertainmentService {

    private EntertainmentDao entertainmentDao;

    public EntertainmentServiceImpl() {
    }

    @Autowired
    public void setEntertainmentDao(final EntertainmentDao entertainmentDao) {
        this.entertainmentDao = entertainmentDao;
    }

    @Override
    @Transactional
    public void save(final Entertainment entertainment) {
        entertainmentDao.save(entertainment);
    }

    @Override
    @Transactional
    public void delete(final Entertainment entertainment) {
        entertainmentDao.delete(entertainment);
    }

    @Override
    @Transactional
    public void update(final Entertainment entertainment) {
        entertainmentDao.update(entertainment);
    }

    @Override
    @Transactional
    public List<Entertainment> findAll() {
        return entertainmentDao.findAll();
    }

    @Override
    @Transactional
    public List<Entertainment> findByName(final String name) {
        return entertainmentDao.findByName(name);
    }
//
//    @Override
//    @Transactional
//    public List<Entertainment> findByDate(final Date date) {
//        return entertainmentDao.findByDate(date);
//    }

    @Override
    @Transactional
    public Entertainment findById(final Long id) {
        return entertainmentDao.findById(id);
    }
}

