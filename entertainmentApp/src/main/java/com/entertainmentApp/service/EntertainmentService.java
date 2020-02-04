package com.entertainmentApp.service;

import com.entertainmentApp.domain.Entertainment;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface EntertainmentService {
    public void save(Entertainment entertainment);
    public void delete(Entertainment entertainment);
    public void update (Entertainment entertainment);
    public List<Entertainment> findAll();
    public List<Entertainment> findByName(String name);
    public Entertainment findById(Long id);
}
