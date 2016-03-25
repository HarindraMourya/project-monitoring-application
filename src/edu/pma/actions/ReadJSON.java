package edu.pma.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.pma.dto.FacultyDTO;

public class ReadJSON extends ActionSupport{
	
	 private List < FacultyDTO > data;
	    public String writeJSON() {
	        try {
	            System.out.println(data.size());
	            for (int i = 0; i < data.size(); i++) {
	                System.out.println("Data  " + data.get(i).getContactno() + "-" + data.get(i).getDepartment() + "-" + data.get(i).getDomainarea() + "-" + data.get(i).getName());
	            }
	            System.out.println("Execute Method");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return SUCCESS;
	    }
		public List<FacultyDTO> getData() {
			return data;
		}
		public void setData(List<FacultyDTO> data) {
			this.data = data;
		}
	   
	

}
