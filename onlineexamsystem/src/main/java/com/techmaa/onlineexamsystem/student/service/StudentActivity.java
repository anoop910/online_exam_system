package com.techmaa.onlineexamsystem.student.service;

import java.util.List;

import com.techmaa.onlineexamsystem.student.dto.AvailableExam;
import com.techmaa.onlineexamsystem.student.dto.ExamSubmitRequest;
import com.techmaa.onlineexamsystem.student.dto.StudentGetQuestion;

public interface StudentActivity {
    public List<AvailableExam> getActiveExams();

    public List<StudentGetQuestion> getQuestionsByExamId(Long examId);
    public String ExamSubmit(ExamSubmitRequest examSubmitRequest, String username);
}
