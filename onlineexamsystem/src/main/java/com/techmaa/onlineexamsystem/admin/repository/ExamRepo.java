package com.techmaa.onlineexamsystem.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techmaa.onlineexamsystem.admin.dto.GetExam;
import com.techmaa.onlineexamsystem.admin.entity.Exam;
import com.techmaa.onlineexamsystem.student.dto.AvailableExam;

@Repository
public interface ExamRepo extends JpaRepository<Exam, Long> {

    @Query("""
            SELECT new com.techmaa.onlineexamsystem.admin.dto.GetExam(
                e.id,
                 e.examName,
                 e.examDuration,
                 e.totalMarks,
                 e.totalQuestions,
                 e.status
            )
            FROM Exam e
            """)
    List<GetExam> getAllExamDetails();

    @Query("""
            SELECT new com.techmaa.onlineexamsystem.student.dto.AvailableExam(
                e.id,
                 e.examName,
                 e.examDuration,
                 e.totalMarks,
                 e.totalQuestions
            )
            FROM Exam e
            WHERE e.status = 'ACTIVE'
            """)
    List<AvailableExam> getActiveExamDetails();

    

}
