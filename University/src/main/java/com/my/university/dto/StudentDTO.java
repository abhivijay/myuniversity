package com.my.university.dto;


import io.swagger.annotations.ApiModelProperty;

public class StudentDTO {
    @ApiModelProperty(notes = "Required only in case of update")
    private Integer id;

    @ApiModelProperty(required = true)
    private String firstName;
    @ApiModelProperty(required = true)
    private String lastName;
    @ApiModelProperty(required = true)
    private String phone;

    public StudentDTO() {

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
        return "StudentDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
