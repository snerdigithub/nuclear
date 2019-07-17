package com.snerdi.po;

import java.io.Serializable;

public class RCSPressBBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String timeStamp;
	private String RCSPressB;
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getRCSPressB() {
		return RCSPressB;
	}
	public void setRCSPressB(String rCSPressB) {
		RCSPressB = rCSPressB;
	}
	
	
}
