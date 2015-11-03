package com.iotNM.action;

import com.iotNM.common.Client;
import com.opensymphony.xwork2.ActionSupport;

public class netCmdAction extends ActionSupport {
	public void nodeDetection() {
		
		
		new Client().sendMsg(6, "");//test
		
		
		
	} 

}
