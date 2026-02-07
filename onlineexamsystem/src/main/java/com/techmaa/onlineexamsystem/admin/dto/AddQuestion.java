package com.techmaa.onlineexamsystem.admin.dto;

import com.techmaa.onlineexamsystem.admin.emum.Option;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddQuestion {

    @NotBlank(message = "Question cannot be empty")
    private String question;

    @NotBlank(message = "Option A cannot be empty")
    private String optionA;

    @NotBlank(message = "Option B cannot be empty")
    private String optionB;

    @NotBlank(message = "Option C cannot be empty")
    private String optionC;

    @NotBlank(message = "Option D cannot be empty")
    private String optionD;

    @NotNull(message = "Correct option is required")
    private Option correctOption;

    @NotNull(message = "Marks are required")
    @Min(value = 1, message = "Marks must be at least 1")
    private Integer marks;
}
