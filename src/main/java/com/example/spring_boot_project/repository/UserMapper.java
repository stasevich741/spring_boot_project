package com.example.spring_boot_project.repository;

import com.example.spring_boot_project.entity.UserMaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * User signup
     */
    int insertOne(UserMaster userMaster);

    /**
     * Get all users
     */
    List<UserMaster> findMany();

    /**
     * Get user by id
     */
    UserMaster findOne(String id);

    /**
     * Update user
     */
    void updateOne(@Param("userId") String userId,
                   @Param("password") String password,
                   @Param("userName") String userName);

    /**
     * Delete user
     */
    int deleteOne(@Param("userId") String userId);
}
