package com.wangli.data.init.service;

import java.util.Collection;

import com.wangli.data.inter.DataHandler;
import com.wangli.data.quartz.AnalysisGroup;
import com.wangli.data.quartz.AnalysisJobObject;

public interface LauncherService {

	LauncherService instance = new LauncherServiceImpl();
	/**
	 * 获取指定的数据处理组
	 * @param type
	 * @return
	 */
	AnalysisGroup getAnalysisGroup(String groupName);
	/**
	 * 获取指定的数据处理器
	 * @param type
	 * @return
	 */
	DataHandler getAnalysisHandler(String groupName,String handlerName);
	/**
	 * 获取所有的定时任务
	 * @return
	 */
	Collection<AnalysisJobObject> getAllJob();
	
}
