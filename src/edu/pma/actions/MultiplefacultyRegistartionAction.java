package edu.pma.actions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;


public class MultiplefacultyRegistartionAction extends ActionSupport {
	
	 private File myFile;
     private String contentType;
     private String filename;
     private String password;
     private String repassword;
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
 
    @Override
    public String execute() throws Exception {
    	// TODO Auto-generated method stub
    	String destPath = "H:/uploads/facultyRegistrationData.xls";

	      try{
	     	 System.out.println("Src File name: " + myFile);
	     	 //System.out.println("Dst File name: " + myFileFileName);
	     	    	 
	     	 File destFile  = new File(destPath);
	    	 FileUtils.copyFile(myFile, destFile);
	  
	      }catch(IOException e){
	         e.printStackTrace();
	         return ERROR;
	      }
    	return SUCCESS;
    }
	}
