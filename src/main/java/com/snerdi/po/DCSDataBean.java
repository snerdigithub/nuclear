package com.snerdi.po;

import java.io.Serializable;

public class DCSDataBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String timeStamp;//时间戳
	
	private String GSWD;//给水温度FWS_TE1011
	
	private String ZGSLL;//主给水流量(FWS_FT050B_MED+FWS_FT051B_MED)/2
	
	private String ZBZS1;//主泵转速 RCS_ST281,RCS_ST282,RCS_ST283,RCS_ST284

	private String ZBZS2;//主泵转速 RCS_ST281,RCS_ST282,RCS_ST283,RCS_ST284

	private String ZBZS3;//主泵转速 RCS_ST281,RCS_ST282,RCS_ST283,RCS_ST284

	private String ZBZS4;//主泵转速 RCS_ST281,RCS_ST282,RCS_ST283,RCS_ST284

	private String FYDHGL;//反应堆核功率 PMSA_PRPP_1_MED

	private String FDJYGGL;//发电机有功功率  ZAS_JY_T101_MWG

	private String FDJWGGL;//发电机无功功率  ZAS_JY_T101_MVARG
	
	private String HL1RCSRDLL;//环路1RCS热段流量 RCS_FT101A
	
	private String HL2RCSRDLL;//环路1RCS热段流量 RCS_FT102A
	
	private String HL1RCSRDWD;//环路1RCS热段温度 RCS_TE133A

	private String HL2RCSRDWD;//环路2RCS热段温度 RCS_TE133B
	
	private String RCSYLA;//RCS压力A RCS_PT140A
	
	private String RCSYLB;//RCS压力B RCS_PT140B

	public String getGSWD() {
		return GSWD;
	}

	public void setGSWD(String gSWD) {
		GSWD = gSWD;
	}

	public String getZGSLL() {
		return ZGSLL;
	}

	public void setZGSLL(String zGSLL) {
		ZGSLL = zGSLL;
	}

	public String getZBZS1() {
		return ZBZS1;
	}

	public void setZBZS1(String zBZS1) {
		ZBZS1 = zBZS1;
	}

	public String getZBZS2() {
		return ZBZS2;
	}

	public void setZBZS2(String zBZS2) {
		ZBZS2 = zBZS2;
	}

	public String getZBZS3() {
		return ZBZS3;
	}

	public void setZBZS3(String zBZS3) {
		ZBZS3 = zBZS3;
	}

	public String getZBZS4() {
		return ZBZS4;
	}

	public void setZBZS4(String zBZS4) {
		ZBZS4 = zBZS4;
	}

	public String getFYDHGL() {
		return FYDHGL;
	}

	public void setFYDHGL(String fYDHGL) {
		FYDHGL = fYDHGL;
	}

	public String getFDJYGGL() {
		return FDJYGGL;
	}

	public void setFDJYGGL(String fDJYGGL) {
		FDJYGGL = fDJYGGL;
	}

	public String getFDJWGGL() {
		return FDJWGGL;
	}

	public void setFDJWGGL(String fDJWGGL) {
		FDJWGGL = fDJWGGL;
	}

	public String getHL1RCSRDLL() {
		return HL1RCSRDLL;
	}

	public void setHL1RCSRDLL(String hL1RCSRDLL) {
		HL1RCSRDLL = hL1RCSRDLL;
	}

	public String getHL2RCSRDLL() {
		return HL2RCSRDLL;
	}

	public void setHL2RCSRDLL(String hL2RCSRDLL) {
		HL2RCSRDLL = hL2RCSRDLL;
	}

	public String getHL1RCSRDWD() {
		return HL1RCSRDWD;
	}

	public void setHL1RCSRDWD(String hL1RCSRDWD) {
		HL1RCSRDWD = hL1RCSRDWD;
	}

	public String getHL2RCSRDWD() {
		return HL2RCSRDWD;
	}

	public void setHL2RCSRDWD(String hL2RCSRDWD) {
		HL2RCSRDWD = hL2RCSRDWD;
	}

	public String getRCSYLA() {
		return RCSYLA;
	}

	public void setRCSYLA(String rCSYLA) {
		RCSYLA = rCSYLA;
	}

	public String getRCSYLB() {
		return RCSYLB;
	}

	public void setRCSYLB(String rCSYLB) {
		RCSYLB = rCSYLB;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}
