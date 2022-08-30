package com.example.spring_boot_project.form;

import javax.validation.GroupSequence;

@GroupSequence({ValidGroup1.class, ValidGroup2.class})
public interface GroupOrder {
}
