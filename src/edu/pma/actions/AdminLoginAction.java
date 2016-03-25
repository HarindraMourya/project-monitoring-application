package edu.pma.actions;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.pma.dto.AdminDTO;
import edu.pma.dto.MailBoxDTO;
import edu.pma.helper.AdminLoginHelper;
import edu.pma.helper.EmailFetcher;

public class AdminLoginAction extends ActionSupport implements ModelDriven<AdminDTO>,SessionAware{
	AdminDTO adminDTO=new AdminDTO();
	String messege;
	//String g-recaptcha-response;
	HttpServletRequest request=ServletActionContext.getRequest();
	
	
	ArrayList<MailBoxDTO> mail=new ArrayList<>();
	public ArrayList<MailBoxDTO> getMail() {
		return mail;
	}
	public void setMail(ArrayList<MailBoxDTO> mail) {
		this.mail = mail;
	}
	private Map<String, Object> sessionMap=ActionContext.getContext().getSession();
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	
	
	@Override
	public AdminDTO getModel() {
		// TODO Auto-generated method stub
		return adminDTO;
	}
	public AdminDTO getAdminDTO() {
		return adminDTO;
	}
	public void setAdminDTO(AdminDTO adminDTO) {
		this.adminDTO = adminDTO;
	}

	@Override
	public String execute()
	{
		AdminLoginHelper adminLoginHelper=new AdminLoginHelper();
		
		String gReCaptchaResponse=request.getParameter("g-recaptcha-response");
		System.out.println("captcha="+gReCaptchaResponse);
		 boolean verify=verify(gReCaptchaResponse);
	//	if(verify){
		if(adminLoginHelper.login(adminDTO))
		{
			String email=adminDTO.getEmail();
			sessionMap.put("user",email);
			sessionMap.put("language", getLocale());
			setMessege(getText("login.message")+email);
			MailBoxDTO boxDTO=new MailBoxDTO();
			boxDTO.setRecevier(email);
			EmailFetcher emailFetcher=new EmailFetcher();
			mail=(ArrayList<MailBoxDTO>) emailFetcher.fetchEmail(boxDTO);
			System.out.println("mail="+mail);
			
			return SUCCESS;
		}
		else{
			setMessege(getText("login.invalid"));
			return ERROR;
		}
	/*	}
		else{
			this.setMessege(getText("google.invalid"));
			return ERROR;
		}*/
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.sessionMap = sessionMap;
	}
	public String logout(){  
	    sessionMap.remove("user");  
	    this.setMessege(getText("admin.logoumessage"));
	    
	    return "success";  
	} 
	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
    public static final String secret = "6LeYsBoTAAAAAIj3tkhriNpfODTW6zkxxccinqfy";
    
	public boolean verify(String gRecaptchaResponse)
	{
		if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
            return false;
        }
         
        try{
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
        // add reuqest header
        con.setRequestMethod("POST");
     //   con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
        String postParams = "secret=" + secret + "&response="
                + gRecaptchaResponse;
 
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();
 
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + postParams);
        System.out.println("Response Code : " + responseCode);
 
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
 
        // print result
        System.out.println(response.toString());
         
        //parse JSON response and return 'success' value
        JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
         
        return jsonObject.getBoolean("success");
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
	}
}
