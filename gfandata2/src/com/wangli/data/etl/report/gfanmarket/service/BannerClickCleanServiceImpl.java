package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.wangli.data.etl.report.gfanmarket.dao.ClientEventLogDAO;
import com.wangli.data.etl.report.gfanmarket.dao.GfanClientEventBannerclickDAO;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLog;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLogExample;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventBannerclick;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventBannerclickExample;

public class BannerClickCleanServiceImpl implements BannerClickCleanService {

	private ClientEventLogDAO clientEventLogDAO;
	
	private GfanClientEventBannerclickDAO gfanClientEventBannerclickDAO;
	
	private CommonService commonService;
	
	@Override
	public int getCount(String dateTime) throws SQLException {
		ClientEventLogExample example = new ClientEventLogExample();
		example.createCriteria().andVersionEqualTo("2").andDataTimeEqualTo(dateTime).andEventIdEqualTo("2202").andClientVersionIn(commonService.getStatisticsVersion());
		return clientEventLogDAO.countByExample(example);
	}

	@Override
	public void deleteRepeatDate(String dateTime) throws SQLException {
		GfanClientEventBannerclickExample example = new GfanClientEventBannerclickExample();
		example.createCriteria().andDataTimeEqualTo(dateTime).andBannerIdEqualTo(100000);
		gfanClientEventBannerclickDAO.deleteByExample(example);
	}

	@Override
	public List<ClientEventLog> getEventList(String dateTime,int start, int length) throws SQLException {
		ClientEventLogExample example = new ClientEventLogExample();
		example.createCriteria().andVersionEqualTo("2").andDataTimeEqualTo(dateTime).andEventIdEqualTo("2202").andClientVersionIn(commonService.getStatisticsVersion());
		return clientEventLogDAO.selectByExampleWithBLOBs(example, start, length);
	}

	@Override
	public void insertBannerClick(List<GfanClientEventBannerclick> list) throws SQLException {
		for(GfanClientEventBannerclick record : list){
			gfanClientEventBannerclickDAO.insert(record);
		}
	}

	public ClientEventLogDAO getClientEventLogDAO() {
		return clientEventLogDAO;
	}

	public void setClientEventLogDAO(ClientEventLogDAO clientEventLogDAO) {
		this.clientEventLogDAO = clientEventLogDAO;
	}

	public GfanClientEventBannerclickDAO getGfanClientEventBannerclickDAO() {
		return gfanClientEventBannerclickDAO;
	}

	public void setGfanClientEventBannerclickDAO(
			GfanClientEventBannerclickDAO gfanClientEventBannerclickDAO) {
		this.gfanClientEventBannerclickDAO = gfanClientEventBannerclickDAO;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	@Override
	public GfanClientEventBannerclick checkBannerId(GfanClientEventBannerclick banner, Date date) throws SQLException {
		if(commonService.isRecommend(banner.getPid(), 0, date)){
			return banner;
		}
		return null;
	}
	
}
