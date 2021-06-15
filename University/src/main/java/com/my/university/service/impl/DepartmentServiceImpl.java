package com.my.university.service.impl;

import com.my.university.dto.DepartmentDTO;
import com.my.university.entity.Department;
import com.my.university.execption.UniversityException;
import com.my.university.repository.DepartmentRepository;
import com.my.university.service.DepartmentService;
import com.my.university.utill.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    /**
     * Add new department in system
     * @param departmentDTO Object
     */
    @Override
    public void addDepartment(DepartmentDTO departmentDTO) {
        Department department=new Department();
        BeanUtils.copyProperties(departmentDTO,department);
        departmentRepository.save(department);

    }

    /**
     * update Existing department information
     * @param departmentDTO Object
     * @throws UniversityException if no department found for update
     */
    @Override
    public void updateDepartment(DepartmentDTO departmentDTO) throws UniversityException {

        Optional<Department> existingDepartment=departmentRepository.findById(departmentDTO.getName());
        if(existingDepartment.isPresent()){
            Department department=existingDepartment.get();
            BeanUtils.copyProperties(departmentDTO,department);
            departmentRepository.save(department);

        }else{
            throw new UniversityException(Constants.noRecordFoundError);
        }
    }

    /**
     * Delete Existing department detail
     * @param departmentName String
     * @throws UniversityException if no department found
     */
    @Override
    public void deleteDepartment(String departmentName)throws UniversityException {
        Optional<Department> existingDepartment=departmentRepository.findById(departmentName);
        if(existingDepartment.isPresent()){
            departmentRepository.deleteById(departmentName);
        }else{
            throw new UniversityException(Constants.noRecordFoundError);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    /**
     * This method used to return Department detail
     * @param departmentName
     * @return Department Object
     * @throws UniversityException
     */
    @Override
    public Department getDepartment(String departmentName) throws UniversityException{
        Optional<Department> existingDepartment=departmentRepository.findById(departmentName);
        if(existingDepartment.isPresent()){
            return  existingDepartment.get();
        }else{
            throw new UniversityException(Constants.noRecordFoundError);
        }
    }
}
