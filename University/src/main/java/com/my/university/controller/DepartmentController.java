package com.my.university.controller;

import com.my.university.dto.DepartmentDTO;
import com.my.university.dto.Message;
import com.my.university.entity.Department;
import com.my.university.execption.UniversityException;
import com.my.university.response.DepartmentResponse;
import com.my.university.service.DepartmentService;
import com.my.university.utill.Constants;
import com.my.university.utill.ResponseConverter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/department", produces = "application/json")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @Autowired
    ResponseConverter responseConverter;

    @ApiOperation(value = "", notes = "This API is used to create new department", response = Message.class)
    @PostMapping("/register")
    public ResponseEntity<Object> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        try {
            departmentService.addDepartment(departmentDTO);

            return responseConverter.getSuccessResponse(Constants.departmentRegSuccessMessage);

        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to update existing department", response = Message.class)
    @PutMapping("/change-details")
    public ResponseEntity<Object> updateDetails(@RequestBody DepartmentDTO departmentDTO) {
        try {
            departmentService.updateDepartment(departmentDTO);
            return responseConverter.getSuccessResponse(Constants.departmentUpdateSuccessMessage);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used to delete existing department ", response = Message.class)
    @DeleteMapping("/de-register/{departmentName}")
    public ResponseEntity<Object> deleteDetails(@PathVariable String departmentName) {
        try {
            departmentService.deleteDepartment(departmentName);

            return responseConverter.getSuccessResponse(Constants.departmentDeleteSuccessMessage);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used fetch department detail", response = DepartmentResponse.class)
    @GetMapping("/details/{departmentName}")
    public ResponseEntity<Object> getDepartmentDetail(@PathVariable String departmentName) {
        try {
            Department department = departmentService.getDepartment(departmentName);
            DepartmentResponse departmentResponse = new DepartmentResponse();
            BeanUtils.copyProperties(department, departmentResponse);

            return responseConverter.getSuccessResponse(departmentResponse);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }

    @ApiOperation(value = "", notes = "This API is used fetch all department details", responseContainer = "List", response = DepartmentResponse.class)
    @GetMapping("/details/all")
    public ResponseEntity<Object> getAllDepartment() {
        try {
            List<Department> departmentList = departmentService.getAllDepartment();
            if (!departmentList.isEmpty()) {
                List<DepartmentResponse> _departmentList = new ArrayList<>();
                for (Department department : departmentList) {
                    DepartmentResponse departmentResponse = new DepartmentResponse();
                    BeanUtils.copyProperties(department, departmentResponse);
                    _departmentList.add(departmentResponse);
                }
                return responseConverter.getSuccessResponse(_departmentList);
            } else {
                return responseConverter.getBadRequestMessage(Constants.notFoundErrorMessage);
            }

        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
}
