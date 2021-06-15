package com.my.university.controller;

import com.my.university.dto.CourseDTO;
import com.my.university.dto.Message;
import com.my.university.entity.Course;
import com.my.university.execption.UniversityException;
import com.my.university.response.CourseResponse;
import com.my.university.service.CourseService;
import com.my.university.utill.Constants;
import com.my.university.utill.ResponseConverter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/course",produces = "application/json")
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    ResponseConverter responseConverter;

    @ApiOperation(value = "", notes = "This API is used to create new course", response = Message.class)
    @PostMapping("/register")
    public ResponseEntity<Object> addCourse(@RequestBody CourseDTO courseDTO) {
        try {
            Integer id = courseService.addCourse(courseDTO);
            String message = Constants.courseRegSuccessMessage + id;
            return responseConverter.getSuccessResponse(message);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to update existing course", response = Message.class)
    @PutMapping("/change-details")
    public ResponseEntity<Object> updateDetails(@RequestBody CourseDTO courseDTO) {
        try {
            if (ObjectUtils.isEmpty(courseDTO.getId())) {
                throw new UniversityException(Constants.courseIdRequired);
            }
            courseService.updateCourse(courseDTO);
            return responseConverter.getSuccessResponse(Constants.courseUpdateSuccessMessage);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to delete course", response = Message.class)
    @DeleteMapping("/de-register/{courseId}")
    public ResponseEntity<Object> deleteDetails(@PathVariable Integer courseId) {
        try {
            courseService.deleteCourse(courseId);

            return responseConverter.getSuccessResponse(Constants.courseDeleteSuccessMessage);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to fetch course data based on Id", response = CourseResponse.class)
    @GetMapping("/details/{courseId}")
    public ResponseEntity<Object> getCourseDetail(@PathVariable Integer courseId) {
        try {
            Course course = courseService.getCourse(courseId);
            CourseResponse courseResponse = new CourseResponse();
            BeanUtils.copyProperties(course, courseResponse);
            courseResponse.setInstructorId(course.getInstructor().getId());
            courseResponse.setDepartmentName(course.getDepartment().getName());
            return responseConverter.getSuccessResponse(courseResponse);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used fetch all courses list", responseContainer = "List", response = CourseResponse.class)
    @GetMapping("/details/all")
    public ResponseEntity<Object> getAllCourseDetail() {
        try {
            List<Course> courseList = courseService.getAllCourse();
            if (!courseList.isEmpty()) {
                List<CourseResponse> _courseList = new ArrayList<>();
                for (Course course : courseList) {
                    CourseResponse courseResponse = new CourseResponse();
                    BeanUtils.copyProperties(course, courseResponse);
                    courseResponse.setInstructorId(course.getInstructor().getId());
                    courseResponse.setDepartmentName(course.getDepartment().getName());
                    _courseList.add(courseResponse);
                }
                return responseConverter.getSuccessResponse(_courseList);
            } else {
                return responseConverter.getBadRequestMessage(Constants.notFoundErrorMessage);
            }

        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
}
