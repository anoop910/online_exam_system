package com.techmaa.onlineexamsystem.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techmaa.onlineexamsystem.student.entity.CompletedTest;

@Repository
public interface CompletedTestRepo extends JpaRepository<CompletedTest, Long>{
    
}
