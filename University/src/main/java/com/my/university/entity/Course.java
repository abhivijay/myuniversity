package com.my.university.entity;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="course_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Name")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @Column(name = "Duration")
    private Integer duration;

    @Column(name = "Course_name")
    private String name;

    public Course() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", departmentName='" + department + '\'' +
                ", instructorId=" + instructor +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
