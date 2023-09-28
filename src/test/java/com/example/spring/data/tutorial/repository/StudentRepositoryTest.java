package com.example.spring.data.tutorial.repository;

import com.example.spring.data.tutorial.entity.Guardian;
import com.example.spring.data.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder().firstName("Aziz").lastName("hamed").emailId("Azizhamed55555@gmail.com")
                //.guardianEmail("Ehabhame222@gmail.com")
                //  .guardianFirstName("Ehab")
               //  .guardianLastName("hamed")
                .build();
        studentRepository.save(student);

    }


    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = new Guardian("Mosh", "mosh", "Mosh@gmail.com");

        Student student = Student.builder().firstName("Aziz").lastName("hamed").emailId("azizhamed55555555@gamil.com").guardian(guardian).build();

        studentRepository.save(student);
    }

    @Test
    public void printAll(){
        List<Student> students = studentRepository.findAll();
        System.out.println("students = " + students);
    }


    @Test
    public void findStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Aziz");
        System.out.println("students = " + students);
    }

    @Test
    public void findStudentByFirstNameContainning(){
        List<Student> students = studentRepository.findByFirstNameContaining("Az");
        System.out.println("students = " + students);
    }

    @Test
    public void findStudentByLastNameNotNull(){
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("students = " + students);
    }


    @Test
    public void findStudentByGuardianFirstName(){
        List<Student> students = studentRepository.findByGuardianFirstName("Ehab");
        System.out.println("students = " + students);
    }

    @Test
    public void findByEmailAddressIdTest(){
        Student student = studentRepository.findByEmailAddressId("Azizhamed555@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentFirstNameByEmailAddressTest(){
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("Azizhamed555@gmail.com");
        System.out.println("student name = " + studentName);
    }


   /* @Test
    public void getStudentFirstNameByEmailAddressNativeTest(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("azizhamed55555555@gamil.com");
        System.out.println("student = " + student);
    }*/

    @Test
    public void updateFirstNameByEmailId(){

        studentRepository.updateFirstNameByEmailAddress("Aziz Hamed", "Azizhamed555@gmail.com");

    }





}