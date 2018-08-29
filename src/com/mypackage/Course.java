package com.mypackage;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements java.io.Serializable {

    private Long courseId;
    private String courseName;
    
    public Course() {
    }
    
    public Course(String courseName) {
    	this.courseName = courseName;
    }
    
    
    
    

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
        return this.courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
