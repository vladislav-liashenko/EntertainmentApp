package com.entertainmentApp.service;

import com.entertainmentApp.dao.EntertainDao;
import com.entertainmentApp.domain.Entertainment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EntertainmentServiceImpl implements EntertainmentService {

    private EntertainDao entertainDao;

    public EntertainmentServiceImpl() {
    }

    @Autowired
    public void setEntertainDao(final EntertainDao entertainDao) {
        this.entertainDao = entertainDao;
    }

    @Override
    @Transactional
    public void save(final Entertainment entertainment) {
        entertainDao.save(entertainment);
    }

    @Override
    @Transactional
    public void delete(final Entertainment entertainment) {
        entertainDao.delete(entertainment);
    }

    @Override
    @Transactional
    public void update(final Entertainment entertainment) {
        entertainDao.update(entertainment);
    }

    @Override
    @Transactional
    public List<Entertainment> findAll() {
        return entertainDao.findAll();
    }

    @Override
    @Transactional
    public List<Entertainment> findByName(final String name) {
        return entertainDao.findByName(name);
    }

    @Override
    @Transactional
    public Entertainment findById(final Long id) {
        return entertainDao.findById(id);
    }
}

