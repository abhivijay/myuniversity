package com.my.university.service.impl;

import com.my.university.dto.CourseDTO;
import com.my.university.entity.Course;
import com.my.university.entity.Department;
import com.my.university.entity.Instructor;
import com.my.university.execption.UniversityException;
import com.my.university.repository.CourseRepository;
import com.my.university.repository.DepartmentRepository;
import com.my.university.repository.InstructorRepository;
import com.my.university.service.CourseService;
import com.my.university.utill.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    InstructorRepository instructorRepository;

    /**
     * Method Create a course entity in system
     * @param courseDTO
     * @return Integer : Id of newly created entity
     * @throws UniversityException
     */
    @Override
    public Integer addCourse(CourseDTO courseDTO) throws UniversityException{
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        Optional<Department> existingDepartment=departmentRepository.findById(courseDTO.getDepartmentName());
        if(!existingDepartment.isPresent()){
            throw new UniversityException(Constants.departmentNotFound);
        }
        Optional<Instructor> existingInstructor=instructorRepository.findById(courseDTO.getInstructorId());
        if(!existingInstructor.isPresent()){
            throw new UniversityException(Constants.instructorNotFound);
        }
        course.setDepartment(existingDepartment.get());
        course.setInstructor(existingInstructor.get());
        course = courseRepository.save(course);
        return course.getId();
    }

    /**
     * This method update Existing course entity
     * @param courseDTO
     * @throws UniversityException
     */
    @Override
    public void updateCourse(CourseDTO courseDTO) throws  UniversityException{
        Optional<Course> existingCourse = courseRepository.findById(courseDTO.getId());
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            BeanUtils.copyProperties(courseDTO, course);
            Optional<Department> existingDepartment=departmentRepository.findById(courseDTO.getDepartmentName());
            if(!existingDepartment.isPresent()){
                throw new UniversityException(Constants.departmentNotFound);
            }
            Optional<Instructor> existingInstructor=instructorRepository.findById(courseDTO.getInstructorId());
            if(!existingInstructor.isPresent()){
                throw new UniversityException(Constants.instructorNotFound);
            }
            course.setDepartment(existingDepartment.get());
            course.setInstructor(existingInstructor.get());
            courseRepository.save(course);
        } else {
            throw new UniversityException(Constants.noRecordFoundError);
        }

    }

    /**
     * This Method delete Existing course entry
     * @param courseId Integer
     * @throws UniversityException if course not found for given id
     */
    @Override
    public void deleteCourse(Integer courseId) throws UniversityException{
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if (existingCourse.isPresent()) {
            courseRepository.deleteById(courseId);
        } else {
            throw new UniversityException(Constants.noRecordFoundError);
        }
    }

    /**
     *This method return all course available in system.
     * @return List<Course></>
     */
    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    /**
     * Get Course detail based on course Id.
     * @param courseId Integer
     * @return Course Object
     * @throws UniversityException if no course found for given id
     */
    @Override
    public Course getCourse(Integer courseId) throws UniversityException{
        Optional<Course> existingCourse = courseRepository.findById(courseId);
        if (!existingCourse.isPresent()) {

            throw new UniversityException(Constants.noRecordFoundError);

        }
        return existingCourse.get();
    }
}
