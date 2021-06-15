package com.my.university.dao;

import com.my.university.entity.Course;
import com.my.university.entity.Student;
import com.my.university.execption.UniversityException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UniversityDaoTest extends UniversityAppTestConfig {

    @Autowired
    UniversityDAO universityDAO;

    @Test
    public void shouldFindCourseDetailForStudent() throws Exception {
        List<Course> courseList = universityDAO.getStudentCourseList(1);
        Assert.assertNotNull(courseList);
    }

    @Test
    public void shouldFindStudentDetailByInstructorId() throws Exception {
        List<Student> studentList = universityDAO.getStudentListForInstructor(3);
        Assert.assertNotNull(studentList);
        Assert.assertEquals(2, studentList.size());
    }

    @Test
    public void shouldValidateCourseDuration() throws Exception {
        Integer duration = universityDAO.getCourseDuration(1);
        Assert.assertEquals(12, duration.longValue());
    }

    @Test(expected = UniversityException.class)
    public void shouldThrowErrorForInvalidStudent() throws Exception {
        universityDAO.getStudentCourseList(0);

    }

}
