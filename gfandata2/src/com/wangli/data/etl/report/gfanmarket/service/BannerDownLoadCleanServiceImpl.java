package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wangli.data.etl.report.gfanmarket.constant.GfanMarketBehavior;
import com.wangli.data.etl.report.gfanmarket.dao.ClientEventLogDAO;
import com.wangli.data.etl.report.gfanmarket.dao.GfanClientEventDownloadDAO;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLog;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLogExample;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventDownload;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventDownloadExample;

public class BannerDownLoadCleanServiceImpl implements BannerDownLoadCleanService {

	private ClientEventLogDAO clientEventLogDAO;
	
	private GfanClientEventDownloadDAO gfanClientEventDownloadDAO;
	
	private CommonService commonService;
	
	@Override
	public int getCount(String dateTime) throws SQLException {
		ClientEventLogExample example = new ClientEventLogExample();
		example.createCriteria().andVersionEqualTo("2").andDataTimeEqualTo(dateTime).andEventIdEqualTo("2102").andClientVersionIn(commonService.getStatisticsVersion());
		return clientEventLogDAO.countByExample(example);
	}

	@Override
	public void deleteRepeatDate(String dateTime,int behaviorId) throws SQLException {
		GfanClientEventDownloadExample example = new GfanClientEventDownloadExample();
		example.createCriteria().andDataTimeEqualTo(dateTime).andBehaviorIdEqualTo(behaviorId);
		gfanClientEventDownloadDAO.deleteByExample(example);
	}

	@Override
	public List<ClientEventLog> getEventList(String dateTime, int start,int length) throws SQLException {
		ClientEventLogExample example = new ClientEventLogExample();
		example.createCriteria().andVersionEqualTo("2").andDataTimeEqualTo(dateTime).andEventIdEqualTo("2102").andClientVersionIn(commonService.getStatisticsVersion());
		return clientEventLogDAO.selectByExampleWithBLOBs(example, start, length);
	}

	@Override
	public void insertBannerClick(List<GfanClientEventDownload> list)
			throws SQLException {
		for(GfanClientEventDownload record : list){
			gfanClientEventDownloadDAO.insert(record);
		}
	}

	@Override
	public Integer checkBannerId(String productId,GfanMarketBehavior behavior,Date date) throws SQLException{
		return commonService.isBehavior(productId,behavior, date);
	}
	
	public ClientEventLogDAO getClientEventLogDAO() {
		return clientEventLogDAO;
	}

	public void setClientEventLogDAO(ClientEventLogDAO clientEventLogDAO) {
		this.clientEventLogDAO = clientEventLogDAO;
	}

	public GfanClientEventDownloadDAO getGfanClientEventDownloadDAO() {
		return gfanClientEventDownloadDAO;
	}

	public void setGfanClientEventDownloadDAO(
			GfanClientEventDownloadDAO gfanClientEventDownloadDAO) {
		this.gfanClientEventDownloadDAO = gfanClientEventDownloadDAO;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
}
