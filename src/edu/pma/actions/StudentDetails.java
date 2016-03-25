package edu.pma.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.pma.dto.StudentDTO;
import edu.pma.helper.StudentDetailsHelper;

public class StudentDetails extends ActionSupport implements ModelDriven<StudentDTO>,SessionAware{
	 private Map<String, Object> sessionMap=ActionContext.getContext().getSession();
     StudentDTO studentDTO=new StudentDTO();
     ArrayList<StudentDTO> student =new ArrayList<>();
	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public ArrayList<StudentDTO> getStudent() {
		return student;
	}

	public void setStudent(ArrayList<StudentDTO> student) {
		this.student = student;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentDTO getModel() {
		// TODO Auto-generated method stub
		return studentDTO;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		StudentDetailsHelper detailsHelper=new StudentDetailsHelper();
		this.setStudent(detailsHelper.fetch());
		sessionMap.put("student", detailsHelper.fetch());
		return SUCCESS;
	}

	
}
