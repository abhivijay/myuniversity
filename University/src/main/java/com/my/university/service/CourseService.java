package com.my.university.service;

import com.my.university.dto.CourseDTO;
import com.my.university.entity.Course;
import com.my.university.execption.UniversityException;

import java.util.List;

public interface CourseService {
    public Integer addCourse(CourseDTO courseDTO);

    public void updateCourse(CourseDTO courseDTO) throws UniversityException;

    public void deleteCourse(Integer courseId) throws UniversityException;

    public List<Course> getAllCourse();

    public Course getCourse(Integer courseId) throws UniversityException;
}
