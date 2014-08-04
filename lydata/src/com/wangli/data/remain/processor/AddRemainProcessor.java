package com.wangli.data.remain.processor;

import java.sql.SQLException;

import com.wangli.data.remain.RemainConstant;
import com.wangli.data.remain.RemainProcessor;
import com.wangli.data.remain.bean.Remain;
import com.wangli.data.remain.bean.RemainPage;
import com.wangli.data.remain.pageprocessor.SimpleAddRemainPageProcessor;
import com.wangli.data.remain.split.SimpleAddRemainSplitProcessor;

public class AddRemainProcessor implements RemainProcessor{

	@Override
	public int handleRemain(Remain remain) throws SQLException {
		int remainSum = 0;
		RemainPage page = new SimpleAddRemainPageProcessor().handleRemain(remain);
		if(page.getAddCount()>RemainConstant.MAXLENGTH){
			Remain[] remains = new SimpleAddRemainSplitProcessor().handlePageRemain(remain, page);
			for(Remain temp:remains){
				remainSum +=new SimpleRemainProcessor().handleRemain(temp);
			}
		}else{
			remainSum = new SimpleRemainProcessor().handleRemain(remain);
		}
		return remainSum;
	}

}
