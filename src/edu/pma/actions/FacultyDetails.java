package edu.pma.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.pma.dto.FacultyDTO;
import edu.pma.helper.FacultyDetailsHelper;

public class FacultyDetails extends ActionSupport implements ModelDriven<FacultyDTO>,SessionAware{

	 ArrayList<FacultyDTO> faculty =new ArrayList<>();
	 private Map<String, Object> sessionMap=ActionContext.getContext().getSession();
		
	public ArrayList<FacultyDTO> getFaculty() {
		return faculty;
	}
	public void setFaculty(ArrayList<FacultyDTO> faculty) {
		this.faculty = faculty;
	}

	FacultyDTO facultyDTO=new FacultyDTO();
	public FacultyDTO getFacultyDTO() {
		return facultyDTO;
	}
	public void setFacultyDTO(FacultyDTO facultyDTO) {
		this.facultyDTO = facultyDTO;
	}
	@Override
	public FacultyDTO getModel() {
		// TODO Auto-generated method stub
		return facultyDTO;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello ");
		FacultyDetailsHelper facultyDetailsHelper=new FacultyDetailsHelper();
		this.setFaculty(facultyDetailsHelper.fetch());
		sessionMap.put("faculty", facultyDetailsHelper.fetch());
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
