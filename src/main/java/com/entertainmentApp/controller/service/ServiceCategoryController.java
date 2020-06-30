package com.entertainmentApp.controller.service;

import com.entertainmentApp.domain.entertainment.Category;
import com.entertainmentApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/CategoryService")
public class ServiceCategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/add")
    public String addCategory(@RequestParam final String name, final Model model) {
        Category catg = categoryService.findByName(name);
        if (catg == null) {
            Category category = new Category(name);
            categoryService.save(category);
        } else {
            model.addAttribute("exist", "Category exist");
        }
        return "service/serviceCategory";
    }

    @GetMapping("")
    public String getService() {
        return "service/serviceCategory";
    }

    @GetMapping("/view")
    public String viewService(final Model model) {
        Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "service/serviceCategory";
    }
}
