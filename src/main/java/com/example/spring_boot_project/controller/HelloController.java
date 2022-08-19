package com.example.spring_boot_project.controller;

import com.example.spring_boot_project.entity.Employee;
import com.example.spring_boot_project.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    private HelloService service;

    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    @PostMapping("/hello")
    public String postRequest(@RequestParam("text1") String str, Model model) {
        // Register the string received from the screen to Model
        model.addAttribute("sample", str);
// Screen transition to response.html
        return "hello/response";
    }

    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("text2") String id, Model model) {
        //search
        Employee employee = service.getEmployee(id);
        //save search to model
        model.addAttribute("employeeView", employee);
        return "hello/db";
    }
}
