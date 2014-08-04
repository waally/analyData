package com.wangli.data.analysis.bean;

import java.sql.Date;
import java.sql.Timestamp;
/**
 * 
 * @ClassName AnalysisLog
 * @Description 分析日志，调用存储过程操作会再数据库中做记录，用做日志。
 * @author wangli
 * @date 2014-8-4 下午6:22:55
 */
public class AnalysisLog {
	/**
	 * 存储过程编码
	 */
	private String callCode; 
	/**
	 * 存储过程名称
	 */
	private String callName; 
	/**
	 * 对应的数据的日期
	 */
	private Date dateTime; 
	/**
	 * 0开始1成功2失败
	 */
	private int type;
	/**
	 * 插入数据库的时间
	 */
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
