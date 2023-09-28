package com.example.spring.data.tutorial.repository;

import com.example.spring.data.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);


    // return all the students that there names contains (name string)
    public  List<Student> findByFirstNameContaining(String name);


    //returns all the students that there last name is not null
    public List<Student> findByLastNameNotNull();


    public List<Student> findByGuardianFirstName(String name);


    //JPQL query
    @Query("select s from Student s where s.emailId = ?1")
    public Student findByEmailAddressId(String email);
    //JPQL query
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String name);

    //native query                   the difference between native query and JPQL query is that native query written according to the database while JPQL written according to the classes

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    public int updateFirstNameByEmailAddress(String firstName, String emailId);
}
