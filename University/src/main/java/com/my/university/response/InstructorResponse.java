package com.my.university.response;

public class InstructorResponse {

    private Integer id;

    private String departmentName;

    private String headedBy;

    private String firstName;

    private String lastName;

    private String phone;
    public InstructorResponse(){

    }
    public InstructorResponse(Integer id, String departmentName, String headedBy, String firstName, String lastName, String phone) {
        this.id = id;
        this.departmentName = departmentName;
        this.headedBy = headedBy;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", headedBy='" + headedBy + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
