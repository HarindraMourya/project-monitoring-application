package edu.pma.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.pma.dto.FacultyDTO;
import edu.pma.helper.EncryptPassword;
import edu.pma.helper.FacultyRegistrationHelper;

public class FacultyRegistartionAction extends ActionSupport implements ModelDriven<FacultyDTO>{

	FacultyDTO facultyDTO=new FacultyDTO();
	String facultyMessege;
	
	public FacultyDTO getFacultyDTO() {
		return facultyDTO;
	}

	public void setFacultyDTO(FacultyDTO facultyDTO) {
		this.facultyDTO = facultyDTO;
	}

	
	public String getFacultyMessege() {
		return facultyMessege;
	}

	public void setFacultyMessege(String facultyMessege) {
		this.facultyMessege = facultyMessege;
	}

	@Override
	public FacultyDTO getModel() {
		// TODO Auto-generated method stub
		return facultyDTO;
	}
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		FacultyRegistrationHelper facultyRegistrationHelper=new FacultyRegistrationHelper();
		EncryptPassword en=new EncryptPassword();
		facultyDTO.setStatus("Y");
		facultyDTO.setPassword(en.encryptPassword(facultyDTO.getPassword()));
		if(facultyRegistrationHelper.isRegister(facultyDTO))
		{
			this.setFacultyMessege(getText("faculty.added"));
			return SUCCESS;
		}else{
			this.setFacultyMessege(getText("faculty.readd"));
			return ERROR;
		}
		
	}

}
