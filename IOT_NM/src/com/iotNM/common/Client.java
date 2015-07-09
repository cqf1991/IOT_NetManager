package com.iotNM.common;

import java.io.OutputStream;
import java.net.Socket;

import org.xvolks.jnative.exceptions.NativeException;

import sun.security.krb5.internal.NetClient;

import com.iotNM.entity.reg.NET;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class Client{
	Socket sk = null;

	public Client() {

		try {
			sk = new Socket("127.0.0.1", 4029);//要修改为可更改端口版本

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 向CIS发送请求
	 * @param msgType  消息类型 1:目录消息  2:注册网络 3：注册子网 4:注册节点 5:注册传感器
	 * @param msg	   具体的消息对象
	 */
	public void sendMsg(int msgType,Object msg) {
		byte[] abyte;
		OutputStream osOutputStream;
		try {
			switch (msgType) {
			case 1://send dir msg
				abyte = dirMessage();
				osOutputStream = sk.getOutputStream();
				osOutputStream.write(abyte);
				break;
			case 2://sent regnet msg
				abyte = registNetMessage(msg);
				osOutputStream = sk.getOutputStream();
				osOutputStream.write(abyte);

			default:
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}

//===================================================================================
	private byte[] registNetMessage(Object msg)
	{
		try {
			NET aNetMsg=(NET)msg;
			return javaCallDll.JAVA_Register(aNetMsg);
		} catch (NativeException e) {
			e.printStackTrace();
			return null;
		}
	}
	private byte[] dirMessage() {

		try {
			return javaCallDll.JAVA_GetDirData();
		} catch (NativeException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		NET anet=new NET("abc", "abc", "abc", "abc", "abc", "abc", "abc", "abc", 123, 323, 31, 32, 49);
		new Client().sendMsg(2,anet);
	}
}
