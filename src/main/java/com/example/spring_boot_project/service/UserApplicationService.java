package com.example.spring_boot_project.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserApplicationService {

    public Map<String, Integer> getGenderMap() {
        Map<String, Integer> genderMap = new HashMap<>();
        genderMap.put("male", 1);
        genderMap.put("female", 2);
        return genderMap;
    }
}
