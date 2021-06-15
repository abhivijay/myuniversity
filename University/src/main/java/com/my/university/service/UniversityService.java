package com.my.university.service;

import com.my.university.entity.Course;
import com.my.university.entity.Student;
import com.my.university.execption.UniversityException;

import java.util.List;

public interface UniversityService {
    public List<Course> getStudentCourseList(Integer studentId) throws UniversityException;
    public List<Student> getStudentListForInstructor(Integer instructorId) throws UniversityException;
    public Integer getCourseDuration(Integer studentId) throws UniversityException;
}
