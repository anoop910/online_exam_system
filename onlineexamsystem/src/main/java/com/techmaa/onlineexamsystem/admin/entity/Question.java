package com.techmaa.onlineexamsystem.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techmaa.onlineexamsystem.admin.emum.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    @Enumerated(EnumType.STRING)
    private Option correctOption;
    private Integer marks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Exam exam;
}
