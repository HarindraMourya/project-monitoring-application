package edu.pma.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facultydetail")
public class FacultyDTO {

	@Id
	@Column(name="name")
	String name;
	
	@Column(name="position")
	String position;
	
	@Column(name="department")
	String department;
	
	@Column(name="domainAreas")
	String domainarea;
	
	@Column(name="emailId")
	String email;
	
	@Column(name="password")
	String password;
	
	@Column(name="contactno")
	String contactno;
	
	@Column(name="status")
	String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDomainarea() {
		return domainarea;
	}

	public void setDomainarea(String domainarea) {
		this.domainarea = domainarea;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	
	
	
	
}
