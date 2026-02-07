package com.techmaa.onlineexamsystem.admin.service;

import java.util.List;

import com.techmaa.onlineexamsystem.admin.dto.AddQuestion;
import com.techmaa.onlineexamsystem.admin.dto.Exam;
import com.techmaa.onlineexamsystem.admin.dto.GetExam;
import com.techmaa.onlineexamsystem.admin.emum.ExamStatus;
import com.techmaa.onlineexamsystem.response.Question;

public interface ExamService {
    public Boolean createExam(Exam exam);
    public Boolean addQuestion(Long examId, AddQuestion addQuestion);
    public List<GetExam> getAllExam();
    public List<Question> getQuestionsByExamId(Long examId);
    public ExamStatus updateStatus(Long examId, String status);

}
