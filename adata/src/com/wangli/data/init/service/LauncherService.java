package com.wangli.data.init.service;

import java.util.Collection;

import com.wangli.data.analysis.DataAnalysis;
import com.wangli.data.quartz.AnalysisJobObject;

public interface LauncherService {

	LauncherService instance = new LauncherServiceImpl();
	/**
	 * 获取指定的数据分析处理器
	 * @param type
	 * @return
	 */
	DataAnalysis getDataAnalysis(int type);
	/**
	 * 获取所有的定时任务
	 * @return
	 */
	Collection<AnalysisJobObject> getAllJob();
	
}
