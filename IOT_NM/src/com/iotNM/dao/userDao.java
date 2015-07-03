package com.iotNM.dao;

import org.springframework.stereotype.Repository;

import com.iotNM.entity.user;
@Repository
public class userDao extends SimpleHibernateDao<user, Integer> {
public user getuserbyId(Integer id) {
	return super.get(id);
	
}
}
