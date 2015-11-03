package com.iotNM.action;

import org.xvolks.jnative.exceptions.NativeException;

import com.iotNM.common.Client;
import com.iotNM.common.Struts2Utils;
import com.iotNM.common.javaCallDll;
import com.iotNM.entity.reg.NET;
import com.iotNM.entity.reg.NODE;
import com.iotNM.entity.reg.SENSOR;
import com.iotNM.entity.reg.SUBNET;
import com.opensymphony.xwork2.ActionSupport;


public class regAction extends ActionSupport {
	
	private String wlmc;//wlmc&netId
	private String wlms;
	private String whdw;
	private String ssdw;
	private String dd;
	private String lxr;
	private String lxdh;
	private float fgfwzsjd;
	private float fgfwzxjd;
	private float fgfwysjd;
	private float fgfwyxjd;
	private String bz;
	private int zwbh;
	private String zwmc;
	private String zwms;
	private String zwdz;
	private int gzxd;
	private int gzzq;
	private String jrfs;
	private int fsgl;
	private String sccs;
	private String ggxhhrjbb;
	private String jdlx;
	private String jdmsxx;
	private int jdwldz;
	private float jdwzjd;
	private float jdwzwd;
	private String cgqmc;
	private String cgqlx;
	private String cgqmsxx;
	private String zhgscslb;
	private String ggxhybb;
	private String jldw;
	private String zhgs;
	private String jd;
	private String sjzdz;
	private String sjzxz;
	
	

	public void netReg() throws NativeException {
		NET anetreg=new NET(wlmc,wlms,dd,ssdw,whdw,lxr,lxdh,bz,fgfwzsjd,fgfwzxjd,fgfwysjd,fgfwyxjd,49);//null 和“”的问题,null提交后会崩
		new Client().sendMsg(2, anetreg);
		Struts2Utils.renderJson("{success:true}");
		

	}
	public void subNetReg() {
		SUBNET asubnetReg=new SUBNET(Integer.parseInt(wlmc),zwbh,zwmc,zwms,zwdz,gzxd,gzzq,jrfs,bz,fgfwzsjd,fgfwysjd,fgfwzxjd,fgfwyxjd,49);
		new Client().sendMsg(3, asubnetReg);
		Struts2Utils.renderText("{success:true}");


	}
	public void nodeReg() {
		NODE anodeReg=new NODE(jdmsxx,jdwldz,sccs,ggxhhrjbb,fsgl,bz,jdwzjd,jdwzwd,Integer.parseInt(wlmc),Integer.parseInt(zwmc),1,49);//null 和“”的问题,null提交后会崩
		new Client().sendMsg(4, anodeReg);
		Struts2Utils.renderText("{success:true}");


	}
	public void sensorReg() {
		SENSOR asensorReg=new SENSOR(cgqmc,cgqmsxx,sccs,ggxhybb,jldw,zhgs,zhgscslb,sjzdz,sjzxz,jd,1,49);
		new Client().sendMsg(5, asensorReg);
		Struts2Utils.renderText("{success:true}");
	

	}

	public String getWlmc() {
		return wlmc;
	}
	public void setWlmc(String wlmc) {
		this.wlmc = wlmc;
	}
	public String getWlms() {
		return wlms;
	}
	public void setWlms(String wlms) {
		this.wlms = wlms;
	}
	public String getWhdw() {
		return whdw;
	}
	public void setWhdw(String whdw) {
		this.whdw = whdw;
	}
	public String getSsdw() {
		return ssdw;
	}
	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public float getFgfwzsjd() {
		return fgfwzsjd;
	}
	public void setFgfwzsjd(float fgfwzsjd) {
		this.fgfwzsjd = fgfwzsjd;
	}
	public float getFgfwzxjd() {
		return fgfwzxjd;
	}
	public void setFgfwzxjd(float fgfwzxjd) {
		this.fgfwzxjd = fgfwzxjd;
	}
	public float getFgfwysjd() {
		return fgfwysjd;
	}
	public void setFgfwysjd(float fgfwysjd) {
		this.fgfwysjd = fgfwysjd;
	}
	public float getFgfwyxjd() {
		return fgfwyxjd;
	}
	public void setFgfwyxjd(float fgfwyxjd) {
		this.fgfwyxjd = fgfwyxjd;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public int getZwbh() {
		return zwbh;
	}
	public void setZwbh(int zwbh) {
		this.zwbh = zwbh;
	}
	public String getZwmc() {
		return zwmc;
	}
	public void setZwmc(String zwmc) {
		this.zwmc = zwmc;
	}
	public String getZwms() {
		return zwms;
	}
	public void setZwms(String zwms) {
		this.zwms = zwms;
	}
	public String getZwdz() {
		return zwdz;
	}
	public void setZwdz(String zwdz) {
		this.zwdz = zwdz;
	}
	public int getGzxd() {
		return gzxd;
	}
	public void setGzxd(int gzxd) {
		this.gzxd = gzxd;
	}
	public int getGzzq() {
		return gzzq;
	}
	public void setGzzq(int gzzq) {
		this.gzzq = gzzq;
	}
	public String getJrfs() {
		return jrfs;
	}
	public void setJrfs(String jrfs) {
		this.jrfs = jrfs;
	}

	public String getSccs() {
		return sccs;
	}
	public void setSccs(String sccs) {
		this.sccs = sccs;
	}
	public String getGgxhhrjbb() {
		return ggxhhrjbb;
	}
	public void setGgxhhrjbb(String ggxhhrjbb) {
		this.ggxhhrjbb = ggxhhrjbb;
	}
	public String getJdlx() {
		return jdlx;
	}
	public void setJdlx(String jdlx) {
		this.jdlx = jdlx;
	}
	public String getJdmsxx() {
		return jdmsxx;
	}
	public void setJdmsxx(String jdmsxx) {
		this.jdmsxx = jdmsxx;
	}
	
	public String getCgqmc() {
		return cgqmc;
	}
	public void setCgqmc(String cgqmc) {
		this.cgqmc = cgqmc;
	}
	public String getCgqlx() {
		return cgqlx;
	}
	public void setCgqlx(String cgqlx) {
		this.cgqlx = cgqlx;
	}
	public String getCgqmsxx() {
		return cgqmsxx;
	}
	public void setCgqmsxx(String cgqmsxx) {
		this.cgqmsxx = cgqmsxx;
	}
	public String getZhgscslb() {
		return zhgscslb;
	}
	public void setZhgscslb(String zhgscslb) {
		this.zhgscslb = zhgscslb;
	}
	public String getGgxhybb() {
		return ggxhybb;
	}
	public void setGgxhybb(String ggxhybb) {
		this.ggxhybb = ggxhybb;
	}
	public String getJldw() {
		return jldw;
	}
	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	public String getZhgs() {
		return zhgs;
	}
	public void setZhgs(String zhgs) {
		this.zhgs = zhgs;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getSjzdz() {
		return sjzdz;
	}
	public void setSjzdz(String sjzdz) {
		this.sjzdz = sjzdz;
	}
	public String getSjzxz() {
		return sjzxz;
	}
	public void setSjzxz(String sjzxz) {
		this.sjzxz = sjzxz;
	}
	public int getFsgl() {
		return fsgl;
	}
	public void setFsgl(int fsgl) {
		this.fsgl = fsgl;
	}
	public int getJdwldz() {
		return jdwldz;
	}
	public void setJdwldz(int jdwldz) {
		this.jdwldz = jdwldz;
	}
	public float getJdwzjd() {
		return jdwzjd;
	}
	public void setJdwzjd(float jdwzjd) {
		this.jdwzjd = jdwzjd;
	}
	public float getJdwzwd() {
		return jdwzwd;
	}
	public void setJdwzwd(float jdwzwd) {
		this.jdwzwd = jdwzwd;
	}
	
	
}
