package com.my.university.dto;

import io.swagger.annotations.ApiModelProperty;

public class InstructorDTO {
    @ApiModelProperty(notes = "Required only in case of update")
    private Integer id;
    @ApiModelProperty(required = true)
    private String departmentName;
    @ApiModelProperty(required = true)
    private String headedBy;
    @ApiModelProperty(required = true)
    private String firstName;
    @ApiModelProperty(required = true)
    private String lastName;
    @ApiModelProperty(required = true)
    private String phone;

    public InstructorDTO() {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "InstructorDTO{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", headedBy='" + headedBy + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
