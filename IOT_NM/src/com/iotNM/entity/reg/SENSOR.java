package com.iotNM.entity.reg;

public class SENSOR {
	private String strSensorName;

	private String strSenorDescription;

	private String strProducer;

	private String strVersion;
	
	private String strUnit;
	
	private String strFormula;
	
	private String strPrms;
	
	private String strMax;
	
	private String strMin;
	
	private String strPrecision;
	
	private int nSensorType;
	
	private int nAppId;

	public SENSOR(String strSensorName, String strSenorDescription,
			String strProducer, String strVersion, String strUnit,
			String strFormula, String strPrms, String strMax, String strMin,
			String strPrecision, int nSensorType, int nAppId) {
		super();
		this.strSensorName = strSensorName;
		this.strSenorDescription = strSenorDescription;
		this.strProducer = strProducer;
		this.strVersion = strVersion;
		this.strUnit = strUnit;
		this.strFormula = strFormula;
		this.strPrms = strPrms;
		this.strMax = strMax;
		this.strMin = strMin;
		this.strPrecision = strPrecision;
		this.nSensorType = nSensorType;
		this.nAppId = nAppId;
	}

	public SENSOR() {
		super();
	}

	public String getStrSensorName() {
		return strSensorName;
	}

	public void setStrSensorName(String strSensorName) {
		this.strSensorName = strSensorName;
	}

	public String getStrSenorDescription() {
		return strSenorDescription;
	}

	public void setStrSenorDescription(String strSenorDescription) {
		this.strSenorDescription = strSenorDescription;
	}

	public String getStrProducer() {
		return strProducer;
	}

	public void setStrProducer(String strProducer) {
		this.strProducer = strProducer;
	}

	public String getStrVersion() {
		return strVersion;
	}

	public void setStrVersion(String strVersion) {
		this.strVersion = strVersion;
	}

	public String getStrUnit() {
		return strUnit;
	}

	public void setStrUnit(String strUnit) {
		this.strUnit = strUnit;
	}

	public String getStrFormula() {
		return strFormula;
	}

	public void setStrFormula(String strFormula) {
		this.strFormula = strFormula;
	}

	public String getStrPrms() {
		return strPrms;
	}

	public void setStrPrms(String strPrms) {
		this.strPrms = strPrms;
	}

	public String getStrMax() {
		return strMax;
	}

	public void setStrMax(String strMax) {
		this.strMax = strMax;
	}

	public String getStrMin() {
		return strMin;
	}

	public void setStrMin(String strMin) {
		this.strMin = strMin;
	}

	public String getStrPrecision() {
		return strPrecision;
	}

	public void setStrPrecision(String strPrecision) {
		this.strPrecision = strPrecision;
	}

	public int getnSensorType() {
		return nSensorType;
	}

	public void setnSensorType(int nSensorType) {
		this.nSensorType = nSensorType;
	}

	public int getnAppId() {
		return nAppId;
	}

	public void setnAppId(int nAppId) {
		this.nAppId = nAppId;
	}
	

	


	
}
