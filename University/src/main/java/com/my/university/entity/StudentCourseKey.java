package com.my.university.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class StudentCourseKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "course=" + course +
                ", student=" + student +
                '}';
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public StudentCourseKey(){

    }
    public StudentCourseKey(Course course, Student student) {
        this.course = course;
        this.student = student;
    }
}
