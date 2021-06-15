package com.my.university.dao;

import com.my.university.entity.Course;
import com.my.university.entity.Student;
import com.my.university.execption.UniversityException;
import com.my.university.repository.CourseRepository;
import com.my.university.repository.StudentRepository;
import com.my.university.utill.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UniversityDAOImpl implements UniversityDAO {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Fetch list of course which associated with particular student
     * @param studentId
     * @return List<>Course</>
     * @throws UniversityException if no course mapping found
     */
    @Override
    public List<Course> getStudentCourseList(Integer studentId) throws UniversityException {

        List<Course> courseList = (List<Course>) entityManager.createQuery(studentCourseQuery).setParameter(1, studentId).getResultList();
        if (courseList.isEmpty()) {
            throw new UniversityException(Constants.notEnrollForAnyCourse);
        }
        return courseList;
    }

    /**
     * This method use to find list of student who enroll in particular instructor course
     * @param instructorId
     * @return List Student
     * @throws UniversityException if no mapping found
     */
    @Override
    public List<Student> getStudentListForInstructor(Integer instructorId) throws UniversityException {
        List<Student> studentList = (List<Student>) entityManager.createQuery(studentInstructorQuery).setParameter(1, instructorId).getResultList();
        if (studentList.isEmpty()) {
            throw new UniversityException(Constants.noStudentFound);
        }
        return studentList;
    }

    /**
     * Get the total duration of course of a student
     * @param studentId
     * @return Integer Object
     * @throws UniversityException if no mapping found
     */
    @Override
    public Integer getCourseDuration(Integer studentId) throws UniversityException {
        List<Course> courseList = (List<Course>) entityManager.createQuery(studentCourseQuery).setParameter(1, studentId).getResultList();
        if (courseList.isEmpty()) {
            throw new UniversityException(Constants.notEnrollForAnyCourse);
        }
        Integer totalDuration = courseList.stream().mapToInt(x -> x.getDuration()).sum();
        return totalDuration;
    }
}
