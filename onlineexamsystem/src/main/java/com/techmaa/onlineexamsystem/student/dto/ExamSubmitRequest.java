package com.techmaa.onlineexamsystem.student.dto;

import java.util.List;

import lombok.Data;

@Data
public class ExamSubmitRequest {
    private Long examId;
    private List<AnswerDTO> answers;
}
