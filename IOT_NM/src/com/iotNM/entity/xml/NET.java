package com.iotNM.entity.xml;

import java.util.List;

public class NET {
	private String NTID;

	private String NTDSCRPT;

	private String CVRG_LB_X;

	private String CVRG_LB_Y;

	private String CVRG_RU_X;

	private String CVRG_RU_Y;

	private String SUBNETSIZE;

	private List<SUBNET> SUBNETs;
	

	public NET() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NET(String nTID, String nTDSCRPT, String cVRG_LB_X,
			String cVRG_LB_Y, String cVRG_RU_X, String cVRG_RU_Y,
			String sUBNETSIZE, List<SUBNET> sUBNETs) {
		super();
		NTID = nTID;
		NTDSCRPT = nTDSCRPT;
		CVRG_LB_X = cVRG_LB_X;
		CVRG_LB_Y = cVRG_LB_Y;
		CVRG_RU_X = cVRG_RU_X;
		CVRG_RU_Y = cVRG_RU_Y;
		SUBNETSIZE = sUBNETSIZE;
		SUBNETs = sUBNETs;
	}

	public void setNTID(String NTID) {
		this.NTID = NTID;
	}

	public String getNTID() {
		return this.NTID;
	}

	public void setNTDSCRPT(String NTDSCRPT) {
		this.NTDSCRPT = NTDSCRPT;
	}

	public String getNTDSCRPT() {
		return this.NTDSCRPT;
	}

	public void setCVRG_LB_X(String CVRG_LB_X) {
		this.CVRG_LB_X = CVRG_LB_X;
	}

	public String getCVRG_LB_X() {
		return this.CVRG_LB_X;
	}

	public void setCVRG_LB_Y(String CVRG_LB_Y) {
		this.CVRG_LB_Y = CVRG_LB_Y;
	}

	public String getCVRG_LB_Y() {
		return this.CVRG_LB_Y;
	}

	public void setCVRG_RU_X(String CVRG_RU_X) {
		this.CVRG_RU_X = CVRG_RU_X;
	}

	public String getCVRG_RU_X() {
		return this.CVRG_RU_X;
	}

	public void setCVRG_RU_Y(String CVRG_RU_Y) {
		this.CVRG_RU_Y = CVRG_RU_Y;
	}

	public String getCVRG_RU_Y() {
		return this.CVRG_RU_Y;
	}

	public void setSUBNETSIZE(String SUBNETSIZE) {
		this.SUBNETSIZE = SUBNETSIZE;
	}

	public String getSUBNETSIZE() {
		return this.SUBNETSIZE;
	}

	public void setSUBNET(List<SUBNET> SUBNET) {
		this.SUBNETs = SUBNET;
	}

	public List<SUBNET> getSUBNET() {
		return this.SUBNETs;
	}

}
