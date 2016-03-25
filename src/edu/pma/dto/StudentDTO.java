package edu.pma.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Harinder Mourya
 *
 */
@Entity
@Table(name="studentdetail")
public class StudentDTO {

	@Id
	@Column(name="emailId")
	String email;
	@Column(name="name")
	String name;
	@Column(name="Class")
	String clas;
	@Column(name="enrollementNo")
	String enrollment;
	@Column(name="password")
	String password;
	@Column(name="course")
	String course;
	@Column(name="contactNo")
	String contactNo;
	@Column(name="projectId")
	String projectId;
	
	 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClas() {
		return clas;
	}
	public void setClas() {
		this.clas = clas;
		
	}
	public String getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse() {
		this.course = course;
		
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
