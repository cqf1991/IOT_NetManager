package com.iotNM.tests;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;

@Controller
@RemoteProxy( name="messagePush333")
public class testDWR {
	@RemoteMethod  
	public String messageCP(String para)
	{
		return "return "+para;
	}
}
