package com.entertainmentApp.controller;


import com.entertainmentApp.domain.entertainment.Entertainment;
import com.entertainmentApp.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    private EntertainmentService entertainmentService;

    @Autowired
    public void setEntertainmentService(final EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @GetMapping("/catalog/cinema")
    public String distrubtionCinema(final Model model) {
        Iterable<Entertainment> entertainments = entertainmentService.findAll();
        model.addAttribute("entertainments", entertainments);
        return "/categories/Cinema";

    }

    @GetMapping("/catalog/zoopark")
    public String distrubtionZooPark(final Model model) {
        Iterable<Entertainment> entertainments = entertainmentService.findAll();
        model.addAttribute("entertainments", entertainments);
        return "/categories/ZooPark";

    }

    @GetMapping("/catalog/bowling")
    public String distrubtionBowling(final Model model) {
        Iterable<Entertainment> entertainments = entertainmentService.findAll();
        model.addAttribute("entertainments", entertainments);
        return "/categories/Bowling";
    }
}


//    @PostMapping("/find")
//    public String findEntertainment(@RequestParam final String name, final Model model) {
//        List<Entertainment> entertainments = entertainmentService.findByName(name);
//        model.addAttribute("entertainments", entertainments);
//        return "catalog";
//    }
//    @PostMapping("/find")
//    public String findEntertainmentByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") final Date date, final Model model) {
//        List<Entertainment> entertainments = entertainmentService.findByDate(date);
//        if (entertainments != null) {
//            model.addAttribute("entertainments", entertainments);
//        }
//        return "categories/**";
//    }

