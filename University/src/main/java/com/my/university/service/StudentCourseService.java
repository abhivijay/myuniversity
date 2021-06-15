package com.my.university.service;

import com.my.university.execption.UniversityException;

public interface StudentCourseService {
    public void enrollStudentInCourse(Integer studentId,Integer courseId) throws UniversityException;
    public void deEnrollStudentInCourse(Integer studentId,Integer courseId) throws UniversityException;
}
