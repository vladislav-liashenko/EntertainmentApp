package com.entertainmentApp.controller.service;

import com.entertainmentApp.domain.user.Role;
import com.entertainmentApp.domain.user.User;
import com.entertainmentApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/UserService")
public class ServiceUserController {

    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setbCryptPasswordEncoder(final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @GetMapping("/view")
    public String viewService(final Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "service/serviceUser";
    }

    @GetMapping("")
    public String getService() {
        return "service/serviceUser";
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
        return "service/serviceUser";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(final Model model,
                           final @RequestParam String adminName,
                           final @RequestParam String adminPassword) {
        User userDb = userService.findByUsername(adminName);
        if (userDb != null) {
            model.addAttribute("message", "Name already exists");
            return "service/serviceUser";
        } else {
            User user = new User();
            user.setActive(true);
            user.setRole(Collections.singleton(Role.ADMIN));
            user.setUsername(adminName);
            user.setPassword(bCryptPasswordEncoder.encode(adminPassword));
            userService.save(user);
            model.addAttribute("message", "Admin added");
        }
        return "service/serviceUser";
    }
}
