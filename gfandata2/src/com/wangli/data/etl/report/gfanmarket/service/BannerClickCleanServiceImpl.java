package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.wangli.data.etl.report.gfanmarket.constant.GfanMarketBehavior;
import com.wangli.data.etl.report.gfanmarket.dao.ClientEventLogDAO;
import com.wangli.data.etl.report.gfanmarket.dao.GfanClientEventClickDAO;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLog;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLogExample;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventClick;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventClickExample;

public class BannerClickCleanServiceImpl implements BannerClickCleanService {

	private ClientEventLogDAO clientEventLogDAO;
	
	private GfanClientEventClickDAO gfanClientEventClickDAO;
	
	private CommonService commonService;
	
	@Override
	public int getCount(String dateTime) throws SQLException {
		ClientEventLogExample example = new ClientEventLogExample();
		example.createCriteria().andVersionEqualTo("2").andDataTimeEqualTo(dateTime).andEventIdEqualTo("2202").andClientVersionIn(commonService.getStatisticsVersion());
		return clientEventLogDAO.countByExample(example);
	}

	@Override
	public void deleteRepeatDate(String dateTime,int behaviorId) throws SQLException {
		GfanClientEventClickExample example = new GfanClientEventClickExample();
		example.createCriteria().andDataTimeEqualTo(dateTime).andBehaviorIdEqualTo(behaviorId);
		gfanClientEventClickDAO.deleteByExample(example);
	}

	@Override
	public List<ClientEventLog> getEventList(String dateTime,int start, int length) throws SQLException {
		ClientEventLogExample example = new ClientEventLogExample();
		example.createCriteria().andVersionEqualTo("2").andDataTimeEqualTo(dateTime).andEventIdEqualTo("2202").andClientVersionIn(commonService.getStatisticsVersion());
		return clientEventLogDAO.selectByExampleWithBLOBs(example, start, length);
	}

	@Override
	public void insertBannerClick(List<GfanClientEventClick> list) throws SQLException {
		for(GfanClientEventClick record : list){
			gfanClientEventClickDAO.insert(record);
		}
	}

	public ClientEventLogDAO getClientEventLogDAO() {
		return clientEventLogDAO;
	}

	public void setClientEventLogDAO(ClientEventLogDAO clientEventLogDAO) {
		this.clientEventLogDAO = clientEventLogDAO;
	}

	public GfanClientEventClickDAO getGfanClientEventClickDAO() {
		return gfanClientEventClickDAO;
	}

	public void setGfanClientEventClickDAO(
			GfanClientEventClickDAO gfanClientEventClickDAO) {
		this.gfanClientEventClickDAO = gfanClientEventClickDAO;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	@Override
	public Integer checkBannerId(String productId,GfanMarketBehavior behavior,Date date) throws SQLException {
		return commonService.isBehavior(productId,behavior, date);
	}
	
}
