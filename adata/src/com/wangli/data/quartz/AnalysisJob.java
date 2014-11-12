package com.wangli.data.quartz;

import java.sql.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.wangli.data.analysis.DataAnalysis;
import com.wangli.data.util.DateUtil;
/**
 * 存储过程的定时任务
 * @ClassName StoredProcedureJob
 * @Description 描述
 * @author wangli
 * @date 2014-8-4 下午6:33:27
 */
public class AnalysisJob implements Job{

	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context)throws JobExecutionException {
		List<DataAnalysis> calls = (List<DataAnalysis>) context.getJobDetail().getJobDataMap().get("analysisNames");
		for(DataAnalysis call :calls){
			Date date = DateUtil.getLastDate(-1);
			call.setDate(date);
			call.processAnalysis();
		}
	}

}
