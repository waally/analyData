package com.wangli.data.quartz;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wangli.data.inter.DataHandler;
/**
 * 数据处理器组
 * @ClassName AnalysisGroup
 * @Description 描述
 * @author wangli
 * @date 2014-11-26 下午3:35:13
 */
public class AnalysisGroup {

	/**
	 * 数据处理器组的名称
	 */
	private String groupName;
	/**
	 * 数据处理器组所包含的数据处理器
	 */
	private List<DataHandler> datahandlers = new ArrayList<DataHandler>();
	
	private static Logger logger = Logger.getLogger(AnalysisGroup.class);

	public DataHandler getHandler(String name){
		for(DataHandler handler : datahandlers){
			if(handler.getName().equals(name)){
				return handler;
			}
		}
		return null;
	}
	
	public void process(Date date){
		for(DataHandler handler : datahandlers){
			logger.info("MDATA DataHandler "+handler.getName()+" "+date);
			handler.setDate(date);
			handler.processAnalysis();
			logger.info("MDATA DataHandler "+handler.getName()+" "+date+" successful");
		}
	}
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<DataHandler> getDatahandlers() {
		return datahandlers;
	}

	public void setDatahandlers(List<DataHandler> datahandlers) {
		this.datahandlers = datahandlers;
	}
	
}
