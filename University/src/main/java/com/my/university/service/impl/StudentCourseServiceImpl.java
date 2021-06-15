package com.my.university.service.impl;

import com.my.university.entity.Course;
import com.my.university.entity.Student;
import com.my.university.entity.StudentCourse;
import com.my.university.entity.StudentCourseKey;
import com.my.university.execption.UniversityException;
import com.my.university.repository.CourseRepository;
import com.my.university.repository.StudentCourseRepository;
import com.my.university.repository.StudentRepository;
import com.my.university.service.StudentCourseService;
import com.my.university.utill.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentCourseRepository studentCourseRepository;

    /**
     * Create and mapping of student with course
     * @param studentId
     * @param courseId
     * @throws UniversityException if invalid value for course and student
     */
    @Override
    public void enrollStudentInCourse(Integer studentId, Integer courseId) throws UniversityException {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (!existingStudent.isPresent()) {
            throw new UniversityException(Constants.studentNotFound);
        }
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if (!existingCourse.isPresent()) {
            throw new UniversityException(Constants.courseNotFound);
        }
        StudentCourseKey studentCourseKey = new StudentCourseKey(existingCourse.get(), existingStudent.get());
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setId(studentCourseKey);
        studentCourseRepository.save(studentCourse);
    }

    /**
     * remove mapping of student and course
     * @param studentId
     * @param courseId
     * @throws UniversityException if no existing mapping found
     */
    @Override
    public void deEnrollStudentInCourse(Integer studentId, Integer courseId) throws UniversityException {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (!existingStudent.isPresent()) {
            throw new UniversityException(Constants.studentNotFound);
        }
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if (!existingCourse.isPresent()) {
            throw new UniversityException(Constants.courseNotFound);
        }
        StudentCourseKey studentCourseKey = new StudentCourseKey(existingCourse.get(), existingStudent.get());
        Optional<StudentCourse> studentCourse = studentCourseRepository.findById(studentCourseKey);
        if (studentCourse.isPresent()) {
            studentCourseRepository.deleteById(studentCourseKey);
        } else {
            throw new UniversityException(Constants.notEnroll);
        }
    }
}
