package com.techmaa.onlineexamsystem.admin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techmaa.onlineexamsystem.admin.dto.AddQuestion;
import com.techmaa.onlineexamsystem.admin.dto.Exam;
import com.techmaa.onlineexamsystem.admin.dto.GetExam;
import com.techmaa.onlineexamsystem.admin.emum.ExamStatus;
import com.techmaa.onlineexamsystem.admin.entity.Question;
import com.techmaa.onlineexamsystem.admin.repository.ExamRepo;
import com.techmaa.onlineexamsystem.admin.repository.QuestionRepo;
import com.techmaa.onlineexamsystem.admin.service.ExamService;
import com.techmaa.onlineexamsystem.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepo examRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Boolean createExam(Exam exam) {
        com.techmaa.onlineexamsystem.admin.entity.Exam exam2 = new com.techmaa.onlineexamsystem.admin.entity.Exam();
        exam2.setExamName(exam.getExamName());
        exam2.setExamDuration(exam.getExamDuration());
        exam2.setStatus(ExamStatus.UPCOMING);
        examRepo.save(exam2);
        return true;
    }

    @Override
    @Transactional
    public Boolean addQuestion(Long examId, AddQuestion addQuestion) {
        com.techmaa.onlineexamsystem.admin.entity.Exam exam = examRepo.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with exam id :" + examId));

        
        Question question = new Question();
        question.setExam(exam);
        question.setQuestion(addQuestion.getQuestion());
        question.setOptionA(addQuestion.getOptionA());
        question.setOptionB(addQuestion.getOptionB());
        question.setOptionC(addQuestion.getOptionC());
        question.setOptionD(addQuestion.getOptionD());
        question.setCorrectOption(addQuestion.getCorrectOption());
        question.setMarks(addQuestion.getMarks());
        Integer totalMark = exam.getTotalMarks() == null ? 0 : exam.getTotalMarks();
        Integer totalQuestions = exam.getTotalQuestions() == null ? 0 : exam.getTotalQuestions();
        totalQuestions += 1;
        

        totalMark += addQuestion.getMarks();
        exam.setTotalMarks(totalMark);
        exam.setTotalQuestions(totalQuestions);
        examRepo.save(exam);
        questionRepo.save(question);
        return true;

    }

    @Override
    public List<GetExam> getAllExam() {
        return examRepo.getAllExamDetails();
    }

    @Override
    public List<com.techmaa.onlineexamsystem.response.Question> getQuestionsByExamId(Long examId) {
        Pageable pageable = PageRequest.of(0, 5);

        return questionRepo.findQuestionResponseByExamId(examId, pageable).getContent();
    }

    @Override
     public ExamStatus updateStatus(Long id, String status) {

    com.techmaa.onlineexamsystem.admin.entity.Exam    exam = examRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam Not Found"));

    ExamStatus newStatus = ExamStatus.valueOf(status.toUpperCase());

    exam.setStatus(newStatus); // ✅ works now

    examRepo.save(exam);

    return newStatus;
}


}
