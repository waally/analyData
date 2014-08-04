package com.wangli.data.init;

import java.sql.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.wangli.data.quartz.StoredProcedureJobObject;
import com.wangli.data.service.AnalysisService;
import com.wangli.data.util.DateUtil;
import com.wangli.data.util.SpringUtil;

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
			}
		}else{
			schedulerJob();
		}
	}
	/**
	 * 启动定时任务
	 */
	private static void schedulerJob(){
		logger.info("MDATA start...");
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			Map<String, StoredProcedureJobObject> spjobs= SpringUtil.getSpringContext().getBeansOfType(StoredProcedureJobObject.class);
			for(StoredProcedureJobObject spjob:spjobs.values()){
				Trigger dayTrigger = spjob.getDayTrigger();
				JobDetail dayjobDetail = spjob.getDayjobDetail();
				scheduler.scheduleJob(dayjobDetail, dayTrigger);
			}
			scheduler.start();
			logger.info("MDATA start successful");
		} catch (SchedulerException e) {
			logger.fatal("scheduler start error!!!", e);
		}
	}
	/**
	 * 调用所有的存储过程
	 * @param beginTime
	 * @param endTime
	 */
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
	/**
	 * 调用单个存储过程
	 * @param callName
	 * @param beginTime
	 * @param endTime
	 */
	private static void callProcedures(String callName,String beginTime,String endTime){
		logger.info("MDATA start callProcedures start ...");
		Date beginDate = DateUtil.getFormString(beginTime);
		Date endDate = DateUtil.getFormString(endTime);
		for(Date date:DateUtil.getIntervalDays(beginDate, endDate)){
			AnalysisService.instance.analysisData(callName,date);
		}
		logger.info("MDATA do callProcedures successful ...");
	}
	/**
	 * 按照日期类型调用单个存储过程
	 * @param callName
	 * @param beginTime
	 * @param endTime
	 * @param type
	 */
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
}
