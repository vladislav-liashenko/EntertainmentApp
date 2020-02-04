package com.entertainmentApp.controller;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import static java.lang.Long.parseLong;

@Controller
public class ServiceEntertainmentController {
    //Admin(service)line
    //http://localhost:8090/service

    private EntertainmentService entertainmentService;
    @Autowired
    public void setEntertainmentService(EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @PostMapping("/add")
    public  String addEntertainment(@RequestParam String name,@RequestParam String description,
           @RequestParam String address,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
            Model model){
        Entertainment entertainment =new Entertainment(name,description,
                address, date);
        entertainmentService.save(entertainment);
        return "serviceEnter";
    }
    @GetMapping("/service")
    public String getService(){ return "serviceEnter"; }

    @GetMapping("/view")
    public String viewService(Model model){
        Iterable<Entertainment>entertainments=entertainmentService.findAll();
        model.addAttribute("entertainments",entertainments);
       return "serviceEnter";
    }

    @PostMapping("/delete")
    public String delEntertainment(@RequestParam Long id){
        Entertainment entertainment=entertainmentService.findById(id);
        if(entertainment!=null) {
            entertainmentService.delete(entertainment);
        }
    return "serviceEnter";
    }
}
