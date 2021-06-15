package com.my.university.service.impl;

import com.my.university.dao.UniversityDAO;
import com.my.university.entity.Course;
import com.my.university.entity.Student;
import com.my.university.execption.UniversityException;
import com.my.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    UniversityDAO universityDAO;

    /**
     *
     * @param studentId
     * @return
     * @throws UniversityException
     */
    @Override
    public List<Course> getStudentCourseList(Integer studentId) throws UniversityException {
        return universityDAO.getStudentCourseList(studentId);
    }

    /**
     *
     * @param instructorId
     * @return
     * @throws UniversityException
     */
    @Override
    public List<Student> getStudentListForInstructor(Integer instructorId) throws UniversityException {
        return universityDAO.getStudentListForInstructor(instructorId);
    }

    /**
     *
     * @param studentId
     * @return
     * @throws UniversityException
     */
    @Override
    public Integer getCourseDuration(Integer studentId) throws UniversityException {
        return universityDAO.getCourseDuration(studentId);
    }
}
