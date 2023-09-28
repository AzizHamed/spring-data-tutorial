package com.example.spring.data.tutorial.repository;

import com.example.spring.data.tutorial.entity.Course;
import com.example.spring.data.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherTest(){
        Course courseAlgo = Course.builder().credit(5).title("algo").build();
        Course courseJava = Course.builder().credit(6).title("Java").build();
        Teacher teacher = Teacher.builder().firstName("Yazeed").lastName("hamed").coursesList(List.of(courseAlgo,courseJava)).build();
        teacherRepository.save(teacher);
    }

}