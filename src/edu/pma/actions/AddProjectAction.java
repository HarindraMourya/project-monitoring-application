package edu.pma.actions;

import java.util.Date;
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
import edu.pma.dto.StudentProjectDTO;
import edu.pma.helper.HODMailHelper;
import edu.pma.helper.InitialProjectHelper;
import edu.pma.helper.LoginHelper;
import edu.pma.helper.MailBoxHelper;
import edu.pma.helper.StudentProjectHelper;

public class AddProjectAction extends ActionSupport implements ModelDriven<InitialProjectDTO>,SessionAware{

	InitialProjectDTO initialProjectDTO =new InitialProjectDTO();
	MailBoxDTO mailBoxDTO=new MailBoxDTO();
	String pName;
	String pTechnology;
	String pDescription;
	int pDuration;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpTechnology() {
		return pTechnology;
	}
	public void setpTechnology(String pTechnology) {
		this.pTechnology = pTechnology;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public int getpDuration() {
		return pDuration;
	}
	public void setpDuration(int pDuration) {
		this.pDuration = pDuration;
	}
	private Map<String, Object> sessionMap=ActionContext.getContext().getSession();
	
	
	String initialProjectMsg;
	@Override
	public InitialProjectDTO getModel() {
		// TODO Auto-generated method stub
		return initialProjectDTO;
	}
	public InitialProjectDTO getInitialProjectDTO() {
		return initialProjectDTO;
	}
	public void setInitialProjectDTO(InitialProjectDTO initialProjectDTO) {
		System.out.println("Setter called");
		this.initialProjectDTO = initialProjectDTO;
	}
	public String getInitialProjectMsg() {
		System.out.println("getter called");
		return initialProjectMsg;
	}
	public void setInitialProjectMsg(String initialProjectMsg) {
		this.initialProjectMsg = initialProjectMsg;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		InitialProjectHelper helper=new InitialProjectHelper();
		initialProjectDTO.setStatus("P");
		if(helper.isInsert(initialProjectDTO))
		{   
			this.setInitialProjectMsg(getText("faculty.added"));
			HODMailDTO hodMailDTO=new HODMailDTO();
			String user=(String) sessionMap.get("user");
			String subject="Approve/Reject The Project";
			Date date=new Date();
			hodMailDTO.setSender(user);
			hodMailDTO.setSubject(subject);
			hodMailDTO.setName(initialProjectDTO.getName());
			hodMailDTO.setDescription(initialProjectDTO.getDescription());
			hodMailDTO.setTechnology(initialProjectDTO.getTechnology());
			hodMailDTO.setDuration(initialProjectDTO.getDuration());
			hodMailDTO.setStatus("U");
			hodMailDTO.setDate(date);
			HODMailHelper hodMailHelper=new HODMailHelper();
			if(hodMailHelper.mailHOD(hodMailDTO)){
				System.out.println("Mail Send to hod successfully");
			}else{
				System.out.println("MAil failure for hod");
			}
			List idList=helper.getProjectId(initialProjectDTO);
			int id=(int) idList.get(0);
			StudentProjectDTO studentProjectDTO=new StudentProjectDTO();
			studentProjectDTO.setProjectId(id);
			studentProjectDTO.setEmail(user);
			StudentProjectHelper studentProjectHelper=new StudentProjectHelper();
			if(studentProjectHelper.insertProject(studentProjectDTO))
			{
			System.out.println("insert into studentProjects ");	
			}
			else{
				System.out.println("insert into studentProjects fails");
			}
			
			
			/*String subject="Accept/Reject The Project";
			String msg="";
			List idList=helper.getProjectId(initialProjectDTO);
			int id=(int) idList.get(0);
			this.setInitialProjectMsg(getText("faculty.added"));
			System.out.println("list id="+idList.get(0));
			Date date=new Date();
			LoginDTO loginDTO=new LoginDTO();
			LoginHelper loginHelper=new LoginHelper();
			String HodEmail=loginHelper.getHOD(loginDTO);
			System.out.println("HodEmail="+HodEmail);
			String user=(String) sessionMap.get("user");
			System.out.println("User="+user);
			mailBoxDTO.setRecevier(HodEmail);
			mailBoxDTO.setSender(user);
			mailBoxDTO.setStatus("U");
			mailBoxDTO.setDate(date);
			
			msg=msg+"$"+initialProjectDTO.getName()+"$"+initialProjectDTO.getDescription()+"$"+initialProjectDTO.getTechnology()
			+"$"+initialProjectDTO.getGuide();
			
			mailBoxDTO.setMessage(msg);
			mailBoxDTO.setSubject(subject);
			MailBoxHelper  boxHelper=new MailBoxHelper();
			boxHelper.sendEmail(mailBoxDTO);*/
			
			
		}
		else
		{
			this.setInitialProjectMsg(getText("faculty.readd"));
		}
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
}
