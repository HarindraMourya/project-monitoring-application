package edu.pma.actions;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ClearCacheInterceptor  extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
    	System.out.println("interceptor called");
        ActionContext context=(ActionContext)invocation.getInvocationContext();
        HttpServletResponse response=(HttpServletResponse)context.get(StrutsStatics.HTTP_RESPONSE);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);
        String result=invocation.invoke();
        System.out.println("result="+result);
        return result;
    }
}