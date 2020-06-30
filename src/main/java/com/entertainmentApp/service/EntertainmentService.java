package com.entertainmentApp.service;

import com.entertainmentApp.domain.entertainment.Entertainment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntertainmentService {
    void save(Entertainment entertainment);

    void delete(Entertainment entertainment);

    void update(Entertainment entertainment);

    List<Entertainment> findAll();

    List<Entertainment> findByName(String name);

//    List<Entertainment> findByDate(Date date);

    Entertainment findById(Long id);
}
