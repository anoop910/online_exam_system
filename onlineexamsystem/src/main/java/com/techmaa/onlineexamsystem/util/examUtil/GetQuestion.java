package com.techmaa.onlineexamsystem.util.examUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.techmaa.onlineexamsystem.admin.repository.QuestionRepo;
import com.techmaa.onlineexamsystem.response.Question;

@Component
public class GetQuestion {


    @Autowired
    private QuestionRepo questionRepo;

    public List<Question> getQuestionByExamId(Long id) {
        Pageable pageable = PageRequest.of(0, 5);
         questionRepo.findQuestionResponseByExamId(id, pageable);
        return questionRepo.findQuestionResponseByExamId(id, pageable).getContent();
    }

}
