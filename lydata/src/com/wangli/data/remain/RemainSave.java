package com.wangli.data.remain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.wangli.data.datasource.ConnectionUtil;
import com.wangli.data.remain.bean.Remain;

public class RemainSave {

	public void saveRemain(Remain remain) throws SQLException{
		deleteRemain(remain);
		Connection conn = ConnectionUtil.getConn();
		String sql = "insert into REP_REMAIN_RATE(DATA_TIME,GAME_ID,REMAIN_DATE,REMAIN_RATE,INSERT_TIME) values(?,?,?,?,?)";
		PreparedStatement stmt2 = conn.prepareStatement(sql);
		stmt2.setString(1,remain.getAddBeginTime());
		stmt2.setInt(2,remain.getAppKey());
		stmt2.setInt(3,remain.getDay());
		stmt2.setDouble(4,remain.getRemainRate()*100);
		stmt2.setTimestamp(5,new Timestamp(new Date().getTime()));
		stmt2.execute();
		stmt2.close();
		conn.close();
	}
	
	private void deleteRemain(Remain remain) throws SQLException{
		Connection conn = ConnectionUtil.getConn();
		String sql = "delete from REP_REMAIN_RATE where DATA_TIME = ? and REMAIN_DATE = ? and GAME_ID = ?";
		PreparedStatement stmt2 = conn.prepareStatement(sql);
		stmt2.setString(1,remain.getAddBeginTime());
		stmt2.setInt(2,remain.getDay());
		stmt2.setInt(3,remain.getAppKey());
		stmt2.execute();
		stmt2.close();
		conn.close();
	}
}
