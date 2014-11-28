package com.wangli.data.init.service;

import java.sql.Date;
import java.util.Collection;

import com.wangli.data.inter.DataHandler;
import com.wangli.data.quartz.AnalysisGroup;
import com.wangli.data.quartz.AnalysisJobObject;
import com.wangli.data.spring.SpringUtil;
import com.wangli.data.util.DateUtil;

public class LauncherServiceImpl implements LauncherService {

	@Override
	public Collection<AnalysisJobObject> getAllJob() {
		return SpringUtil.getSpringContext().getBeansOfType(AnalysisJobObject.class).values();
	}
	
	@Override
	public AnalysisGroup getAnalysisGroup(String groupName) {
		Collection<AnalysisGroup> ags = SpringUtil.getSpringContext().getBeansOfType(AnalysisGroup.class).values();
		for(AnalysisGroup ag : ags){
			if(ag.getGroupName().equals(groupName)){
				return ag;
			}
		}
		return null;
	}

	@Override
	public DataHandler getAnalysisHandler(String groupName, String handlerName) {
		AnalysisGroup ag = getAnalysisGroup(groupName);
		if(ag!=null){
			return ag.getHandler(handlerName);
		}
		return null;
	}
	
	public static void main(String[] args) {
		Date date = DateUtil.getLastDate(-6);
//		AnalysisGroup ag = LauncherService.instance.getAnalysisGroup("gfanmarket");
//		ag.process(date);
		DataHandler dh = LauncherService.instance.getAnalysisHandler("gfanmarket", "gfancall");
		dh.setDate(date);
		dh.processAnalysis();
	}

}
