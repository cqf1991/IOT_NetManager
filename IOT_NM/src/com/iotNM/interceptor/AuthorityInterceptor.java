package com.iotNM.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


/**
 * 登录验证拦截器.
 * @author 尔演&Eryan eryanwcp@gmail.com
 */
@SuppressWarnings("serial")
public class AuthorityInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actioninvocation) throws Exception {
	    //登录用户
		Object user = ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user != null){
			return actioninvocation.invoke(); //递归调用拦截器
		}else{
			return Action.LOGIN; //返回到登录页面
		}
		
	}
}
