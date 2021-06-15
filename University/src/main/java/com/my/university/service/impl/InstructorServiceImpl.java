package com.my.university.service.impl;

import com.my.university.dto.InstructorDTO;
import com.my.university.entity.Department;
import com.my.university.entity.Instructor;
import com.my.university.execption.UniversityException;
import com.my.university.repository.DepartmentRepository;
import com.my.university.repository.InstructorRepository;
import com.my.university.service.InstructorService;
import com.my.university.utill.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    /**
     * This method used to create new instructor entity in system.
     * @param instructorDTO
     * @return Integer Id of newly created entity
     * @throws UniversityException if enable to create instructor
     */
    @Override
    public Integer addInstructor(InstructorDTO instructorDTO) throws UniversityException{
        Instructor instructor=new Instructor();
        BeanUtils.copyProperties(instructorDTO,instructor);
        Optional<Department> existingDepartment=departmentRepository.findById(instructorDTO.getDepartmentName());
        if(!existingDepartment.isPresent()){
            throw new UniversityException(Constants.departmentNotFound);
        }
        instructor.setDepartment(existingDepartment.get());
        instructor=instructorRepository.save(instructor);
        return instructor.getId();
    }

    /**
     * Update existing instructor entity in system
     * @param instructorDTO
     * @throws UniversityException if no entity found for given id
     */
    @Override
    public void updateInstructor(InstructorDTO instructorDTO) throws UniversityException{

        Optional<Instructor> existingInstructor=instructorRepository.findById(instructorDTO.getId());
        if(existingInstructor.isPresent()){
            Instructor instructor=existingInstructor.get();
            BeanUtils.copyProperties(instructorDTO,instructor);
            Optional<Department> existingDepartment=departmentRepository.findById(instructorDTO.getDepartmentName());
            if(!existingDepartment.isPresent()){
                throw new UniversityException(Constants.departmentNotFound);
            }
            instructor.setDepartment(existingDepartment.get());
            instructorRepository.save(instructor);
        }else{
            throw new UniversityException(Constants.noRecordFoundError);
        }
    }

    /**
     * Delete instructor entity
     * @param instructorId
     * @throws UniversityException if no instructor entity found in system
     */
    @Override
    public void deleteInstructor(Integer instructorId) throws UniversityException {
        Optional<Instructor> existingInstructor=instructorRepository.findById(instructorId);
        if(existingInstructor.isPresent()){
            instructorRepository.deleteById(instructorId);
        }else{
            throw new UniversityException(Constants.noRecordFoundError);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    /**
     * Fetch instructor entity based on instructor id
     * @param instructorId
     * @return Instructor Object
     * @throws UniversityException if not found any entity
     */
    @Override
    public Instructor getInstructor(Integer instructorId) throws UniversityException {
        Optional<Instructor> existingInstructor=instructorRepository.findById(instructorId);
        if(existingInstructor.isPresent()){
            return existingInstructor.get();
        }else{
            throw new UniversityException(Constants.noRecordFoundError);
        }

    }
}
