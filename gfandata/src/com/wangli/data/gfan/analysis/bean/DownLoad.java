package com.wangli.data.gfan.analysis.bean;

import java.sql.Timestamp;

public class DownLoad {
	
	/**
	 * ���
	 */
	private int id;
	/**
	 * ����
	 */
	private String dataTime;
	/**
	 * �ƶ��豸���������
	 */
	private String imei;
	/**
	 * ����Ĳ�Ʒ
	 */
	private String clientName;
	/**
	 * �ͻ��˱��
	 */
	private String clientId;
	/**
	 * �ͻ��˰汾
	 */
	private String clientVersion;
	/**
	 * �������
	 */
	private String cid;
	/**
	 * �¼��ı��
	 */
	private String eventId;
	/**
	 * �¼�����ֵ
	 */
	private String eventValue;
	/**
	 * �¼���Դ
	 */
	private String eventSource;
	/**
	 * XML��ʽ�ı���
	 */
	private String args;
	/**
	 * ��ƷID
	 */
	private int pid;
	/**
	 * ��־ʱ��
	 */
	private Timestamp logTime;
	/**
	 * ���ݲ���ʱ��
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
