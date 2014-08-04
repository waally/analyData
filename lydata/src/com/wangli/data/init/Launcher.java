package com.wangli.data.init;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

import com.wangli.data.quartz.DayJob;
import com.wangli.data.quartz.DayJob2;
import com.wangli.data.service.AnalysisService;
import com.wangli.data.util.DateUtil;

public class Launcher {

	private static Logger logger = Logger.getLogger(Launcher.class);
	
	public static void main(String[] args) {
		if(args.length>=1){
			if(args[0].equals("2")){
				if(args.length==3){
					callProcedures(args[1], args[2]);
				}else if(args.length==4){
					callProcedures(args[1], args[2],args[3]);
				}else if(args.length==5){
					callProcedures(args[1], args[2],args[3], args[4]);
				}else{
					logger.info("args length error!!!");
				}
			}else if(args[0].equals("3")){
				if(args.length==3){
					callRemain(args[1], args[2]);
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
		Trigger dayTrigger2 = TriggerUtils.makeDailyTrigger("dayTrigger2",8, 0);
		JobDetail dayjobDetail = new JobDetail("dayjob","analysis",DayJob.class);
		JobDetail dayjobDetail2 = new JobDetail("dayjob2","analysis",DayJob2.class);
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(dayjobDetail, dayTrigger);
			scheduler.scheduleJob(dayjobDetail2, dayTrigger2);
			scheduler.start();
			logger.info("MDATA start successful");
		} catch (SchedulerException e) {
			logger.fatal("scheduler start error!!!", e);
		}
	}
	
	private static void callProcedures(String beginTime,String endTime){
		logger.info("MDATA start callProcedures start ...");
		Date beginDate = DateUtil.getFormString(beginTime);
		Date endDate = DateUtil.getFormString(endTime);
		for(Date date:DateUtil.getIntervalDays(beginDate, endDate)){
			logger.debug("MDATA do callProcedures "+date);
			AnalysisService.instance.analysisDayData(date);
			logger.debug("MDATA do callProcedures "+date+" successful");
		}
		logger.info("MDATA do callProcedures successful ...");
	}
	
	private static void callProcedures(String callName,String beginTime,String endTime){
		logger.info("MDATA start callProcedures start ...");
		Date beginDate = DateUtil.getFormString(beginTime);
		Date endDate = DateUtil.getFormString(endTime);
		for(Date date:DateUtil.getIntervalDays(beginDate, endDate)){
			AnalysisService.instance.analysisData(callName,date);
		}
		logger.info("MDATA do callProcedures successful ...");
	}
	private static void callProcedures(String callName,String beginTime,String endTime,String type){
		logger.info("MDATA start callProcedures start ...");
		Date beginDate = DateUtil.getFormString(beginTime);
		Date endDate = DateUtil.getFormString(endTime);
		for(Date date:DateUtil.getIntervalDays(beginDate, endDate)){
			if(type.equals("2")&&DateUtil.isLastMonthDay(date)){
				AnalysisService.instance.analysisData(callName,date);
			}else if(type.equals("4")&&DateUtil.isLastWeekDay(date)){
				AnalysisService.instance.analysisData(callName,date);
			}else if(type.equals("1")){
				AnalysisService.instance.analysisData(callName,date);
			}
		}
		logger.info("MDATA do callProcedures successful ...");
	}
	
	private static  void callRemain(String beginTime,String endTime){
		logger.info("MDATA start callProcedures start ...");
		Date beginDate = DateUtil.getFormString(beginTime);
		Date endDate = DateUtil.getFormString(endTime);
		for(Date date:DateUtil.getIntervalDays(beginDate, endDate)){
			logger.debug("MDATA do callProcedures "+date);
			AnalysisService.instance.analysisRemainData(date);
			logger.debug("MDATA do callProcedures "+date+" successful");
		}
		logger.info("MDATA do callProcedures successful ...");
	}
}
