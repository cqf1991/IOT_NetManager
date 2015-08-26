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

	public Client(String IpAddr,int port)
	{
		try {
			sk = new Socket(IpAddr, port);// 要修改为可更改端口版本

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 向CIS发送请求
	 * 
	 * @param msgType
	 *            消息类型 1:目录消息 2:注册网络 3：注册子网 4:注册节点 5:注册传感器 6:节点探测
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
			case 6:
				byte abyteTest[]={78,84,95,67,77,68,0,0,0,0,0,0,0,0,0,0,68,0,0,0,0,-56,-79,-98,0,10,16,-99,6,0,4,0,77,83,71,84,89,80,69,0,0,0,1,0,0,0,4,0,83,85,66,84,89,80,69,0,0,0,2,0,0,0,4,0,83,84,65,84,69,80,69,0,4,0,0,0,4,0,78,84,73,68,0,0,0,0,0,0,17,0,0,0,4,0,83,66,78,84,73,68,0,0,0,0,-128,0,0,0,4,0,78,68,73,68,0,0,0,0,0,0,0,0,0,0};
				osOutputStream=sk.getOutputStream();
				osOutputStream.write(abyteTest);
				
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
		NODE aNode=new NODE("strDsp",12,"sccs","version",123,"bz",12,213,42,21,1,49);
		SENSOR aSensor=new SENSOR("sensorName","sensorMS","prod","ver","unit","formula","prms","max","min","strPrecision",1,49);
		
		new Client().sendMsg(5, aSensor);
		
	}
}
