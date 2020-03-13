package com.entertainmentApp.controller;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public void setEntertainmentService(final EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    /**
     * This is method display catalog.
     * And returns a service link if the role is ADMIN.
     * @param model
     * @return catalog
     */
    @GetMapping("/catalog")
    public String viewCatalog(final Model model) {
        Iterable<Entertainment> entertainments = entertainmentService.findAll();
        model.addAttribute("entertainments", entertainments);
        String author = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        if (!author.equals(null)) {
            model.addAttribute("author", author);
        }
        return "catalog";
    }

    /**
     * This is method find entertainment by name.
     * @param name
     * @param model
     * @return catalog
     */
    @PostMapping("/find")
    public String findEntertainment(@RequestParam final String name, final Model model) {
        List<Entertainment> entertainments = entertainmentService.findByName(name);
        model.addAttribute("entertainments", entertainments);
        return "catalog";
    }
}
