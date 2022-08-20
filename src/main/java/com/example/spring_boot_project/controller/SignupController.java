package com.example.spring_boot_project.controller;

import com.example.spring_boot_project.service.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class SignupController {

    @Autowired
    private UserApplicationService userApplicationService;

    /**
     * Display the user signup screen
     */
    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale) {
        Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);

        return "user/signup";
    }

    /**
     * User signup process
     */
    @PostMapping("/signup")
    public String postSignup() {

        return "redirect:/login";
    }
}
