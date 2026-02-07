package com.techmaa.onlineexamsystem.admin.dto;

import com.techmaa.onlineexamsystem.admin.emum.ExamStatus;

public class GetExam {   // ✅ must be public
    private Long id;
    private String examName;
    private Integer examDuration;
    private Integer totalMarks;
    private Integer totalQuestions;
    private ExamStatus status;

    // ✅ public constructor
    public GetExam(Long id, String examName, Integer examDuration, Integer totalMarks, Integer totalQuestions, ExamStatus status) {
        this.id= id;
        this.examName = examName;
        this.examDuration = examDuration;
        this.totalMarks = totalMarks;
        this.totalQuestions = totalQuestions;
        this.status = status;
    }

    // getters...
    public Long getId(){
        return id;
    }

    public String getExamName() {
        return examName;
    }

    public Integer getExamDuration() {
        return examDuration;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public ExamStatus getStatus() {
        return status;
    }
    
    
}

