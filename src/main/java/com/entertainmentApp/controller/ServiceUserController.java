package com.entertainmentApp.controller;

import com.entertainmentApp.domain.User;
import com.entertainmentApp.service.UserService;
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
@RequestMapping(value = "/userService")
public class ServiceUserController {

    private UserService userService;


    @Autowired
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/view")
    public String viewService(final Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "serviceUser";
    }

    @GetMapping("")
    public String getService() {
        return "serviceUser";
    }

    @PostMapping("/delete")
    public String delUserById(final Model model, @RequestParam final Long id) {
        User user = userService.findById(id);
        if (user != null) {
            userService.delete(user);
            model.addAttribute("delUser", "Deleted successful");
        } else {
            model.addAttribute("delUser", "This User not exist");
        }
        return "serviceUser";
    }
}
