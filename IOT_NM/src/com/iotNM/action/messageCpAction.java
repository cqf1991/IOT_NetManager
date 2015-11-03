package com.iotNM.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.xvolks.jnative.exceptions.NativeException;

import com.iotNM.common.Client;
import com.iotNM.common.javaCallDll;
import com.iotNM.service.navTreeManager;
import com.iotNM.tests.ComMsg;
import com.iotNM.tests.packageBody;
import com.opensymphony.xwork2.ActionSupport;

/**
 * messageCollect&PushAction 消息收集及推送Action
 * 
 * @author Administrator TODO 这里要做manager 分别Collect和Push 和save
 */
@SuppressWarnings("serial")
@Controller
@RemoteProxy(name = "messagePush")
// dwr推送
public class messageCpAction extends ActionSupport {

	private navTreeManager anavTreeManager = new navTreeManager();
	private static ServerSocket server = null;
	private static Socket socket = null;

	public void closeSocket() throws IOException {
		messageCpAction.server.close();
	}

	@RemoteMethod
	public void getDIR() throws NativeException, IOException {

		new Client().sendMsg(1, null);
	}

	@RemoteMethod
	public void messageCP(final int socketPort) {// 参数需要添加xmlpath,dllpath
		Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
			public boolean match(ScriptSession session) {
				return true;
			}
		}, new Runnable() {

			private ScriptBuffer script = new ScriptBuffer();

			public void run() {
				try {
					server = new ServerSocket(socketPort);
					socket = server.accept();
				} catch (Exception e) {
					System.out.println("Error1:" + e);
					
				}
				try {
					while (true) {
						System.out.println("Listening");
						
						
						InputStream is = null;
						try {
							is = socket.getInputStream();
						} catch (IOException e) {
							System.out.println("Error3:" + e);
						}
						byte[] chars = new byte[1024];
						try {
							is.read(chars);
							System.out.println(chars);// 按位输出
							System.out.println("一条记录读取完毕！");
							ComMsg cm = new ComMsg(chars);//
							// server.close();// test 监听一次
							script = new ScriptBuffer();
							String outputString = "DataPackageName="
									+ cm.getDataPackageName()
									+ "</br>UserAppid=" + cm.getUserAPPID()
									+ "</br>Time=" + cm.getTime()
									+ "</br>KeyNum=" + cm.getKeyNum();
							String keyvalueMessage = "";
							for (packageBody entry : cm.getDataPackageBody()) {

								String key = entry.getKeyName();
								String value = entry.getKeyValue();
								keyvalueMessage += "keyName=" + key
										+ "  keyValue=" + value;

							}
							script.appendCall("testDWR", outputString
									+ "------" + keyvalueMessage);// test
							// 我需要给你一条什么样的数据？
							Collection<ScriptSession> sessions = Browser
									.getTargetSessions();
							for (ScriptSession scriptSession : sessions) {
								scriptSession.addScript(script);
							}
						} catch (IOException e) {
							System.out.println("Error4:" + e);
						}
					}
				} catch (Exception e) {
					System.out.println("Error2:" + e);
				}
			}
		});

	}

	public String createNavTree(String comMsg) {

		return anavTreeManager.generateTree(comMsg);

	}
}

/*
 * 原函数内容 System.out.println("cc");
 * 
 * Thread listenSocketThread=new Thread( new Runnable() { public void run() {
 * ServerSocket server = null; try{ server=new ServerSocket(4031);
 * }catch(Exception e){ System.out.println("Error1:"+e); } Socket socket = null;
 * 
 * while(true) { try{ System.out.println("开始监听..."); socket = server.accept();
 * System.out.println("与中间件连接成功！"); }catch(Exception e){
 * System.out.println("Error2:"+e); } InputStream is = null; try {
 * is=socket.getInputStream(); } catch (IOException e) {
 * System.out.println("Error3:"+e); }
 * 
 * byte[] chars = new byte[1024]; try { is.read(chars);
 * System.out.println(chars);//按位输出 System.out.println("一条记录读取完毕！"); ComMsg
 * cm=new ComMsg(chars); //test String
 * outputString="DataPackageName="+cm.getDataPackageName()+
 * "</br>UserAppid="+cm.
 * getUserAPPID()+"</br>Time="+cm.getTime()+"</br>KeyNum="+cm.getKeyNum();
 * String keyvalueMessage=""; for (packageBody entry : cm.getDataPackageBody())
 * {
 * 
 * String key=entry.getKeyName(); String value=entry.getKeyValue();
 * keyvalueMessage+="keyName="+key+"  keyValue="+value+"</br>";
 * 
 * } //测试数据包推送前台 //将从中间件得到的数据推送给浏览器 ScriptBuffer script = new ScriptBuffer();
 * script.appendCall("showMessage", outputString);
 * script.appendCall("showAnOtherMessage", keyvalueMessage);
 * Collection<ScriptSession> sessions = Browser.getTargetSessions(); for
 * (ScriptSession scriptSession : sessions){ scriptSession.addScript(script); }
 * } catch (IOException e) { // TODO Auto-generated catch block
 * System.out.println("Error4:"+e); try { is.close(); } catch (IOException e1) {
 * // TODO Auto-generated catch block System.out.println("Error5:"+e); } try {
 * socket.close(); } catch (IOException e1) { // TODO Auto-generated catch block
 * System.out.println("Error6:"+e); } continue; } try { is.close(); } catch
 * (IOException e) { // TODO Auto-generated catch block
 * System.out.println("Error7:"+e); } try { socket.close(); } catch (IOException
 * e) { // TODO Auto-generated catch block System.out.println("Error8:"+e); } }
 * } }); listenSocketThread.start();
 */
