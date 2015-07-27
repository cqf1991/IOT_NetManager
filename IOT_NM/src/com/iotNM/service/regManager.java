package com.iotNM.service;

import org.springframework.stereotype.Service;
import org.xvolks.jnative.exceptions.NativeException;

import com.iotNM.common.javaCallDll;
import com.iotNM.entity.reg.NET;

@Service
public class regManager {

	public String netReg(String strNetName, String strNetDescrption,
			String strAddress, String strOrganUnit, String strRepUnit,
			String strLinkMan, String strPhone, String strMemo,
			float fCvrg_LB_X, float fCvrg_LB_Y, float fCvrg_RU_X,
			float fCvrg_RU_Y, int nAppId) throws NativeException {
		NET netRegOBJ = new NET();
		netRegOBJ.setStrNetName(strNetName);
		netRegOBJ.setStrNetDescrption(strNetDescrption);
		netRegOBJ.setStrAddress(strAddress);
		netRegOBJ.setStrOrganUnit(strOrganUnit);
		netRegOBJ.setStrRepUnit(strRepUnit);
		netRegOBJ.setStrLinkMan(strLinkMan);
		netRegOBJ.setStrPhone(strPhone);
		netRegOBJ.setStrMemo(strMemo);
		netRegOBJ.setfCvrg_LB_X(fCvrg_LB_X);
		netRegOBJ.setfCvrg_LB_Y(fCvrg_LB_Y);
		netRegOBJ.setfCvrg_RU_X(fCvrg_RU_X);
		netRegOBJ.setfCvrg_RU_Y(fCvrg_RU_Y);
		netRegOBJ.setnAppId(nAppId);
		
		javaCallDll.JAVA_Register_NET(netRegOBJ);
		
		return "";
	}

	public String subnetReg() {
		return "";
	}

	public String nodeReg() {
		return "";
	}

	public String senserReg() {
		return "";
	}
}
