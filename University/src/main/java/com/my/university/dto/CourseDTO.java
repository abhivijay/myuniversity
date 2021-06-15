package com.my.university.dto;

import io.swagger.annotations.ApiModelProperty;

public class CourseDTO {

    @ApiModelProperty(notes = "Required only in case of update")
    private Integer id;

    @ApiModelProperty(required = true)
    private String departmentName;
    @ApiModelProperty(required = true)
    private Integer instructorId;
    @ApiModelProperty(required = true)
    private Integer duration;
    @ApiModelProperty(required = true)
    private String name;

    public CourseDTO() {

    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", instructorId=" + instructorId +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }
}
