package com.wangli.data.quartz;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
/**
 * 
 * @ClassName StoredProcedureJobObject
 * @Description 存储过程定时任务对象
 * @author wangli
 * @date 2014-8-4 下午6:34:11
 */
public class AnalysisJobObject {

	private static Logger logger = Logger.getLogger(AnalysisJobObject.class);
	/**
	 * 工作名称
	 */
	private String jobName;
	/**
	 * 工作所属组
	 */
	private String jobGroup;
	/**
	 * 触发器名称
	 */
	private String triggerName;
	/**
	 * 触发器所属时间
	 */
	private String triggerGroup;
	/**
	 * 触发器所属时间
	 */
	private String triggerTime;
	/**
	 * 所有调用的数据分析处理器
	 */
	private AnalysisGroup analysisGroup = new AnalysisGroup();
	
	private CronTrigger dayTrigger;
	
	private JobDetail dayjobDetail;
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getTriggerName() {
		return triggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public AnalysisGroup getAnalysisGroup() {
		return analysisGroup;
	}
	public void setAnalysisGroup(AnalysisGroup analysisGroup) {
		this.analysisGroup = analysisGroup;
	}
	public String getTriggerGroup() {
		return triggerGroup;
	}
	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}
	public String getTriggerTime() {
		return triggerTime;
	}
	public void setTriggerTime(String triggerTime) {
		this.triggerTime = triggerTime;
	}
	public CronTrigger getDayTrigger() {
		if(dayTrigger==null){
			dayTrigger =  new CronTrigger(triggerName,triggerGroup);
			try {
				CronExpression cexp = new CronExpression(triggerTime);
				dayTrigger.setCronExpression(cexp);
			} catch (ParseException e) {
				logger.fatal(triggerGroup+":"+triggerName+" init failed");
			}
		}
		return dayTrigger;
	}
	public void setDayTrigger(CronTrigger dayTrigger) {
		this.dayTrigger = dayTrigger;
	}
	public JobDetail getDayjobDetail() {
		if(dayjobDetail==null){
			dayjobDetail = new JobDetail(jobName,jobGroup,AnalysisJob.class);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("analysisGroup", analysisGroup);   
	        JobDataMap dateMap = new JobDataMap(map);   
	        dayjobDetail.setJobDataMap(dateMap);
		}
		return dayjobDetail;
	}
	public void setDayjobDetail(JobDetail dayjobDetail) {
		this.dayjobDetail = dayjobDetail;
	}
	
}
