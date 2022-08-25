package com.example.spring_boot_project.service.impl;

import com.example.spring_boot_project.entity.UserMaster;
import com.example.spring_boot_project.repository.UserMapper;
import com.example.spring_boot_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void signup(UserMaster user) {
        user.setDepartmentId(1);
        user.setRole("ROLE_GENERAL");
        userMapper.insertOne(user);
    }
}
