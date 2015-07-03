package com.iotNM.entity.xml;

public class PARAMETER {
	private String startLevel;

	private String endLevel;

	private String netID;

	private String subNetID;

	private String nodeID;

	private String sensorID;
	

	public void setstartLevel(String startLevel) {
		this.startLevel = startLevel;
	}

	public PARAMETER() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getstartLevel() {
		return this.startLevel;
	}

	public void setendLevel(String endLevel) {
		this.endLevel = endLevel;
	}

	public String getendLevel() {
		return this.endLevel;
	}

	public void setnetID(String netID) {
		this.netID = netID;
	}

	public String getnetID() {
		return this.netID;
	}

	public void setsubNetID(String subNetID) {
		this.subNetID = subNetID;
	}

	public String getsubNetID() {
		return this.subNetID;
	}

	public void setnodeID(String nodeID) {
		this.nodeID = nodeID;
	}

	public String getnodeID() {
		return this.nodeID;
	}

	public void setsensorID(String sensorID) {
		this.sensorID = sensorID;
	}

	public String getsensorID() {
		return this.sensorID;
	}

	public PARAMETER(String startLevel, String endLevel, String netID,
			String subNetID, String nodeID, String sensorID) {
		super();
		this.startLevel = startLevel;
		this.endLevel = endLevel;
		this.netID = netID;
		this.subNetID = subNetID;
		this.nodeID = nodeID;
		this.sensorID = sensorID;
	}

}
