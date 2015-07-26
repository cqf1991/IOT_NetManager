package com.iotNM.action;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iotNM.common.Struts2Utils;
import com.iotNM.entity.user;
import com.iotNM.service.userManager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class loginAction extends ActionSupport {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	String loginName;

	String password;
	@Autowired
	private userManager userManager;

	public String login() throws Exception {

		try {

			Validate.notBlank(loginName, "用户名不能为空!");
			Validate.notBlank(password, "密码不能为空!");

			// 获取用户信息
			user user = userManager.getuserbyId(Integer.parseInt(loginName));// test
			if (user.getPassword().equals(password)) {
				Struts2Utils.getSession().setAttribute("user", user);
				// 成功登陆将user写入session，登陆验证拦截器生效，防止通过其他action登入
				logger.info("用户{}登录系统.", user.getloginName());
				return SUCCESS;
				
			}

		} catch (Exception e) {
			throw e;
		}
		return null;

	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
