package com.my.university.service;


import com.my.university.dto.StudentDTO;
import com.my.university.entity.Student;
import com.my.university.execption.UniversityException;

import java.util.List;

public interface StudentService {
    Integer addStudent(StudentDTO studentDTO);

    void updateStudent(StudentDTO studentDTO) throws UniversityException;

    void deleteStudent(Integer studentId) throws UniversityException;

    List<Student> getAllStudent();

    Student getStudent(Integer studentId) throws UniversityException;
}
