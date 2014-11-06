package com.wangli.data.gfan.service;


import java.sql.Date;

import com.wangli.data.gfan.analysis.DownClickAnalysis;
import com.wangli.data.gfan.util.DateUtil;

public class AnalysisServiceImpl implements AnalysisService {

	@Override
	public void analysisData() {
		DownClickAnalysis analysis = new DownClickAnalysis(DateUtil.getFormDate(DateUtil.getLastDate(-1)));
		analysis.process();
	}

	@Override
	public void analysisData(Date date) {
		DownClickAnalysis analysis = new DownClickAnalysis(DateUtil.getFormDate(date));
		analysis.process();
	}

}
