package com.wangli.data.remain;

import java.sql.SQLException;

import com.wangli.data.remain.bean.Remain;

public interface RemainProcessor {

	int handleRemain(Remain remain) throws SQLException;
	
}
