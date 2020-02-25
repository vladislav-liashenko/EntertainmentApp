package com.entertainmentApp.service;

import com.entertainmentApp.domain.Entertainment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntertainmentService {
    void save(Entertainment entertainment);

    void delete(Entertainment entertainment);

    void update(Entertainment entertainment);

    List<Entertainment> findAll();

    List<Entertainment> findByName(String name);

    Entertainment findById(Long id);
}
