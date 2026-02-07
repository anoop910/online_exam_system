package com.techmaa.onlineexamsystem.student.dto;

import lombok.Data;

@Data
public class AnswerDTO {
    private Long questionId;
    private String selectedOption;
    
}
