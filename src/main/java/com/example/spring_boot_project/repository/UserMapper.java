package com.example.spring_boot_project.repository;

import com.example.spring_boot_project.entity.UserMaster;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * User signup
     */
    public int insertOne(UserMaster userMaster);

    /**
     * Get user
     */
    public List<UserMaster> findMany();
}
