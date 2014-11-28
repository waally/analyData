package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wangli.data.etl.report.gfanmarket.dao.GfanCfgRankProductDAO;
import com.wangli.data.etl.report.gfanmarket.dao.GfanCodeBannerDAO;
import com.wangli.data.etl.report.gfanmarket.dao.StatVersionDAO;
import com.wangli.data.etl.report.gfanmarket.module.GfanCfgRankProduct;
import com.wangli.data.etl.report.gfanmarket.module.GfanCfgRankProductExample;
import com.wangli.data.etl.report.gfanmarket.module.GfanCodeBanner;
import com.wangli.data.etl.report.gfanmarket.module.GfanCodeBannerExample;
import com.wangli.data.etl.report.gfanmarket.module.StatVersion;
import com.wangli.data.etl.report.gfanmarket.module.StatVersionExample;
import com.wangli.data.util.DateUtil;

public class CommonServiceImpl implements CommonService {

	private StatVersionDAO statVersionDAO;
	
	private GfanCfgRankProductDAO gfanCfgRankProductDAO;
	
	private GfanCodeBannerDAO gfanCodeBannerDAO;
	
	private Date cfgDate;
	
	private Map<Integer,Set<String>> recommendCache = new HashMap<Integer,Set<String>>();
	
	@Override
	public List<String> getStatisticsVersion() throws SQLException {
		StatVersionExample example = new StatVersionExample();
		example.createCriteria().andFlagEqualTo(true);
		List<StatVersion> list = statVersionDAO.selectByExample(example);
		List<String> ss = new ArrayList<String>();
		for(int i = 0;i<list.size();i++){
			ss.add(list.get(i).getVersionCode());
		}
		return ss;
	}

	@Override
	public boolean isRecommend(String productId, int page, Date date) throws SQLException {
		if(cfgDate==null||!cfgDate.equals(date)){
			recommendCache.clear();
			cfgDate = date;
		}
		Set<String> set = recommendCache.get(page);
		if(set==null){
			set = new HashSet<String>();
			if(page==0){
				GfanCodeBannerExample example = new GfanCodeBannerExample();
				example.createCriteria().andBeginTimeLessThanOrEqualTo(date).andEndTimeGreaterThanOrEqualTo(DateUtil.getLastTimeOfDate(date));
				List<GfanCodeBanner> list = gfanCodeBannerDAO.selectByExample(example);
				for(GfanCodeBanner banner : list){
					set.add(banner.getContentId());
				}
			}else{
				GfanCfgRankProductExample example = new GfanCfgRankProductExample();
				example.createCriteria().andPageIdEqualTo(page).andBeginTimeLessThanOrEqualTo(date).andEndTimeGreaterThanOrEqualTo(DateUtil.getLastTimeOfDate(date));
				List<GfanCfgRankProduct> list = gfanCfgRankProductDAO.selectByExample(example);
				for(GfanCfgRankProduct product : list){
					set.add(Integer.toString(product.getProductId()));
				}
			}
			recommendCache.put(page, set);
		}
		if(set.contains(productId)){
			return true;
		}
		return false;
	}
	
	public StatVersionDAO getStatVersionDAO() {
		return statVersionDAO;
	}

	public void setStatVersionDAO(StatVersionDAO statVersionDAO) {
		this.statVersionDAO = statVersionDAO;
	}

	public GfanCfgRankProductDAO getGfanCfgRankProductDAO() {
		return gfanCfgRankProductDAO;
	}

	public void setGfanCfgRankProductDAO(GfanCfgRankProductDAO gfanCfgRankProductDAO) {
		this.gfanCfgRankProductDAO = gfanCfgRankProductDAO;
	}

	public GfanCodeBannerDAO getGfanCodeBannerDAO() {
		return gfanCodeBannerDAO;
	}

	public void setGfanCodeBannerDAO(GfanCodeBannerDAO gfanCodeBannerDAO) {
		this.gfanCodeBannerDAO = gfanCodeBannerDAO;
	}
	
}
