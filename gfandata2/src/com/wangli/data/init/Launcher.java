package com.wangli.data.init;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.wangli.data.init.service.LauncherService;
import com.wangli.data.inter.DataHandler;
import com.wangli.data.quartz.AnalysisGroup;
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
				if(args.length==4){
					callProcedures(args[0],args[1], args[2],args[3]);
				}else if(args.length==3){
					callProcedures(args[0],args[1], args[2]);
				}else{
					logger.info("args length error!!!");
				}
		}else{
			schedulerJob();
		}
	}
	/**
	 * 启动定时任务
	 */
	private static void schedulerJob(){
		logger.info("MDATA schedulerJob start...");
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			for(AnalysisJobObject spjob:LauncherService.instance.getAllJob()){
				Trigger dayTrigger = spjob.getDayTrigger();
				JobDetail dayjobDetail = spjob.getDayjobDetail();
				scheduler.scheduleJob(dayjobDetail, dayTrigger);
			}
			scheduler.start();
			logger.info("MDATA schedulerJob start successful");
		} catch (SchedulerException e) {
			logger.fatal("scheduler schedulerJob start error!!!", e);
		}
	}
	/**
	 * 调用指定的数据分析处理器
	 * @param beginTime
	 * @param endTime
	 */
	private static void callProcedures(String groupName,String beginTime,String endTime){
		logger.info("MDATA AnalysisGroup "+groupName+" start ...");
		AnalysisGroup ag = LauncherService.instance.getAnalysisGroup(groupName);
		Date beginDate = DateUtil.getFormString(beginTime);
		Date endDate = DateUtil.getFormString(endTime);
		for(Date date:DateUtil.getIntervalDays(beginDate, endDate)){
			logger.info("MDATA AnalysisGroup "+groupName+" "+date);
			ag.process(date);
			logger.info("MDATA AnalysisGroup "+groupName+" "+date+" successful");
		}
		logger.info("MDATA AnalysisGroup "+groupName+" successful ...");
	}
	/**
	 * 调用指定的数据分析处理器
	 * @param beginTime
	 * @param endTime
	 */
	private static void callProcedures(String groupName,String handlerName,String beginTime,String endTime){
		logger.info("MDATA DataHandler "+handlerName+" start ...");
		DataHandler dh = LauncherService.instance.getAnalysisHandler(groupName, handlerName);
		Date beginDate = DateUtil.getFormString(beginTime);
		Date endDate = DateUtil.getFormString(endTime);
		for(Date date:DateUtil.getIntervalDays(beginDate, endDate)){
			logger.info("MDATA DataHandler "+handlerName+" "+date);
			dh.setDate(date);
			dh.processAnalysis();
			logger.info("MDATA DataHandler "+handlerName+" "+date+" successful");
		}
		logger.info("MDATA DataHandler "+handlerName+" successful ...");
	}
	
}
