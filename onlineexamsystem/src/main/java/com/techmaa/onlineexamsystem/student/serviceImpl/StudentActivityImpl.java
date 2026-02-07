package com.techmaa.onlineexamsystem.student.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmaa.onlineexamsystem.admin.emum.Option;
import com.techmaa.onlineexamsystem.admin.entity.Question;
import com.techmaa.onlineexamsystem.admin.repository.ExamRepo;
import com.techmaa.onlineexamsystem.admin.repository.QuestionRepo;
import com.techmaa.onlineexamsystem.student.dto.AnswerDTO;
import com.techmaa.onlineexamsystem.student.dto.AvailableExam;
import com.techmaa.onlineexamsystem.student.dto.ExamSubmitRequest;
import com.techmaa.onlineexamsystem.student.dto.StudentGetQuestion;
import com.techmaa.onlineexamsystem.student.entity.CompletedTest;
import com.techmaa.onlineexamsystem.student.repository.CompletedTestRepo;
import com.techmaa.onlineexamsystem.student.service.StudentActivity;
import com.techmaa.onlineexamsystem.user.repository.UserRepo;

@Service
public class StudentActivityImpl implements StudentActivity {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ExamRepo examRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private CompletedTestRepo completedTestRepo;

    @Override
    public List<AvailableExam> getActiveExams() {
        return examRepo.getActiveExamDetails();

    }

    @Override
    public List<StudentGetQuestion> getQuestionsByExamId(Long examId) {
        return questionRepo.studentGetQuestionByexamId(examId);
    }

    @Override
    public String ExamSubmit(ExamSubmitRequest examSubmitRequest, String username) {
        Long examId = examSubmitRequest.getExamId();
        List<Integer> marksandCorrectAnswer = calculateMarksAndCorrectAnswer(examSubmitRequest);
        Integer totalMarks = marksandCorrectAnswer.get(0);
        Integer totalCorrectAnswer = marksandCorrectAnswer.get(1);
        CompletedTest completedTest = new CompletedTest();
        completedTest.setExamId(examId);
        completedTest.setTotalMarks(totalMarks);
        completedTest.setTotalCorrect(totalCorrectAnswer);
        completedTest.setUser(userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found")));
        completedTestRepo.save(completedTest);
        return "Exam Submitted Successfully";


    }

    public List<Integer> calculateMarksAndCorrectAnswer(ExamSubmitRequest request) {

    int totalMarks = 0;
    int totalCorrectAnswer = 0;

    for (AnswerDTO ans : request.getAnswers()) {

        Question q = questionRepo.findById(ans.getQuestionId())
                .orElseThrow(() -> new RuntimeException(
                        "Question not found with id: " + ans.getQuestionId()
                ));

        String selectedOption = ans.getSelectedOption();  // optionA
        Option correctOption = q.getCorrectOption();      // optionA or A

        

        // ✅ Compare properly
        if (selectedOption.equalsIgnoreCase(correctOption.name())) {
            System.out.println("✅ Correct Answer!");

            totalMarks += q.getMarks();
            totalCorrectAnswer++;
        }
    }

    return List.of(totalMarks, totalCorrectAnswer);
}


}
