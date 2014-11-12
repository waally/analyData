package com.wangli.data.init.service;

import java.util.Collection;

import com.wangli.data.analysis.DataAnalysis;
import com.wangli.data.quartz.AnalysisJobObject;

public interface LauncherService {

	LauncherService instance = new LauncherServiceImpl();
	
	DataAnalysis getDataAnalysis(int type);
	
	Collection<AnalysisJobObject> getAllJob();
	
}
