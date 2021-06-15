package com.my.university.repository;

import com.my.university.entity.StudentCourse;
import com.my.university.entity.StudentCourseKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseKey> {
}
