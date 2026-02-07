package com.techmaa.onlineexamsystem.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvailableExam {
    private Long id;
    private String examName;
    private Integer examDuration;
    private Integer totalMarks;
    private Integer totalQuestions;

}
