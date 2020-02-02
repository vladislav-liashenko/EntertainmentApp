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

@Controller
public class AddEntertainmentController {

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
        return "add";
    }
    @GetMapping("/add")
    public String getAdd(Model model){

       return "add";
    }

    @GetMapping("/catalog")
    public String viewAdd(Model model){
        Iterable<Entertainment>entertainments=entertainmentService.findAll();
        model.addAttribute("entertainments",entertainments);
        return "catalog";
    }

    @PostMapping("/find")
    public String findEntertainment(@RequestParam String name,Model model){
       Iterable<Entertainment>entertainments=entertainmentService.findAll();
       List<Entertainment>entertainmentsFinder=new ArrayList<>();
        for (Entertainment entr:entertainments) {
            if (entr.getName().equals(name)) {
               entertainmentsFinder.add(entr);
                        model.addAttribute("entertainments", entertainmentsFinder);
            }
        }

    return "catalog";
    }

}
