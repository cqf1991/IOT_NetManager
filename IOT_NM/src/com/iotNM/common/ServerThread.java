package com.iotNM.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import com.iotNM.action.dirServiceAction;
import com.iotNM.action.mapAction;

public class ServerThread extends Thread {
	Socket sk = null;
	String dllFindPath;
	String xmlFileString="";
	public String getXmlFileString() {
		return xmlFileString;
	}

	public void setXmlFileString(String xmlFileString) {
		this.xmlFileString = xmlFileString;
	}

	int packageNum=0;
	public ServerThread(Socket sk,String dllPath) {
		this.sk = sk;
		this.dllFindPath=dllPath;
	}

	public void run() {
		try {
			InputStream is = null;
			byte[] chars = new byte[1024];
			is = sk.getInputStream();
			String xmlTemp=null;
			while(is.read(chars)!=-1)
			{	
				if(packageNum==0)
				{
					packageNum++;
					continue;
				}
			xmlTemp=new String(chars,"GB2312").substring(37).trim();
			xmlFileString+=xmlTemp;			
			}
			xmlFileString=xmlFileString.replaceAll("\r|\n", "");
			System.out.println(xmlFileString);
			dirServiceAction.dirMsg=xmlFileString;
			mapAction.mapMsg=JsonMapper.xml2JSON(xmlFileString);
			System.out.println(mapAction.mapMsg);

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
