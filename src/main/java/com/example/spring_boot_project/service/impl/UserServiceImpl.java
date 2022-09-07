package com.example.spring_boot_project.service.impl;

import com.example.spring_boot_project.entity.UserMaster;
import com.example.spring_boot_project.repository.UserMapper;
import com.example.spring_boot_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * User signup
     */
    @Override
    public void signup(UserMaster user) {
        user.setDepartmentId(1);
        user.setRole("ROLE_GENERAL");
        userMapper.insertOne(user);
    }

    /**
     * Get user
     */
    @Override
    public List<UserMaster> getUsers() {
        return userMapper.findMany();
    }

    /**
     * Get user(1record)
     */
    @Override
    public UserMaster findOne(String id) {
        return userMapper.findOne(id);
    }

    /**
     * Update user
     */
    @Override
    public void updateUserOne(String userId, String password, String userName) {
        userMapper.updateOne(userId, password, userName);
    }

    /**
     * Delete user
     */
    @Override
    public void deleteUserOne(String userId) {
        userMapper.deleteOne(userId);
    }
}
