package com.wangli.data.gfan.analysis;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wangli.data.gfan.analysis.bean.DownLoad;
import com.wangli.data.gfan.analysis.dao.DownLoadDao;
import com.wangli.data.gfan.analysis.dao.QueryCount;
import com.wangli.data.gfan.analysis.parse.DownLoadParse;

public class DownClickAnalysis {

	private static Logger logger = Logger.getLogger(DownClickAnalysis.class);
	
	private String dataTime;

	public DownClickAnalysis(String dataTime) {
		this.dataTime = dataTime;
	}

	public String getDataTime() {
		return dataTime;
	}

	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	
	public void process(){
		DownLoadDao dao = new DownLoadDao();
		dao.deleteDownLoad(dataTime);
		int count = dao.getCount(dataTime);
		List<QueryCount> countlist = getDownLoadCount(count);
		for(QueryCount qCount : countlist){
			logger.info("date:"+dataTime+",range:("+qCount.getStartIndex()+","+qCount.getEndIndex()+")");
			List<DownLoad> list = dao.getDownLoad(dataTime,qCount.getStartIndex(),qCount.getEndIndex());
			list = new DownLoadParse().parseList(list);
			dao.insertDownLoad(list);
			logger.info("date:"+dataTime+",range:("+qCount.getStartIndex()+","+qCount.getEndIndex()+") finished");
		}
	}
	
	private List<QueryCount> getDownLoadCount(int count){
		List<QueryCount> list = new ArrayList<QueryCount>();
		if(QueryCount.length>=count){
			QueryCount qcount = new QueryCount(0,count);
			list.add(qcount);
		}else{
			int beginIndex = 0;
			do {
				QueryCount qcount = new QueryCount(beginIndex,QueryCount.length);
				list.add(qcount);
				beginIndex += QueryCount.length;
			} while (beginIndex < count);
		}
		return list;
	}
	
}
