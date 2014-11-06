package com.wangli.data.gfan.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.wangli.data.gfan.service.AnalysisService;

public class DayJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		AnalysisService.instance.analysisData();
	}

}
