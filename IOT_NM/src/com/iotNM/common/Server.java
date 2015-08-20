package com.iotNM.common;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	ServerSocket server = null;
	Socket sk = null;
	String  DLLpath;

	public Server(int socketPort,String dllPath) {
		this.DLLpath=dllPath;
		try {
			server = new ServerSocket(socketPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {		
			System.out.println("Listenning...");
			try {
				// 每个请求交给一个线程去处理
				sk = server.accept();
				ServerThread th = new ServerThread(sk,DLLpath);
				th.start();
				th.join();//java thread join();
				sleep(1000);
				server.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}

	public static void main(String[] args) {
		String  DLLpath="C:\\ClientDll.dll";
		new Server(4031,DLLpath).start();
	}
}
