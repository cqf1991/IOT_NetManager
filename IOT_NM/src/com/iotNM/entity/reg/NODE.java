package com.iotNM.entity.reg;

public class NODE {
	private String strDsption;

	private int nNodeAddr;

	private String strProducer;

	private String strVersion;

	private int nTransPower;

	private String strMemo;
	
	private float fLctnX;
	
	private float fLctnY;
	
	private int nNetId;

	private int nSubnetId;
	
	private int nNodeTypeId;
	
	private int nAppId;
	
	public NODE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NODE(String strDsption, int nNodeAddr, String strProducer,
			String strVersion, int nTransPower, String strMemo, float fLctnX,
			float fLctnY, int nNetId, int nSubnetId, int nNodeTypeId, int nAppId) {
		super();
		this.strDsption = strDsption;
		this.nNodeAddr = nNodeAddr;
		this.strProducer = strProducer;
		this.strVersion = strVersion;
		this.nTransPower = nTransPower;
		this.strMemo = strMemo;
		this.fLctnX = fLctnX;
		this.fLctnY = fLctnY;
		this.nNetId = nNetId;
		this.nSubnetId = nSubnetId;
		this.nNodeTypeId = nNodeTypeId;
		this.nAppId = nAppId;
	}

	public String getStrDsption() {
		return strDsption;
	}

	public void setStrDsption(String strDsption) {
		this.strDsption = strDsption;
	}

	public int getnNodeAddr() {
		return nNodeAddr;
	}

	public void setnNodeAddr(int nNodeAddr) {
		this.nNodeAddr = nNodeAddr;
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

	public int getnTransPower() {
		return nTransPower;
	}

	public void setnTransPower(int nTransPower) {
		this.nTransPower = nTransPower;
	}

	public String getStrMemo() {
		return strMemo;
	}

	public void setStrMemo(String strMemo) {
		this.strMemo = strMemo;
	}

	public float getfLctnX() {
		return fLctnX;
	}

	public void setfLctnX(float fLctnX) {
		this.fLctnX = fLctnX;
	}

	public float getfLctnY() {
		return fLctnY;
	}

	public void setfLctnY(float fLctnY) {
		this.fLctnY = fLctnY;
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

	public int getnNodeTypeId() {
		return nNodeTypeId;
	}

	public void setnNodeTypeId(int nNodeTypeId) {
		this.nNodeTypeId = nNodeTypeId;
	}

	public int getnAppId() {
		return nAppId;
	}

	public void setnAppId(int nAppId) {
		this.nAppId = nAppId;
	}

}
