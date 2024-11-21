package com.example.lab7.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LanguageModel {

    @NotEmpty(message = " language name can not be null")
    @Pattern(regexp = "^(Java|Python|Flutter)$",
            message = "Language must be one of the following: Java, Python, or Flutter")
private String languageName;




@NotNull(message = " Start date can not be null")
@FutureOrPresent(message = "Course start date must be today or in the future")
@JsonFormat(pattern = "yyyy-MM-dd" )
@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "The date must be in the format yyyy-MM-dd")
private LocalDate courseStartDate;



@NotNull(message = " end Date can not be null")
@Future(message = " end date must be in the future")
@JsonFormat(pattern = "yyyy-MM-dd" )
@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "The date must be in the format yyyy-MM-dd")
private LocalDate coursesEndDate;

    @NotEmpty(message = "Language level cannot be empty")
    @Pattern(regexp = "^(Beginner|Intermediate|Advanced)$", message = "Language level must be one of the following: Beginner, Intermediate, Advanced")
    private String languageLevel;
}
