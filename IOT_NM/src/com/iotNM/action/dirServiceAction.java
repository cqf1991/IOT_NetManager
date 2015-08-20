package com.iotNM.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import net.sf.json.util.JSONUtils;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.JSONUtil;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.springframework.stereotype.Controller;
import org.xvolks.jnative.exceptions.NativeException;

import com.iotNM.common.Client;
import com.iotNM.common.Server;
import com.iotNM.common.Struts2Utils;
import com.iotNM.common.javaCallDll;
import com.iotNM.service.navTreeManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Result;


@Controller
public class dirServiceAction extends ActionSupport {
	

	private navTreeManager anavTreeManager = new navTreeManager();
	public static String dirMsg="";
	
	@Override
	public String execute() throws Exception {
	
		Server aServer=new Server(4031,"C:\\ClientDll.dll");
		aServer.start();	
		Client aclient=new Client();
		aclient.sendMsg(1,null);
		aServer.join();
		String textValue=createNavTree(dirMsg);
		Struts2Utils.renderJson(textValue);//有问题
		System.out.println("123");
		return null;
	}

	public String createNavTree(String comMsg) {

		return anavTreeManager.generateTree(comMsg);
		
	}
	
	
}
