package com.wangli.data.analysis.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class AnalysisLog {

	private String callCode; 
	private String callName; 
	private Date dateTime; 
	private int type;
	private Timestamp insertTime;
	
	public AnalysisLog() {
		this.insertTime = new Timestamp(new java.util.Date().getTime());
		this.type = 0;
	}
	public String getCallCode() {
		return callCode;
	}
	public void setCallCode(String callCode) {
		this.callCode = callCode;
	}
	public String getCallName() {
		return callName;
	}
	public void setCallName(String callName) {
		this.callName = callName;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Timestamp getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	
}
