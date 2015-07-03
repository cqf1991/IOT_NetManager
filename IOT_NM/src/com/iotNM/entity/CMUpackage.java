package com.iotNM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * communicationPackage通讯包实体类
 * @author 陈琦帆 2015-3-5 
 *
 */
@Entity
@Table(name="T_CMUpackage")
public class CMUpackage {
	/**
	 * 自增主键ID
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
	/**
	 * 感知包数据 字节流
	 */
	@Column(name="sensorCMUpackage")
	private byte[] sensorCMUpackage;
	
	public CMUpackage() {
	}	
	public CMUpackage(int id, byte[] sensorCMUpackage) {
		super();
		this.id = id;
		this.sensorCMUpackage = sensorCMUpackage;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getSensorCMUpackage() {
		return sensorCMUpackage;
	}
	public void setSensorCMUpackage(byte[] sensorCMUpackage) {
		this.sensorCMUpackage = sensorCMUpackage;
	}

}
