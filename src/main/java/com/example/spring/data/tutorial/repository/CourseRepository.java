package com.example.spring.data.tutorial.repository;

import com.example.spring.data.tutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
