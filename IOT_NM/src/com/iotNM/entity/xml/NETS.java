package com.iotNM.entity.xml;

import java.util.List;



public class NETS {
	private String NETSIZE;

	private List<NET> NETs;
	

	public NETS(String nETSIZE, List<NET> nETs) {
		super();
		NETSIZE = nETSIZE;
		NETs = nETs;
	}

	public void setNETSIZE(String NETSIZE) {
		this.NETSIZE = NETSIZE;
	}

	public String getNETSIZE() {
		return this.NETSIZE;
	}

	public void setNET(List<NET> NET) {
		this.NETs = NET;
	}

	public List<NET> getNET() {
		return this.NETs;
	}

	public NETS() {
		super();
		// TODO Auto-generated constructor stub
	}

}
