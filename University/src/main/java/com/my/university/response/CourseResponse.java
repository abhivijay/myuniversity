package com.my.university.response;


public class CourseResponse {

    private Integer id;
    private String departmentName;

    private Integer instructorId;

    private Integer duration;

    private String name;
    public CourseResponse(){

    }
    public CourseResponse(Integer id, String departmentName, Integer instructorId, Integer duration, String name) {
        this.id = id;
        this.departmentName = departmentName;
        this.instructorId = instructorId;
        this.duration = duration;
        this.name = name;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", instructorId=" + instructorId +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }
}
