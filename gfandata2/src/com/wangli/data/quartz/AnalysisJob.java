package com.wangli.data.quartz;

import java.sql.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.wangli.data.util.DateUtil;
/**
 * 存储过程的定时任务
 * @ClassName StoredProcedureJob
 * @Description 描述
 * @author wangli
 * @date 2014-8-4 下午6:33:27
 */
public class AnalysisJob implements Job{

	@Override
	public void execute(JobExecutionContext context)throws JobExecutionException {
		AnalysisGroup analysisGroup = (AnalysisGroup) context.getJobDetail().getJobDataMap().get("analysisGroup");
		Date date = DateUtil.getLastDate(-1);
		analysisGroup.process(date);
	}

}
