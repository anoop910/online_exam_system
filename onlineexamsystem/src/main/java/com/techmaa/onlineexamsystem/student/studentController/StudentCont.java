package com.techmaa.onlineexamsystem.student.studentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmaa.onlineexamsystem.student.dto.AvailableExam;
import com.techmaa.onlineexamsystem.student.dto.ExamSubmitRequest;
import com.techmaa.onlineexamsystem.student.dto.StudentGetQuestion;
import com.techmaa.onlineexamsystem.student.service.StudentActivity;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
@PreAuthorize("hasRole('STUDENT')")
public class StudentCont {

    @Autowired
    private StudentActivity studentActivity;

    @GetMapping("/availableexams")
    public List<AvailableExam> getActiveExams() {
        return studentActivity.getActiveExams();
    }

    @GetMapping("/get/question/{id}")
    public List<StudentGetQuestion> getQuestions(@PathVariable Long id) {
        return studentActivity.getQuestionsByExamId(id);
    }

    @PostMapping("/submitExam")
    public ResponseEntity<?> submitExam(@RequestBody ExamSubmitRequest request) {

        // ✅ Get Username from JWT Authentication
        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        System.out.println("Logged in Student: " + username);

        String result = studentActivity.ExamSubmit(request, username);

        return ResponseEntity.ok(result);
    }

}
