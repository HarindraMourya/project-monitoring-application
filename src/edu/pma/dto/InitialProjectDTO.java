package edu.pma.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="initialprojectdetail")
public class InitialProjectDTO {

	@Id
	@Column(name="projectId")
	//@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="studentprojects",joinColumns=@JoinColumn(name="projectId"))
	int projectId;
	
	@Column(name="name")
	String name;
	
	@Column(name="description")
	String description;
	
	@Column(name="technology")
	String technology;
	
	@Column(name="guide")
	String guide;
	
	@Column(name="duration")
	int duration;
	
	@Column(name="status")
	String status;
	@Column(name="report")
	String report;
    
	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
