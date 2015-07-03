package com.iotNM.entity.xml;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="IOT_DIR")
public class IOT_DIR {
	private String packageName;

	private String appID;

	private String timeStamp;

	private String packageSize;

	private String PARAMETER;

	private NETS NETS;
	

	public IOT_DIR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IOT_DIR(String packageName, String appID, String timeStamp,
			String packageSize, String pARAMETER, com.iotNM.entity.xml.NETS nETS) {
		super();
		this.packageName = packageName;
		this.appID = appID;
		this.timeStamp = timeStamp;
		this.packageSize = packageSize;
		PARAMETER = pARAMETER;
		NETS = nETS;
	}

	public void setpackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getpackageName() {
		return this.packageName;
	}

	public void setappID(String appID) {
		this.appID = appID;
	}

	public String getappID() {
		return this.appID;
	}

	public void settimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String gettimeStamp() {
		return this.timeStamp;
	}

	public void setpackageSize(String packageSize) {
		this.packageSize = packageSize;
	}

	public String getpackageSize() {
		return this.packageSize;
	}

	public void setPARAMETER(String PARAMETER) {
		this.PARAMETER = PARAMETER;
	}

	public String getPARAMETER() {
		return this.PARAMETER;
	}

	public void setNETS(NETS NETS) {
		this.NETS = NETS;
	}

	public NETS getNETS() {
		return this.NETS;
	}

}
