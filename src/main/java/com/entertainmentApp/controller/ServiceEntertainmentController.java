package com.entertainmentApp.controller;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/service")
public class ServiceEntertainmentController {
    //ADMIN(service)line
    //http://localhost:8090/service

    private EntertainmentService entertainmentService;

    @Autowired
    public void setEntertainmentService(final EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @PostMapping("/add")
    public String addEntertainment(
            @RequestParam final String name, @RequestParam final String description,
            @RequestParam final String address,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final Date date) {
        Entertainment entertainment = new Entertainment(name, description,
                address, date);
        entertainmentService.save(entertainment);
        return "serviceEnter";
    }

    @GetMapping("")
    public String getService() {
        return "serviceEnter";
    }

    @GetMapping("/view")
    public String viewService(final Model model) {
        Iterable<Entertainment> entertainments = entertainmentService.findAll();
        model.addAttribute("entertainments", entertainments);
        return "serviceEnter";
    }

    @PostMapping("/delete")
    public String delEntertainment(@RequestParam final Long id, final Model model) {
        Entertainment entertainment = entertainmentService.findById(id);
        if (entertainment != null) {
            entertainmentService.delete(entertainment);
            model.addAttribute("delEntertainment", "Deleted successful");
        } else {
            model.addAttribute("delEntertainment", "This entertainment not exist");
        }
        return "serviceEnter";
    }

    @PostMapping("/update")
    public String updEntertainment(@RequestParam final Long id, @RequestParam final String description,
                                   @RequestParam final String address,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final Date date,
                                   final Model model) {
        Entertainment entertainment = entertainmentService.findById(id);
        if (entertainment != null) {
            entertainment.setDescription(description);
            entertainment.setAddress(address);
            entertainment.setDate(date);
            entertainmentService.update(entertainment);
            model.addAttribute("entertainment", entertainment.toString());
        } else {
            model.addAttribute("entertainment", "This entertainment not exist");
        }
        return "serviceEnter";
    }
}
