package com.wangli.data.remain.processor;

import java.sql.SQLException;

import com.wangli.data.remain.RemainProcessor;
import com.wangli.data.remain.bean.Remain;
import com.wangli.data.remain.bean.RemainPage;
import com.wangli.data.remain.pageprocessor.SumAddRemainPageProcessor;

public class SumRemainProcessor implements RemainProcessor{

	@Override
	public int handleRemain(Remain remain) throws SQLException {
		RemainPage page = new SumAddRemainPageProcessor().handleRemain(remain);
		int addCount = page.getAddCount();
		remain.setBeginUid(page.getMinUid());
		remain.setEndUid(page.getMaxUid());
		int remainCount = new AddRemainProcessor().handleRemain(remain);
		remain.setRemainRate(remainCount/(double)addCount);
		return remainCount;
	}
	
}
