package com.my.university.entity;

import javax.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourse {
    @EmbeddedId
    private StudentCourseKey id;

    public StudentCourseKey getId() {
        return id;
    }

    public void setId(StudentCourseKey id) {
        this.id = id;
    }
}
