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

    @Autowired
    public void setEntertainDao(EntertainDao entertainDao) {
        this.entertainDao = entertainDao;
    }

    public EntertainmentServiceImpl() {
    }

    @Override
    @Transactional
    public void save(Entertainment entertainment) {
        entertainDao.save(entertainment);
    }

    @Override
    @Transactional
    public void delete(Entertainment entertainment) {
        entertainDao.delete(entertainment);
    }

    @Override
    @Transactional
    public void update(Entertainment entertainment) {
        entertainDao.update(entertainment);
    }

    @Override
    @Transactional
    public List<Entertainment> findAll() {
        return entertainDao.findAll();
    }

    @Override
    @Transactional
    public List<Entertainment> findByName(String name) {
        return entertainDao.findByName(name);
    }

    @Override
    @Transactional
    public Entertainment findById(Long id) {
        return entertainDao.findById(id);
    }
}

