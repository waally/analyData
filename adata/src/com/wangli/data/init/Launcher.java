package com.wangli.data.init;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.wangli.data.analysis.DataAnalysis;
import com.wangli.data.init.service.LauncherService;
import com.wangli.data.quartz.AnalysisJobObject;
import com.wangli.data.util.DateUtil;

public class Launcher {

	private static Logger logger = Logger.getLogger(Launcher.class);
	/**
	 * java程序启动类
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length>=1){
			if(args[0].equals("2")){
				if(args.length==4){
					callProcedures(args[1], args[2],args[3]);
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
			for(AnalysisJobObject spjob:LauncherService.instance.getAllJob()){
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
	 * 调用指定的数据分析处理器
	 * @param beginTime
	 * @param endTime
	 */
	private static void callProcedures(String type,String beginTime,String endTime){
		logger.info("MDATA start analysisProcedures start ...");
		DataAnalysis analysis = LauncherService.instance.getDataAnalysis(Integer.parseInt(type));
		Date beginDate = DateUtil.getFormString(beginTime);
		Date endDate = DateUtil.getFormString(endTime);
		for(Date date:DateUtil.getIntervalDays(beginDate, endDate)){
			logger.info("MDATA do analysisProcedures "+date);
			analysis.setDate(date);
			analysis.processAnalysis();
			logger.info("MDATA do analysisProcedures "+date+" successful");
		}
		logger.info("MDATA do analysisProcedures successful ...");
	}
	
}
