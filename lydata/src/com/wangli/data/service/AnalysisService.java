package com.wangli.data.service;

import java.sql.Date;

public interface AnalysisService {

	AnalysisService instance = new AnalysisServiceImpl();
	
	void analysisDayData();
	
	void analysisDayData2();
	
	void analysisRemainData();

	void analysisDayData(Date date);
	
	void analysisRemainData(Date date);
	
	void analysisData(String callName,Date date);

}
