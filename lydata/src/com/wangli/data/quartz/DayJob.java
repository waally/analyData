package com.wangli.data.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.wangli.data.service.AnalysisService;

public class DayJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		AnalysisService.instance.analysisDayData();
		AnalysisService.instance.analysisRemainData();
	}

}
