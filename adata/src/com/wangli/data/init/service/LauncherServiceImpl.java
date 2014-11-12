package com.wangli.data.init.service;

import java.util.Collection;

import com.wangli.data.analysis.DataAnalysis;
import com.wangli.data.quartz.AnalysisJobObject;
import com.wangli.data.spring.SpringUtil;
import com.wangli.data.util.DateUtil;

public class LauncherServiceImpl implements LauncherService {

	@Override
	public DataAnalysis getDataAnalysis(int type) {
		Collection<DataAnalysis> als = SpringUtil.getSpringContext().getBeansOfType(DataAnalysis.class).values();
		for(DataAnalysis al :als){
			if(al.getAnalysisType()==type){
				return al;
			}
		}
		return null;
	}

	@Override
	public Collection<AnalysisJobObject> getAllJob() {
		return SpringUtil.getSpringContext().getBeansOfType(AnalysisJobObject.class).values();
	}
	
	public static void main(String[] args) {
		DataAnalysis analysis = LauncherService.instance.getDataAnalysis(0);
		analysis.setDate(DateUtil.getLastDate(-3));
		analysis.processAnalysis();
	}

}
