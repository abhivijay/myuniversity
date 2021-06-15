package com.my.university.service;

import com.my.university.dto.DepartmentDTO;
import com.my.university.entity.Department;
import com.my.university.execption.UniversityException;

import java.util.List;

public interface DepartmentService {
    void addDepartment(DepartmentDTO departmentDTO);

    void updateDepartment(DepartmentDTO departmentDTO) throws UniversityException;

    void deleteDepartment(String departmentName) throws UniversityException;

    List<Department> getAllDepartment();

    Department getDepartment(String departmentName) throws UniversityException;
}
