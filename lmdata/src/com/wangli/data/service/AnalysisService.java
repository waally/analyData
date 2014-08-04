package com.wangli.data.service;

import java.sql.Date;

public interface AnalysisService {

	AnalysisService instance = new AnalysisServiceImpl();
	
	void analysisData(String callName,Date date);

	void analysisDayData(Date logTime);
}
