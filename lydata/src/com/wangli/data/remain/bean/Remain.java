package com.wangli.data.remain.bean;

public class Remain {

	private String addBeginTime;
	private String addEndTIme;
	private String activeBeginTime;
	private String activeEndTime;
	private int beginUid;
	private int endUid;
	private int appKey;
	
	private int day;
	private double remainRate;
	
	public String getAddBeginTime() {
		return addBeginTime;
	}
	public void setAddBeginTime(String addBeginTime) {
		this.addBeginTime = addBeginTime;
	}
	public String getAddEndTIme() {
		return addEndTIme;
	}
	public void setAddEndTIme(String addEndTIme) {
		this.addEndTIme = addEndTIme;
	}
	public String getActiveBeginTime() {
		return activeBeginTime;
	}
	public void setActiveBeginTime(String activeBeginTime) {
		this.activeBeginTime = activeBeginTime;
	}
	public String getActiveEndTime() {
		return activeEndTime;
	}
	public void setActiveEndTime(String activeEndTime) {
		this.activeEndTime = activeEndTime;
	}
	public int getBeginUid() {
		return beginUid;
	}
	public void setBeginUid(int beginUid) {
		this.beginUid = beginUid;
	}
	public int getEndUid() {
		return endUid;
	}
	public void setEndUid(int endUid) {
		this.endUid = endUid;
	}
	public int getAppKey() {
		return appKey;
	}
	public void setAppKey(int appKey) {
		this.appKey = appKey;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double getRemainRate() {
		return remainRate;
	}
	public void setRemainRate(double remainRate) {
		this.remainRate = remainRate;
	}
}
