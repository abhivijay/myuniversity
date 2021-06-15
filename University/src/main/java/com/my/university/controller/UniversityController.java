package com.my.university.controller;

import com.google.common.collect.ImmutableMap;
import com.my.university.entity.Course;
import com.my.university.entity.Student;
import com.my.university.execption.UniversityException;
import com.my.university.response.CourseResponse;
import com.my.university.response.StudentResponse;
import com.my.university.service.UniversityService;
import com.my.university.utill.Constants;
import com.my.university.utill.ResponseConverter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/university-detail",produces = "application/json")
public class UniversityController {

    @Autowired
    UniversityService universityService;
    @Autowired
    ResponseConverter responseConverter;

    @ApiOperation(value = "", notes = "This API is used fetch all course associated with particular user",response = Course.class,responseContainer = "List"
    )
    @GetMapping("/courses/{studentId}")
    public ResponseEntity<Object> getCourses(@PathVariable Integer studentId) {
        try {
            List<Course> courseList= universityService.getStudentCourseList(studentId);
            List<CourseResponse> _courseList=new ArrayList<>();
            for(Course course:courseList){
                CourseResponse courseResponse=new CourseResponse();
                BeanUtils.copyProperties(course,courseResponse);
                courseResponse.setDepartmentName(course.getDepartment().getName());
                courseResponse.setInstructorId(course.getInstructor().getId());
                _courseList.add(courseResponse);
            }
            return responseConverter.getSuccessResponse(_courseList);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
    @ApiOperation(value = "", notes = "This API is used to fetch all student of particular instructor",response = StudentResponse.class,responseContainer = "List")
    @GetMapping("/students/{instructorId}")
    public ResponseEntity<Object> getStudents(@PathVariable Integer instructorId) {
        try {
            List<Student> studentList= universityService.getStudentListForInstructor(instructorId);
            List<StudentResponse> _studentList=new ArrayList<>();
            for(Student student:studentList){
                StudentResponse studentResponse=new StudentResponse();
                BeanUtils.copyProperties(student,studentResponse);
                _studentList.add(studentResponse);
            }
            return responseConverter.getSuccessResponse(_studentList);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
    @ApiOperation(value = "", notes = "This API is used to fetch total course duration for student ",response = Integer.class)
    @GetMapping("/course-duration/{studentId}")
    public ResponseEntity<Object> getDuration(@PathVariable Integer studentId) {
        try {
            Integer totalDuration= universityService.getCourseDuration(studentId);

            return responseConverter.getSuccessResponse(ImmutableMap.of("totalDuration",totalDuration));

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
}
