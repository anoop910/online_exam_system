package com.techmaa.onlineexamsystem.response;


import com.techmaa.onlineexamsystem.admin.emum.Option;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {

    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private Option correctOption;
    private Integer marks;
}
