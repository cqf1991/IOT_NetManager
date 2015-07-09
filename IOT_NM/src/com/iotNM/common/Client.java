package com.iotNM.common;

import java.io.OutputStream;
import java.net.Socket;

import org.xvolks.jnative.exceptions.NativeException;


public class Client{
	Socket sk = null;

	public Client() {

		try {
			sk = new Socket("127.0.0.1", 4029);//要修改为可更改端口版本

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendMsg(int msgType) {
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
				abyte = registNetMessage();
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
	private byte[] registNetMessage()
	{
		try {
			return javaCallDll.JAVA_Register();
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
		new Client().sendMsg(2);
	}
}
