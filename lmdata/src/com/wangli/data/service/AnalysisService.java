package com.wangli.data.service;

import java.sql.Date;

public interface AnalysisService {
	/**
	 * 服务的单例对象
	 */
	AnalysisService instance = new AnalysisServiceImpl();
	/**
	 * 按照日期来调用单个存储过程
	 * @param callName
	 * @param date
	 */
	void analysisData(String callName,Date date);
	/**
	 * 调用某一日的存储过程
	 * @param logTime
	 */
	void analysisDayData(Date logTime);
}
