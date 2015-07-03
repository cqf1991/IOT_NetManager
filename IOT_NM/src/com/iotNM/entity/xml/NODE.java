package com.iotNM.entity.xml;

import java.util.List;

public class NODE {
	private String NDPHDR;

	private String NDDSPT;

	private String TRSMTPWR;

	private String LCTN_X;

	private String LCTN_Y;

	private String SENSORSIZE;

	private List<SENSOR> SENSOR;
	

	public NODE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NODE(String nDPHDR, String nDDSPT, String tRSMTPWR, String lCTN_X,
			String lCTN_Y, String sENSORSIZE, List<com.iotNM.entity.xml.SENSOR> sENSOR) {
		super();
		NDPHDR = nDPHDR;
		NDDSPT = nDDSPT;
		TRSMTPWR = tRSMTPWR;
		LCTN_X = lCTN_X;
		LCTN_Y = lCTN_Y;
		SENSORSIZE = sENSORSIZE;
		SENSOR = sENSOR;
	}

	public void setNDPHDR(String NDPHDR) {
		this.NDPHDR = NDPHDR;
	}

	public String getNDPHDR() {
		return this.NDPHDR;
	}

	public void setNDDSPT(String NDDSPT) {
		this.NDDSPT = NDDSPT;
	}

	public String getNDDSPT() {
		return this.NDDSPT;
	}

	public void setTRSMTPWR(String TRSMTPWR) {
		this.TRSMTPWR = TRSMTPWR;
	}

	public String getTRSMTPWR() {
		return this.TRSMTPWR;
	}

	public void setLCTN_X(String LCTN_X) {
		this.LCTN_X = LCTN_X;
	}

	public String getLCTN_X() {
		return this.LCTN_X;
	}

	public void setLCTN_Y(String LCTN_Y) {
		this.LCTN_Y = LCTN_Y;
	}

	public String getLCTN_Y() {
		return this.LCTN_Y;
	}

	public void setSENSORSIZE(String SENSORSIZE) {
		this.SENSORSIZE = SENSORSIZE;
	}

	public String getSENSORSIZE() {
		return this.SENSORSIZE;
	}

	public void setSENSOR(List<com.iotNM.entity.xml.SENSOR> SENSOR) {
		this.SENSOR = SENSOR;
	}

	public List<com.iotNM.entity.xml.SENSOR> getSENSOR() {
		return this.SENSOR;
	}

}
