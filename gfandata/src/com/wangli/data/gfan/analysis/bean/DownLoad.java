package com.wangli.data.gfan.analysis.bean;

import java.sql.Timestamp;

public class DownLoad {
	
	/**
	 * 序号
	 */
	private int id;
	/**
	 * 日期
	 */
	private String dataTime;
	/**
	 * 移动设备国际身份码
	 */
	private String imei;
	/**
	 * 机锋的产品
	 */
	private String clientName;
	/**
	 * 客户端编号
	 */
	private String clientId;
	/**
	 * 客户端版本
	 */
	private String clientVersion;
	/**
	 * 渠道编号
	 */
	private String cid;
	/**
	 * 事件的编号
	 */
	private String eventId;
	/**
	 * 事件参数值
	 */
	private String eventValue;
	/**
	 * 事件来源
	 */
	private String eventSource;
	/**
	 * XML格式的报文
	 */
	private String args;
	/**
	 * 产品ID
	 */
	private int pid;
	/**
	 * 日志时间
	 */
	private Timestamp logTime;
	/**
	 * 数据插入时间
	 */
	private Timestamp insertTime;
	
	private String path;
	
	
	public DownLoad() {
		this.insertTime = new Timestamp(new java.util.Date().getTime());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDataTime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientVersion() {
		return clientVersion;
	}
	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventValue() {
		return eventValue;
	}
	public void setEventValue(String eventValue) {
		this.eventValue = eventValue;
	}
	public String getEventSource() {
		return eventSource;
	}
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Timestamp getLogTime() {
		return logTime;
	}
	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}
	public Timestamp getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
