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

	public void sendDirMsg() {
		try {

			byte[] abyte = dirMessage();
			OutputStream osOutputStream = sk.getOutputStream();
			osOutputStream.write(abyte);

		} catch (Exception e) {
			e.printStackTrace();
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
		new Client().sendDirMsg();
	}
}
