package com.iotNM.action;

import com.iotNM.common.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

public class mapAction extends ActionSupport {
	public static String mapMsg="";
	
	@Override
	public String execute() throws Exception {
		
		Struts2Utils.renderText(mapMsg);
		// TODO Auto-generated method stub
	return null;//return null 或者void时返回的无整个页面的html
	
	}

}
