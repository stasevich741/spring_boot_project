package com.example.spring_boot_project.repository;

import com.example.spring_boot_project.entity.UserMaster;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * User signup
     */
    public int insertOne(UserMaster userMaster);

}
