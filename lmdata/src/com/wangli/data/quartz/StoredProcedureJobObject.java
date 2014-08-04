package com.wangli.data.quartz;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;

import com.wangli.data.sprocedure.Call;

public class StoredProcedureJobObject {

	private static Logger logger = Logger.getLogger(StoredProcedureJobObject.class);
	
	private String jobName;
	
	private String jobGroup;
	
	private String triggerName;
	
	private String triggerGroup;
	
	private String triggerTime;
	
	private List<Call> calls = new ArrayList<Call>();
	
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
	
	public List<Call> getCalls() {
		return calls;
	}
	public void setCalls(List<Call> calls) {
		this.calls = calls;
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
			dayjobDetail = new JobDetail("dayjob","analysis",StoredProcedureJob.class);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("callNames", calls);   
	        JobDataMap dateMap = new JobDataMap(map);   
	        dayjobDetail.setJobDataMap(dateMap);
		}
		return dayjobDetail;
	}
	public void setDayjobDetail(JobDetail dayjobDetail) {
		this.dayjobDetail = dayjobDetail;
	}
	
}
