package com.iotNM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * User实体类
 * @author 陈琦帆 2015-3-5 16:00:12
 *
 */
@Entity
@Table(name="T_User")
public class user {
	public user() {
		// TODO Auto-generated constructor stub
	}
	public user(Integer id, String loginName, String password) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.password = password;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
	@Column(name="loginName")
	private String loginName;
	@Column(name="password")
	private String password;
	public String getloginName() {
		return loginName;
	}
	public void setloginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	

}
