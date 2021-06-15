package com.my.university.service.impl;

import com.my.university.dto.StudentDTO;
import com.my.university.entity.Student;
import com.my.university.execption.UniversityException;
import com.my.university.repository.StudentRepository;
import com.my.university.service.StudentService;
import com.my.university.utill.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    /**
     * create new student entity in system
     * @param studentDTO
     * @return Integer student id
     */
    @Override
    public Integer addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        student = studentRepository.save(student);
        return student.getId();
    }

    /**
     * update existing entity detail
     * @param studentDTO object
     * @throws UniversityException if no existing entity found
     */
    @Override
    public void updateStudent(StudentDTO studentDTO) throws UniversityException {
        Optional<Student> existingStudent = studentRepository.findById(studentDTO.getId());
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            BeanUtils.copyProperties(studentDTO, student);
            studentRepository.save(student);
        }else{
            throw new UniversityException(Constants.noRecordFoundError);
        }

    }

    /**
     * delete entity based on id
     * @param studentId
     * @throws UniversityException if no entity found
     */
    @Override
    public void deleteStudent(Integer studentId) throws UniversityException{
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            studentRepository.deleteById(studentId);
        }
        else{
            throw new UniversityException(Constants.noRecordFoundError);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    /**
     * Fetch entity detail based on id
     * @param studentId
     * @return Student object
     * @throws UniversityException if no entity found
     */
    @Override
    public Student getStudent(Integer studentId) throws UniversityException{
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            return existingStudent.get();
        }
        else{
            throw new UniversityException(Constants.noRecordFoundError);
        }

    }
}
