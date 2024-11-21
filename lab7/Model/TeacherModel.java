package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherModel {
    @NotEmpty(message = " teacher name can not be empty")
    @Size(min = 2,message = "name length at least should has 2 character")
    private String teacherName;

    @NotEmpty(message = " The id can not be null")
    @Size(min = 4,max = 4,message = " ID must be exactly 4 characters")
    private String id;

    @NotEmpty(message = "email can not be null")
    @Email(message = " you should enter valid email")
    private String email;

    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;

    @NotEmpty(message = "teacherForWichLanguage can not be null ")
    @Pattern(regexp = "^(Java|Python|Flutter)$",
            message = "Language must be one of the following: Java, Python, or Flutter")

    private String teacherForWichLanguage ;


    @NotNull(message = " cources amount can not be null")
    private int howManyLissonGive;


}
