package com.wangli.data.remain.pageprocessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangli.data.datasource.ConnectionUtil;
import com.wangli.data.remain.RemainPageProcessor;
import com.wangli.data.remain.RemainUtil;
import com.wangli.data.remain.bean.Remain;
import com.wangli.data.remain.bean.RemainPage;
import com.wangli.data.util.DateUtil;

public class SumAddRemainPageProcessor implements RemainPageProcessor{
	
	private RemainPage page=new RemainPage();
	
	@Override
	public RemainPage handleRemain(Remain remain) throws SQLException {
		Connection conn = ConnectionUtil.getConn();
		String sql = "select min(UID) min,max(UID) max,count(DISTINCT UID) count from "+RemainUtil.getGameActiveTableName(DateUtil.getFormString(remain.getAddBeginTime()))+" t where t.LOG_TIME >='"+remain.getAddBeginTime()+"' and t.LOG_TIME<'"+remain.getAddEndTIme()+"' AND t.ACTIVE_TYPE = 1 and PRODUCT_ID ="+remain.getAppKey();
		PreparedStatement stmt2 = conn.prepareStatement(sql);
		ResultSet result = stmt2.executeQuery();
		while(result.next()){
			page.setMinUid(result.getInt("min"));
			page.setMaxUid(result.getInt("max"));
			page.setAddCount(result.getInt("count"));
		}
		result.close();
		stmt2.close();
		conn.close();
		return page;
	}

}
