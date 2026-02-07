package com.techmaa.onlineexamsystem.admin.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.techmaa.onlineexamsystem.admin.dto.AddQuestion;
import com.techmaa.onlineexamsystem.admin.dto.Exam;
import com.techmaa.onlineexamsystem.admin.dto.GetExam;
import com.techmaa.onlineexamsystem.admin.emum.ExamStatus;
import com.techmaa.onlineexamsystem.admin.service.ExamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/exam")
@CrossOrigin("*")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/create")
    public ResponseEntity<String> createExam(@Valid @RequestBody Exam exam) {

        boolean created = examService.createExam(exam);

        if (created) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(" Exam created successfully");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(" Exam creation failed");
    }

    @PostMapping("/{id}/addquestion")
    public ResponseEntity<String> addQuestion(
            @PathVariable Long id,
            @Valid @RequestBody AddQuestion addQuestion) {

        boolean added = examService.addQuestion(id, addQuestion);

        if (added) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Question added successfully");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Question not added");
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<GetExam>> getAllExam(Authentication authentication) {
        System.out.println("Received Authentication: " + authentication);
        List<GetExam> exams = examService.getAllExam();

        return ResponseEntity.ok(exams);
    }

    @GetMapping("/role")
    public ResponseEntity<?> getRole(Authentication auth) {

        return ResponseEntity.ok(auth.getAuthorities());
    }

    @GetMapping("/{id}/questions")
    public ResponseEntity<List<com.techmaa.onlineexamsystem.response.Question>> getQuestionsByExamId(
            @PathVariable Long id) {
        List<com.techmaa.onlineexamsystem.response.Question> questions = examService.getQuestionsByExamId(id);
        return ResponseEntity.ok(questions);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestParam String status) {
        ExamStatus updatedStatus = examService.updateStatus(id, status);
        return ResponseEntity.ok(updatedStatus.name());
    }
}
