package com.my.university.service;

import com.my.university.dto.InstructorDTO;
import com.my.university.entity.Instructor;
import com.my.university.execption.UniversityException;

import java.util.List;

public interface InstructorService {
    Integer addInstructor(InstructorDTO instructorDTO);

    void updateInstructor(InstructorDTO instructorDTO) throws UniversityException;

    void deleteInstructor(Integer instructorId) throws UniversityException;

    List<Instructor> getAllInstructor();

    Instructor getInstructor(Integer instructorId) throws UniversityException;
}
