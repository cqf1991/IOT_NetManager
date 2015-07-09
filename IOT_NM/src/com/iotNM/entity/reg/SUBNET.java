package com.iotNM.entity.reg;

public class SUBNET {
	private int nNetId;

	private int nSubnetId;
	
	private String strSubnetName;

	private String strSubnetDescrption;

	private String strSinkIp;

	private int nChannel;

	private int nWorkCycle;

	private String strAcsMethodName;

	private String strMemo;

	private float fCvrg_LB_X;
	
	private float fCvrg_LB_Y;
	
	private float fCvrg_RU_X;
	
	private float fCvrg_RU_Y;
	
	private int nAppId;

	
	public SUBNET() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SUBNET(int nNetId, int nSubnetId, String strSubnetName,
			String strSubnetDescrption, String strSinkIp, int nChannel,
			int nWorkCycle, String strAcsMethodName, String strMemo,
			float fCvrg_LB_X, float fCvrg_LB_Y, float fCvrg_RU_X,
			float fCvrg_RU_Y, int nAppId) {
		super();
		this.nNetId = nNetId;
		this.nSubnetId = nSubnetId;
		this.strSubnetName = strSubnetName;
		this.strSubnetDescrption = strSubnetDescrption;
		this.strSinkIp = strSinkIp;
		this.nChannel = nChannel;
		this.nWorkCycle = nWorkCycle;
		this.strAcsMethodName = strAcsMethodName;
		this.strMemo = strMemo;
		this.fCvrg_LB_X = fCvrg_LB_X;
		this.fCvrg_LB_Y = fCvrg_LB_Y;
		this.fCvrg_RU_X = fCvrg_RU_X;
		this.fCvrg_RU_Y = fCvrg_RU_Y;
		this.nAppId = nAppId;
	}


	public int getnNetId() {
		return nNetId;
	}


	public void setnNetId(int nNetId) {
		this.nNetId = nNetId;
	}


	public int getnSubnetId() {
		return nSubnetId;
	}


	public void setnSubnetId(int nSubnetId) {
		this.nSubnetId = nSubnetId;
	}


	public String getStrSubnetName() {
		return strSubnetName;
	}


	public void setStrSubnetName(String strSubnetName) {
		this.strSubnetName = strSubnetName;
	}


	public String getStrSubnetDescrption() {
		return strSubnetDescrption;
	}


	public void setStrSubnetDescrption(String strSubnetDescrption) {
		this.strSubnetDescrption = strSubnetDescrption;
	}


	public String getStrSinkIp() {
		return strSinkIp;
	}


	public void setStrSinkIp(String strSinkIp) {
		this.strSinkIp = strSinkIp;
	}


	public int getnChannel() {
		return nChannel;
	}


	public void setnChannel(int nChannel) {
		this.nChannel = nChannel;
	}


	public int getnWorkCycle() {
		return nWorkCycle;
	}


	public void setnWorkCycle(int nWorkCycle) {
		this.nWorkCycle = nWorkCycle;
	}


	public String getStrAcsMethodName() {
		return strAcsMethodName;
	}


	public void setStrAcsMethodName(String strAcsMethodName) {
		this.strAcsMethodName = strAcsMethodName;
	}


	public String getStrMemo() {
		return strMemo;
	}


	public void setStrMemo(String strMemo) {
		this.strMemo = strMemo;
	}


	public float getfCvrg_LB_X() {
		return fCvrg_LB_X;
	}


	public void setfCvrg_LB_X(float fCvrg_LB_X) {
		this.fCvrg_LB_X = fCvrg_LB_X;
	}


	public float getfCvrg_LB_Y() {
		return fCvrg_LB_Y;
	}


	public void setfCvrg_LB_Y(float fCvrg_LB_Y) {
		this.fCvrg_LB_Y = fCvrg_LB_Y;
	}


	public float getfCvrg_RU_X() {
		return fCvrg_RU_X;
	}


	public void setfCvrg_RU_X(float fCvrg_RU_X) {
		this.fCvrg_RU_X = fCvrg_RU_X;
	}


	public float getfCvrg_RU_Y() {
		return fCvrg_RU_Y;
	}


	public void setfCvrg_RU_Y(float fCvrg_RU_Y) {
		this.fCvrg_RU_Y = fCvrg_RU_Y;
	}


	public int getnAppId() {
		return nAppId;
	}


	public void setnAppId(int nAppId) {
		this.nAppId = nAppId;
	}

	

}
