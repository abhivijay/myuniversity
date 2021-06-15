package com.my.university.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class DepartmentDTO {
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String location;

    public DepartmentDTO(){

    }
    public DepartmentDTO(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
