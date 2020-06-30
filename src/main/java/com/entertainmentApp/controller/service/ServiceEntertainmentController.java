package com.entertainmentApp.controller.service;

import com.entertainmentApp.domain.entertainment.Category;
import com.entertainmentApp.domain.entertainment.Entertainment;
import com.entertainmentApp.service.CategoryService;
import com.entertainmentApp.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/EntrService")
public class ServiceEntertainmentController {
    //ADMIN(service)line
    //http://localhost:8090/service

    private EntertainmentService entertainmentService;

    private CategoryService categoryService;
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public void setEntertainmentService(final EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @Autowired
    public void setCategoryService(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void addFiles(final Entertainment entertainment, final MultipartFile file) throws IOException {
        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuid = UUID.randomUUID().toString();
            String resultFileName = uuid + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            entertainment.setFileName(resultFileName);
        }

    }

    @PostMapping("/add")
    public String addEntertainment(
            @RequestParam final String name, @RequestParam final String description,
            @RequestParam final String address,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final Date date,
            @RequestParam final String categoryName, final Model model,
            @RequestParam final MultipartFile fileUpload) throws IOException {

        Category category = categoryService.findByName(categoryName);
        if (category != null) {
            Entertainment entertainment = new Entertainment(name, description, address, date);
            entertainment.setCategory(category);
            addFiles(entertainment, fileUpload);
            entertainmentService.save(entertainment);
            model.addAttribute("messages", "Added successful");
        } else {
            model.addAttribute("messages", "Not added");
        }
        return "service/serviceEnter";
    }


    @GetMapping("")
    public String getService() {
        return "service/serviceEnter";
    }

    @GetMapping("/view")
    public String viewService(final Model model) {
        Iterable<Entertainment> entertainments = entertainmentService.findAll();
        model.addAttribute("entertainments", entertainments);
        return "service/serviceEnter";
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
        return "service/serviceEnter";
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
        return "service/serviceEnter";
    }
}
