package com.example.spring_boot_project.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserMaster {
    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private Integer age;
    private Integer gender;
    private Integer departmentId;
    private String role;
}
