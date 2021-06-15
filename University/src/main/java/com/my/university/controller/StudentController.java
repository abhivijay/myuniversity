package com.my.university.controller;

import com.my.university.dto.Message;
import com.my.university.dto.StudentCourse;
import com.my.university.dto.StudentDTO;
import com.my.university.entity.Student;
import com.my.university.execption.UniversityException;
import com.my.university.response.StudentResponse;
import com.my.university.service.StudentCourseService;
import com.my.university.service.StudentService;
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
@RequestMapping(value = "/api/v1/student", produces = "application/json")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentCourseService studentCourseService;

    @Autowired
    ResponseConverter responseConverter;

    @ApiOperation(value = "", notes = "This API is used to create new student in system", response = Message.class)
    @PostMapping("/register")
    public ResponseEntity<Object> addStudent(@RequestBody StudentDTO studentDTO) {
        try {
            Integer id = studentService.addStudent(studentDTO);
            String message = Constants.studentRegSuccessMessage + id;
            return responseConverter.getSuccessResponse(message);

        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to update existing student data", response = Message.class)
    @PutMapping("/change-details")
    public ResponseEntity<Object> updateDetails(@RequestBody StudentDTO studentDTO) {
        try {
            if (ObjectUtils.isEmpty(studentDTO.getId())) {
                throw new UniversityException(Constants.studentIdRequired);
            }
            studentService.updateStudent(studentDTO);
            return responseConverter.getSuccessResponse(Constants.updateSuccessMessage);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to delete student record", response = Message.class)
    @DeleteMapping("/de-register/{studentId}")
    public ResponseEntity<Object> deleteDetails(@PathVariable Integer studentId) {
        try {
            studentService.deleteStudent(studentId);

            return new ResponseEntity<>(Constants.deleteSuccessMessage, HttpStatus.CREATED);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used fetch student detail", response = StudentResponse.class)
    @GetMapping("/details/{studentId}")
    public ResponseEntity<Object> getStudentDetailById(@PathVariable Integer studentId) {
        try {
            Student student = studentService.getStudent(studentId);
            StudentResponse studentResponse = new StudentResponse();
            BeanUtils.copyProperties(student, studentResponse);

            return responseConverter.getSuccessResponse(studentResponse);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to fetch all student detail", responseContainer = "List", response = StudentResponse.class)
    @GetMapping("/details/all")
    public ResponseEntity<Object> getAllStudentDetail() {
        try {
            List<Student> studentList = studentService.getAllStudent();
            if (!studentList.isEmpty()) {
                List<StudentResponse> _studentList = new ArrayList<>();
                for (Student student : studentList) {
                    StudentResponse studentResponse = new StudentResponse();
                    BeanUtils.copyProperties(student, studentResponse);
                    _studentList.add(studentResponse);
                }
                return responseConverter.getSuccessResponse(_studentList);
            } else {
                return new ResponseEntity<>(Constants.notFoundErrorMessage, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to en roll student in given course", response = Message.class)
    @PostMapping("/enroll/course")
    public ResponseEntity<Object> enrollCourse(@RequestBody StudentCourse studentCourse) {
        try {
            studentCourseService.enrollStudentInCourse(studentCourse.getStudentId(), studentCourse.getCourseId());

            return responseConverter.getSuccessResponse(Constants.enrollSuccess);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to de-enroll student from existing course", response = Message.class)
    @DeleteMapping("/de-enroll/course")
    public ResponseEntity<Object> deEnrollCourse(@RequestBody StudentCourse studentCourse) {
        try {
            studentCourseService.deEnrollStudentInCourse(studentCourse.getStudentId(), studentCourse.getCourseId());

            return responseConverter.getSuccessResponse(Constants.enrollSuccess);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
}
