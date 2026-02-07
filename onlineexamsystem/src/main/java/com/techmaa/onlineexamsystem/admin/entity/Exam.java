package com.techmaa.onlineexamsystem.admin.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.techmaa.onlineexamsystem.admin.emum.ExamStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String examName;
    private Integer examDuration;
    private Integer totalQuestions;
    private Integer totalMarks;
    @Enumerated(EnumType.STRING)
    private ExamStatus status;

     @OneToMany(
            mappedBy = "exam",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Question> questions;

     
}
