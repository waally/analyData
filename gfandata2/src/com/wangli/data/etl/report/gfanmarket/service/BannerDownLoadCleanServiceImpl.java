package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.wangli.data.etl.report.gfanmarket.dao.ClientEventLogDAO;
import com.wangli.data.etl.report.gfanmarket.dao.GfanClientEventDownloadDAO;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLog;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLogExample;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventBannerclickExample;
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
	public void deleteRepeatDate(String dateTime) throws SQLException {
		GfanClientEventDownloadExample example = new GfanClientEventDownloadExample();
		example.createCriteria().andDataTimeEqualTo(dateTime);
		gfanClientEventDownloadDAO.deleteByExample(example);
	}

	@Override
	public List<ClientEventLog> getEventList(String dateTime, int start,
			int length) throws SQLException {
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
	public GfanClientEventDownload markBehaviorId(GfanClientEventDownload downLoad,Date date) throws SQLException {
		if(downLoad.getPath().matches("^7001,9002$")){
			if(commonService.isRecommend(downLoad.getPid(), 0, date)){
				downLoad.setBehaviorId(100000);
				return downLoad;
			}
		}else if(downLoad.getPath().matches("^1003(,9002)?$")){
			if(commonService.isRecommend(downLoad.getPid(), 1, date)){
				downLoad.setBehaviorId(100001);
				return downLoad;
			}
		}else if(downLoad.getPath().matches("^1004(,9002)?$")){
			if(commonService.isRecommend(downLoad.getPid(), 2, date)){
				downLoad.setBehaviorId(100002);
				return downLoad;
			}
		}else if(downLoad.getPath().matches("^2005(,9002)?$")){
			if(commonService.isRecommend(downLoad.getPid(), 3, date)){
				downLoad.setBehaviorId(100003);
				return downLoad;
			}
		}else if(downLoad.getPath().matches("^3005(,9002)?$")){
			if(commonService.isRecommend(downLoad.getPid(), 4, date)){
				downLoad.setBehaviorId(100004);
				return downLoad;
			}
		}else if(downLoad.getPath().matches("^1002(,9002)?$")){
			if(commonService.isRecommend(downLoad.getPid(), 5, date)){
				downLoad.setBehaviorId(100005);
				return downLoad;
			}
		}
		return null;
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
