package com.example.spring_boot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class UserApplicationService {

    @Autowired
    private MessageSource messageSource;

    public Map<String, Integer> getGenderMap() {
        Map<String, Integer> genderMap = new HashMap<>();
        String male = messageSource.getMessage("male", null, Locale.ENGLISH);
        String female = messageSource.getMessage("female", null, Locale.ENGLISH);
        genderMap.put(male, 1);
        genderMap.put(female, 2);
        return genderMap;
    }
}
