package com.iotNM.entity.xml;

import java.util.List;

public class SUBNET {
	private String SBNTID;

	private String NTNM;

	private String DSPT;

	private String CVRG_LB_X;

	private String CVRG_LB_Y;

	private String CVRG_RU_X;

	private String CVRG_RU_Y;

	private String NODESIZE;

	private List<NODE> NODE;
	

	public SUBNET() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SUBNET(String sBNTID, String nTNM, String dSPT, String cVRG_LB_X,
			String cVRG_LB_Y, String cVRG_RU_X, String cVRG_RU_Y,
			String nODESIZE, List<com.iotNM.entity.xml.NODE> nODE) {
		super();
		SBNTID = sBNTID;
		NTNM = nTNM;
		DSPT = dSPT;
		CVRG_LB_X = cVRG_LB_X;
		CVRG_LB_Y = cVRG_LB_Y;
		CVRG_RU_X = cVRG_RU_X;
		CVRG_RU_Y = cVRG_RU_Y;
		NODESIZE = nODESIZE;
		NODE = nODE;
	}

	public void setSBNTID(String SBNTID) {
		this.SBNTID = SBNTID;
	}

	public String getSBNTID() {
		return this.SBNTID;
	}

	public void setNTNM(String NTNM) {
		this.NTNM = NTNM;
	}

	public String getNTNM() {
		return this.NTNM;
	}

	public void setDSPT(String DSPT) {
		this.DSPT = DSPT;
	}

	public String getDSPT() {
		return this.DSPT;
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

	public void setNODESIZE(String NODESIZE) {
		this.NODESIZE = NODESIZE;
	}

	public String getNODESIZE() {
		return this.NODESIZE;
	}

	public void setNODE(List<com.iotNM.entity.xml.NODE> NODE) {
		this.NODE = NODE;
	}

	public List<com.iotNM.entity.xml.NODE> getNODE() {
		return this.NODE;
	}

}
