package com.wangli.data.quartz;

import java.sql.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.wangli.data.service.AnalysisService;
import com.wangli.data.sprocedure.Call;
import com.wangli.data.sprocedure.CallType;
import com.wangli.data.util.DateUtil;
/**
 * 存储过程的定时任务
 * @ClassName StoredProcedureJob
 * @Description 描述
 * @author wangli
 * @date 2014-8-4 下午6:33:27
 */
public class StoredProcedureJob implements Job{

	@SuppressWarnings("unchecked")
	@Override
	public void execute(JobExecutionContext context)throws JobExecutionException {
		List<Call> calls = (List<Call>) context.getJobDetail().getJobDataMap().get("callNames");
		for(Call call :calls){
			Date date = DateUtil.getLastDate(-1);
			if(call.getCallType()==CallType.MONTH&&DateUtil.isLastMonthDay(date)){
				AnalysisService.instance.analysisData(call.getCallName(),date);
			}else if(call.getCallType()==CallType.WEEK&&DateUtil.isLastWeekDay(date)){
				AnalysisService.instance.analysisData(call.getCallName(),date);
			}else if(call.getCallType()==CallType.DAY){
				AnalysisService.instance.analysisData(call.getCallName(),date);
			}
		}
	}

}
