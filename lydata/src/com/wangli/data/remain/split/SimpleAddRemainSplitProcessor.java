package com.wangli.data.remain.split;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangli.data.datasource.ConnectionUtil;
import com.wangli.data.remain.RemainConstant;
import com.wangli.data.remain.RemainSplitProcessor;
import com.wangli.data.remain.RemainUtil;
import com.wangli.data.remain.bean.Remain;
import com.wangli.data.remain.bean.RemainPage;
import com.wangli.data.util.DateUtil;

public class SimpleAddRemainSplitProcessor implements RemainSplitProcessor{

	private int addCount;
	
	@Override
	public Remain[] handlePageRemain(Remain remain, RemainPage page) throws SQLException {
		List<Remain> remains = new ArrayList<Remain>();
		addCount = page.getAddCount();
		int length = (int) ((addCount+RemainConstant.MAXLENGTH-1)/RemainConstant.MAXLENGTH);
		for(int i=0;i<length;i++){
			if(addCount>RemainConstant.MAXLENGTH*(i+1)){
				remains.add(getRemain(remain, RemainConstant.MAXLENGTH*i, RemainConstant.MAXLENGTH));
			}else{
				remains.add((getRemain(remain, RemainConstant.MAXLENGTH*i, addCount-RemainConstant.MAXLENGTH*i)));
			}
		}
		return remains.toArray(new Remain[remains.size()]);
	}
	
	private Remain getRemain(Remain remain,int start,int end) throws SQLException{
		Connection conn = ConnectionUtil.getConn();
		String sql = "select min(UID) min,max(UID) max from (select DISTINCT UID from "+RemainUtil.getGameActiveTableName(DateUtil.getFormString(remain.getAddBeginTime()))+" t where t.LOG_TIME >='"+remain.getAddBeginTime()+"' and t.LOG_TIME<'"+remain.getAddEndTIme()+"' AND t.UID >= "+remain.getBeginUid()+" AND t.UID<="+remain.getEndUid()+" AND t.ACTIVE_TYPE = 1 and APP_KEY ="+remain.getAppKey()+" order by uid limit "+start+","+end+")t1";
		PreparedStatement stmt2 = conn.prepareStatement(sql);
		ResultSet result = stmt2.executeQuery();
		Remain temp = new Remain();
		while(result.next()){
			temp.setActiveBeginTime(remain.getActiveBeginTime());
			temp.setActiveEndTime(remain.getActiveEndTime());
			temp.setAddBeginTime(remain.getAddBeginTime());
			temp.setAddEndTIme(remain.getAddEndTIme());
			temp.setAppKey(remain.getAppKey());
			temp.setBeginUid(result.getInt("min"));
			temp.setEndUid(result.getInt("max"));
		}
		result.close();
		stmt2.close();
		conn.close();
		return temp;
	}

}
