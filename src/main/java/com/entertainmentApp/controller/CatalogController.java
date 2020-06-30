package com.entertainmentApp.controller;

import com.entertainmentApp.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {
    //Custom(user)line

    private EntertainmentService entertainmentService;

    @Autowired
    public void setEntertainmentService(final EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    /**
     * Return a service link if the role is ADMIN.
     *
     * @param model
     * @return catalog
     */
    @GetMapping("/catalog")
    public String viewCatalog(final Model model) {
        String author = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        if (!author.equals(null)) {
            model.addAttribute("author", author);
        }
        return "catalog";
    }

    //http:/localhost:8090/
    @GetMapping("/")
    public String greeting() {
        return "menu";
    }
}
