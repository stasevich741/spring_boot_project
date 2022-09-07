package com.example.spring_boot_project.controller;

import com.example.spring_boot_project.entity.UserMaster;
import com.example.spring_boot_project.form.UserDetailForm;
import com.example.spring_boot_project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserDetailController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Display user details screen
     */
    @GetMapping("/detail/{userId:.+}")
    public String getUser(UserDetailForm form, Model model,
                          @PathVariable("userId") String userId) {
        // Get user
        UserMaster user = userService.findOne(userId);
        user.setPassword(null);
        form = modelMapper.map(user, UserDetailForm.class);
        // Registered in Model
        model.addAttribute("userDetailForm", form);
        // Display user details screen
        return "user/detail";
    }

    /**
     * User update process
     */
    @PostMapping(value = "/detail", params = "update")
    public String updateUser(UserDetailForm form, Model model) {
// Update user
        userService.updateUserOne(form.getUserId(),
                form.getPassword(),
                form.getUserName());
// Redirect to user list screen
        return "redirect:/user/list";
    }

    /**
     * User delete process
     */
    @PostMapping(value = "/detail", params = "delete")
    public String deleteUser(UserDetailForm form, Model model) {
// Delete user
        userService.deleteUserOne(form.getUserId());
// Redirect to user list screen
        return "redirect:/user/list";
    }
}