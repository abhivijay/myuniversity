package com.my.university.entity;

import javax.persistence.*;

@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="instructor_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "name")
    private Department department;

    @Column(name="HeadedBy")
    private String headedBy;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="Phone")
    private String phone;
    public Instructor(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getHeadedBy() {
        return headedBy;
    }

    public void setHeadedBy(String headedBy) {
        this.headedBy = headedBy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", departmentName='" + department + '\'' +
                ", headedBy='" + headedBy + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
