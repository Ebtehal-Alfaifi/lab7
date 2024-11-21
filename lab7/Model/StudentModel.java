package com.example.lab7.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Valid
public class StudentModel {
    @NotEmpty(message = " the id should not be empty")
    @Size(min = 4,max = 4,message = " ID must be exactly 4 characters ")
    private String id;


    @NotEmpty(message = " you should enter name ")
    @Size(min = 2,message = " you can not enter name less than 2")
    private String name;


    @NotEmpty(message = " gender can not be null")
    @Pattern(regexp =  "^(Male|Female)$", message = "Gender must be either 'Male' or 'Female'")
    private String gender;



    @NotEmpty(message = " you should enter student level")
    @Pattern(regexp = "^(beginner|intermediate)$",
            message = "The level must be either 'beginner' or 'intermediate'")
    private String StudentLevel;


    @NotEmpty(message = " email can not be null")
    @Email(message = " you should enter valid email")
    private String email;



    @NotEmpty(message = "password can not be null ")
    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;



    @NotNull(message = " courses can not be null")
    @Min(value = 0)
    @Max(value = 30,message = " you can not enter courses more than 30")
    private int lesion;


    @NotNull(message = " age can not be null")
    @Min(value = 15,message = "age can not be less than 15")
    @Max(value = 30,message = " age can not be more than 30")
    private int age;


    @NotNull(message = " finish can not be null")
    @AssertFalse(message = " finish can not be true")
    private boolean isFinish;

}
