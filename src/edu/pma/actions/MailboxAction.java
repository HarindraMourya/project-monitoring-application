package edu.pma.actions;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.pma.dto.MailBoxDTO;
import edu.pma.helper.MailBoxHelper;

public class MailboxAction extends ActionSupport implements ModelDriven<MailBoxDTO>,SessionAware{
	MailBoxDTO mailBoxDTO=new MailBoxDTO();
	String mailMessage;
	public String getMailMessage() {
		return mailMessage;
	}

	public void setMailMessage(String mailMessage) {
		this.mailMessage = mailMessage;
	}

	private Map<String, Object> sessionMap=ActionContext.getContext().getSession();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Date date=new Date();
		mailBoxDTO.setSender((String)sessionMap.get("user"));
		mailBoxDTO.setStatus("U");
		mailBoxDTO.setDate(date);
		MailBoxHelper  boxHelper=new MailBoxHelper();
		if(boxHelper.sendEmail(mailBoxDTO))
		{
			this.setMailMessage(getText("mail.message"));
		}else{
			this.setMailMessage(getText("mail.message"));
		}
		return SUCCESS;
	}

	@Override
	public MailBoxDTO getModel() {
		// TODO Auto-generated method stub
		return mailBoxDTO;
	}

	public MailBoxDTO getMailBoxDTO() {
		return mailBoxDTO;
	}

	public void setMailBoxDTO(MailBoxDTO mailBoxDTO) {
		this.mailBoxDTO = mailBoxDTO;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
