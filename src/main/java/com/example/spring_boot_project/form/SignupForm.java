package com.example.spring_boot_project.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignupForm {

    @NotBlank
    @Email
    private String userId;

    @NotBlank
    @Length(min = 6, max = 15, message = "password length min 6 max 15")
    @Pattern(regexp = "^[a-zA-Z\\d]+$")
    private String password;

    @NotBlank
    private String userName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date birthday;

    @Min(18)
    @Max(100)
    private Integer age;

    @NotNull
    private Integer gender;
}
