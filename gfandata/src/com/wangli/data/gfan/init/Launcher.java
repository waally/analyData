package com.wangli.data.gfan.init;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

import com.wangli.data.gfan.quartz.DayJob;
import com.wangli.data.gfan.service.AnalysisService;
import com.wangli.data.gfan.util.DateUtil;

public class Launcher {

	private static Logger logger = Logger.getLogger(Launcher.class);
	
	public static void main(String[] args) {
		if(args.length>=1){
			if(args[0].equals("2")){
				if(args.length==3){
					callProcedures(args[1], args[2]);
				}
			}
		}else{
			schedulerJob();
		}
	}
	
	private static void schedulerJob(){
		logger.info("MDATA start...");
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Trigger dayTrigger = TriggerUtils.makeDailyTrigger("dayTrigger",2, 0);
		JobDetail dayjobDetail = new JobDetail("dayjob","analysis",DayJob.class);
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(dayjobDetail, dayTrigger);
			scheduler.start();
			logger.info("MDATA start successful");
		} catch (SchedulerException e) {
			logger.fatal("scheduler start error!!!", e);
		}
	}
	
	private static void callProcedures(String beginTime,String endTime){
		logger.info("MDATA start AnalysisData start ...");
		Date beginDate = DateUtil.getFormString(beginTime);
		Date endDate = DateUtil.getFormString(endTime);
		for(Date date:DateUtil.getIntervalDays(beginDate, endDate)){
			logger.debug("MDATA do AnalysisData "+date);
			AnalysisService.instance.analysisData(date);
			logger.debug("MDATA do AnalysisData "+date+" successful");
		}
		logger.info("MDATA do AnalysisData successful ...");
	}
	
}
