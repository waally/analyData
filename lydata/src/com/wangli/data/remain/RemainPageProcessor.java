package com.wangli.data.remain;

import java.sql.SQLException;

import com.wangli.data.remain.bean.Remain;
import com.wangli.data.remain.bean.RemainPage;

public interface RemainPageProcessor {

	RemainPage handleRemain(Remain remain) throws SQLException;
}
