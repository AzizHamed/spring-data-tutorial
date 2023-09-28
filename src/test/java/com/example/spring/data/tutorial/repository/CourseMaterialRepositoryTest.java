package com.example.spring.data.tutorial.repository;

import com.example.spring.data.tutorial.entity.Course;
import com.example.spring.data.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder().credit(915).title("DSasa").build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.panet.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);



    }
    
    @Test
    public void fetchCourseMaterial(){
        List<CourseMaterial> courseMaterialList = 
                courseMaterialRepository.findAll();

        System.out.println("courseMaterialList = " + courseMaterialList);
    }

}