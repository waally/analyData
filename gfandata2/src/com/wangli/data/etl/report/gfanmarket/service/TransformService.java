package com.wangli.data.etl.report.gfanmarket.service;

public interface TransformService {

	void transformData(String source,String target,String tableName,int fieldCount);
	
}
