package com.example.spring_boot_project.service;

import com.example.spring_boot_project.entity.UserMaster;

import java.util.List;

public interface UserService {

    /**
     * User signup
     */
    public void signup(UserMaster userMaster);

    /**
     * Get all users
     */
    public List<UserMaster> getUsers();

}
