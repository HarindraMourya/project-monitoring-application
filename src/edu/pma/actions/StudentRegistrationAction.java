package edu.pma.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.pma.dto.StudentDTO;

public class StudentRegistrationAction extends ActionSupport implements ModelDriven<StudentDTO>{
	StudentDTO studentDTO=new StudentDTO();
	String messege;
	String course;
	String clas;
	public List courseList=new ArrayList();
	public List clasList=new ArrayList();
	
	
	public String getClas() {
		return clas;
	}
	private void setClas(List clasList) {
		//this.clas = clas;
		clasList.add("CSE");
		clasList.add("IT");
		clasList.add("EEE");
		clasList.add("ECE");
	}
	private String getCourse() {
		return course;
	}
	public void setCourse(List courseList ) {
		//this.course = course;
		courseList.add("B.Tech");
		courseList.add("M.Tech");
		courseList.add("MBA");
		courseList.add("BCA");
	}
	public List getCourseList() {
		return courseList;
	}
	public void setCourseList(List courseList) {
		this.courseList = courseList;
	}
	public List getClasList() {
		return clasList;
	}
	public void setClasList(List clasList) {
		this.clasList = clasList;
	}
	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		this.setCourse(courseList);
	    this.setClas(clasList);
		return SUCCESS;
	}

	@Override
	public StudentDTO getModel() {
		// TODO Auto-generated method stub
		return studentDTO;
	}

}
