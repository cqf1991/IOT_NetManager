package com.iotNM.tests;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iotNM.entity.user;
import com.iotNM.service.userManager;


public class test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");//测试AOP的时候要去掉配置文件中dwr部分，不明原因		
		AOPtest aoPtest=(AOPtest)context.getBean("AOPtest");
		aoPtest.save("save1");
		aoPtest.update("upadta", 1);
		userManager userManager=(userManager)context.getBean("userManager");
		user user=userManager.getuserbyId(1);
		user user2=userManager.getuserById2(1);
		//user user3=userManager.getuser();
		System.out.println(user.getloginName()+user.getPassword());
		System.out.println(user2.getloginName()+user2.getPassword());
		//System.out.println(user3.getUsername()+user3.getPassword());
		
		
	}

}
