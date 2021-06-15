package com.my.university.repository;

import com.my.university.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {
}
