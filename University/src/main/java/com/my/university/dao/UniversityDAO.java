package com.my.university.dao;

import com.my.university.entity.Course;
import com.my.university.entity.Student;
import com.my.university.execption.UniversityException;

import java.util.List;

public interface UniversityDAO {
     String studentCourseQuery = "Select course from StudentCourse scourse,Course course " +
            " where scourse.id.student.id=?1 and scourse.id.course.id=course.id";
     String studentInstructorQuery = "Select student from StudentCourse scourse,Course course, Student student " +
            " where course.instructor.id=?1 and  scourse.id.course.id=course.id and scourse.id.student.id=student.id";

    List<Course> getStudentCourseList(Integer studentId) throws UniversityException;

    List<Student> getStudentListForInstructor(Integer instructorId) throws UniversityException;

    Integer getCourseDuration(Integer studentId) throws UniversityException;
}
