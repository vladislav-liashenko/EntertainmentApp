package com.entertainmentApp.controller;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CatalogController {
    //Custom(user)line

    private EntertainmentService entertainmentService;

    @Autowired
    public void setEntertainmentService(EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @GetMapping("/catalog")
    public String viewCatalog(Model model) {
        Iterable<Entertainment> entertainments = entertainmentService.findAll();
        model.addAttribute("entertainments", entertainments);
        return "catalog";
    }

    @PostMapping("/find")
    public String findEntertainment(@RequestParam String name, Model model) {
        List<Entertainment> entertainments = entertainmentService.findByName(name);
        model.addAttribute("entertainments", entertainments);
        return "catalog";
    }
}
