package com.techmaa.onlineexamsystem.admin.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techmaa.onlineexamsystem.admin.entity.Question;
import com.techmaa.onlineexamsystem.student.dto.StudentGetQuestion;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

    @Query("""
            SELECT new com.techmaa.onlineexamsystem.response.Question(
                 q.question,
                 q.optionA,
                 q.optionB,
                 q.optionC,
                 q.optionD,
                 q.correctOption,
                 q.marks
            )
            FROM Question q
            WHERE q.exam.id = :examId
            """)
    Page<com.techmaa.onlineexamsystem.response.Question> findQuestionResponseByExamId(
            @Param("examId") Long examId,
            Pageable pageable);
        @Query("""
            SELECT new  com.techmaa.onlineexamsystem.student.dto.StudentGetQuestion(
                q.id,
                 q.question,
                 q.optionA,
                 q.optionB,
                 q.optionC,
                 q.optionD,
                 q.marks
            )
            FROM Question q
            WHERE q.exam.id = :examId
            """)
    List<StudentGetQuestion> studentGetQuestionByexamId(@Param("examId") Long examId);
}



