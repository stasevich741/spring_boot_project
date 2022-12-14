package com.example.spring_boot_project.controller;

import com.example.spring_boot_project.entity.UserMaster;
import com.example.spring_boot_project.form.GroupOrder;
import com.example.spring_boot_project.form.SignupForm;
import com.example.spring_boot_project.service.UserApplicationService;
import com.example.spring_boot_project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

    @Autowired
    private UserApplicationService userApplicationService;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Display the user signup screen
     */
    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
        Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);

        return "user/signup";
    }

    /**
     * User signup process
     */
    @PostMapping("/signup")
    public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getSignup(model, locale, form);
        }
        log.info(form.toString());

        // Convert form to UserMaster class
        UserMaster user = modelMapper.map(form, UserMaster.class);
        // user signup
        userService.signup(user);

        return "redirect:/login/login";
    }
}