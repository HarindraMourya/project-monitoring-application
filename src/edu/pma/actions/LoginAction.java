package edu.pma.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.pma.dto.HODMailDTO;
import edu.pma.dto.InitialProjectDTO;
import edu.pma.dto.LoginDTO;
import edu.pma.dto.MailBoxDTO;
import edu.pma.helper.EmailFetcher;
import edu.pma.helper.FetchIdHelper;
import edu.pma.helper.FetchProjectHelper;
import edu.pma.helper.HODEmailFetcher;
import edu.pma.helper.LoginHelper;

public class LoginAction extends ActionSupport implements ModelDriven<LoginDTO>,SessionAware {

	String messege;
	private Map<String, Object> sessionMap=ActionContext.getContext().getSession();
	ArrayList<MailBoxDTO> mail=new ArrayList<>();
	ArrayList<HODMailDTO> hodMail=new ArrayList<>();
	List<InitialProjectDTO> project=new ArrayList<>();
	ArrayList<Integer> id=new ArrayList<>();
	
	
	public ArrayList<MailBoxDTO> getMail() {
		return mail;
	}
	public void setMail(ArrayList<MailBoxDTO> mail) {
		this.mail = mail;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	LoginDTO loginDto=new LoginDTO();
	@Override
	public LoginDTO getModel() {
		// TODO Auto-generated method stub
		return loginDto;
	}
	public LoginDTO getLoginDto() {
		return loginDto;
	}
	public void setLoginDto(LoginDTO loginDto) {
		this.loginDto = loginDto;
	}
	public String execute(){
		LoginHelper loginHelper=new LoginHelper();
		String send = "";
		if(loginHelper.login(loginDto))
		{
			String email=loginDto.getEmail();
			sessionMap.put("user",email);
			sessionMap.put("language", getLocale());
			setMessege(this.getText("login.message"));
			if(loginDto.getCategory().equals("Student"))
			{
				mail(email);
				send="student";
			}
			if(loginDto.getCategory().equals("Faculty"))
			{
				mail(email);
				send="faculty";
			}
            if(loginDto.getCategory().equals("HOD"))
			{
            	hodMail(email);
				send="hod";
			}
			
			return send;
		}
		else{
			setMessege(this.getText("login.invalid"));	
			return ERROR;
		}
	}
	public ArrayList<HODMailDTO> getHodMail() {
		return hodMail;
	}
	public void setHodMail(ArrayList<HODMailDTO> hodMail) {
		this.hodMail = hodMail;
	}
	public void hodMail(String email)
	{
		
		HODEmailFetcher emailFetcher=new HODEmailFetcher();
		hodMail=(ArrayList<HODMailDTO>) emailFetcher.fetchHODEmail();
		
	}
	public void mail(String email)
	{
		MailBoxDTO boxDTO=new MailBoxDTO();
		boxDTO.setRecevier(email);
		EmailFetcher emailFetcher=new EmailFetcher();
		mail=(ArrayList<MailBoxDTO>) emailFetcher.fetchEmail(boxDTO);
		FetchIdHelper fetchIdHelper=new FetchIdHelper();
		id=fetchIdHelper.fetch(email);
		int id1=id.get(0);
		System.out.println("id1="+id1);
		FetchProjectHelper fetchProjectHelper=new FetchProjectHelper();
		project=fetchProjectHelper.fetchProject(id1);
		
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
