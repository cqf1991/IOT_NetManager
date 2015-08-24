package com.iotNM.common;

import java.io.OutputStream;
import java.net.Socket;

import org.xvolks.jnative.exceptions.NativeException;

import com.iotNM.entity.reg.NET;
import com.iotNM.entity.reg.NODE;
import com.iotNM.entity.reg.SENSOR;
import com.iotNM.entity.reg.SUBNET;

public class Client {
	static Socket sk = null;

	public Client() {

		try {
			sk = new Socket("127.0.0.1", 4029);// 要修改为可更改端口版本

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 向CIS发送请求
	 * 
	 * @param msgType
	 *            消息类型 1:目录消息 2:注册网络 3：注册子网 4:注册节点 5:注册传感器
	 * @param msg
	 *            具体的消息对象
	 */
	public void sendMsg(int msgType, Object msg) {
		byte[] abyte;
		OutputStream osOutputStream;
		try {
			switch (msgType) {
			case 1:// send dir msg
				abyte = dirMessage();
				osOutputStream = sk.getOutputStream();
				osOutputStream.write(abyte);
				break;
			case 2:// send regnet msg
				abyte = registNetMessage(msg);
				osOutputStream = sk.getOutputStream();
				osOutputStream.write(abyte);
				break;
			case 3:// send reg subnet msg
				abyte = registSubnetMsg(msg);
				osOutputStream = sk.getOutputStream();
				osOutputStream.write(abyte);
				break;
			case 4://send reg node msg
				abyte = registNodeMsg(msg);
				osOutputStream = sk.getOutputStream();
				osOutputStream.write(abyte);
				break;
			case 5://send reg sensor msg
				abyte = registSensorMsg(msg);
				osOutputStream = sk.getOutputStream();
				osOutputStream.write(abyte);				
				break;
			default:
				break;			
			}
			sk.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	// ===================================================================================

	private byte[] registSensorMsg(Object msg) {
		try {
			SENSOR asensorMsg = (SENSOR) msg;
			return javaCallDll.JAVA_Register_Sensor(asensorMsg);
		} catch (NativeException e) {
			e.printStackTrace();
			return null;
		}
	}
	private byte[] registNodeMsg(Object msg) {
		try {
			NODE anodeMsg = (NODE) msg;
			return javaCallDll.JAVA_Register_Node(anodeMsg);
		} catch (NativeException e) {
			e.printStackTrace();
			return null;
		}
	}

	private byte[] registSubnetMsg(Object msg) {
		try {
			SUBNET asubNetMsg = (SUBNET) msg;
			return javaCallDll.JAVA_Register_SubNet(asubNetMsg);
		} catch (NativeException e) {
			e.printStackTrace();
			return null;
		}
	}

	private byte[] registNetMessage(Object msg) {
		try {
			NET aNetMsg = (NET) msg;
			return javaCallDll.JAVA_Register_NET(aNetMsg);
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
		NET anet = new NET("abc", "abc", "abc", "abc", "abc", "abc", "abc",
				"abc", 28.0, 28.8, 28.88, 28.888, 49);
		SUBNET aSubnet=new SUBNET(42,21,"zwmc","zwms","192.1.1.1",12,213,"TCP/IP","tt",12,32,1,2,49);	
		
		new Client().sendMsg(3, aSubnet);
		
	}
}
