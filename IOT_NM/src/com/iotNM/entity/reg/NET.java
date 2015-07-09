package com.iotNM.entity.reg;

public class NET {
	private String strNetName;

	private String strNetDescrption;

	private String strAddress;

	private String strOrganUnit;

	private String strRepUnit;

	private String strLinkMan;
	
	private String strPhone;
	
	private String strMemo;
	private float fCvrg_LB_X;
	
	private float fCvrg_LB_Y;
	
	private float fCvrg_RU_X;
	
	private float fCvrg_RU_Y;
	
	private int nAppId;
	
	

	public NET() {
		super();
	}


	public NET(String strNetName, String strNetDescrption, String strAddress,
			String strOrganUnit, String strRepUnit, String strLinkMan,
			String strPhone, String strMemo, float fCvrg_LB_X,
			float fCvrg_LB_Y, float fCvrg_RU_X, float fCvrg_RU_Y, int nAppId) {
		super();
		this.strNetName = strNetName;
		this.strNetDescrption = strNetDescrption;
		this.strAddress = strAddress;
		this.strOrganUnit = strOrganUnit;
		this.strRepUnit = strRepUnit;
		this.strLinkMan = strLinkMan;
		this.strPhone = strPhone;
		this.strMemo = strMemo;
		this.fCvrg_LB_X = fCvrg_LB_X;
		this.fCvrg_LB_Y = fCvrg_LB_Y;
		this.fCvrg_RU_X = fCvrg_RU_X;
		this.fCvrg_RU_Y = fCvrg_RU_Y;
		this.nAppId = nAppId;
	}


	public String getStrNetName() {
		return strNetName;
	}



	public void setStrNetName(String strNetName) {
		this.strNetName = strNetName;
	}



	public String getStrNetDescrption() {
		return strNetDescrption;
	}



	public void setStrNetDescrption(String strNetDescrption) {
		this.strNetDescrption = strNetDescrption;
	}



	public String getStrAddress() {
		return strAddress;
	}



	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}



	public String getStrOrganUnit() {
		return strOrganUnit;
	}



	public void setStrOrganUnit(String strOrganUnit) {
		this.strOrganUnit = strOrganUnit;
	}



	public String getStrRepUnit() {
		return strRepUnit;
	}



	public void setStrRepUnit(String strRepUnit) {
		this.strRepUnit = strRepUnit;
	}



	public String getStrLinkMan() {
		return strLinkMan;
	}



	public void setStrLinkMan(String strLinkMan) {
		this.strLinkMan = strLinkMan;
	}



	public String getStrPhone() {
		return strPhone;
	}



	public void setStrPhone(String strPhone) {
		this.strPhone = strPhone;
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
