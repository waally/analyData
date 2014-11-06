package com.wangli.data.gfan.service;

import java.sql.Date;

public interface AnalysisService {

	AnalysisService instance = new AnalysisServiceImpl();
	
	void analysisData();
	
	void analysisData(Date date);
	
}
