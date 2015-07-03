package com.iotNM.service;


import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotNM.dao.userDao;
import com.iotNM.entity.user;

@RemoteProxy(name="usermanager")
@Service
public class userManager {
	@Autowired 
	private userDao userDao;
	@RemoteMethod
	public user getuserbyId(Integer id) {
		return userDao.getuserbyId(id);
		
	}
	public user getuserById2(Integer id) {
		return userDao.get(id);
		
	}
	
	public user getuser() {
		return userDao.findUniqueBy("username", 1);
		
	}

}
