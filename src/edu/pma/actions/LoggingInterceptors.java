package edu.pma.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.sun.net.httpserver.Authenticator.Success;

public class LoggingInterceptors implements Interceptor,SessionAware{
	private Map<String, Object> sessionMap=ActionContext.getContext().getSession();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		if(sessionMap.isEmpty())
		{
			System.out.println("session not present");
			return "invalidUser";
			
		}
		else{
			System.out.println("session present");
			return "success";
		}
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
