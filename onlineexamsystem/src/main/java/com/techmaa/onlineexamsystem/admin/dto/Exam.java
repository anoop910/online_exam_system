package com.techmaa.onlineexamsystem.admin.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Exam {
    @NotEmpty(message = "Enter Exam Name")
    private String examName;
    @NotNull(message = "Enter Exam Duration")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer examDuration;
}
