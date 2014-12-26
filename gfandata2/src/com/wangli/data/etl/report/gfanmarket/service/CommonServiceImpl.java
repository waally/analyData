package com.wangli.data.etl.report.gfanmarket.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wangli.data.etl.report.gfanmarket.constant.GfanMarketBehavior;
import com.wangli.data.etl.report.gfanmarket.constant.GfanMarketBehaviorType;
import com.wangli.data.etl.report.gfanmarket.dao.GfanCfgContentDAO;
import com.wangli.data.etl.report.gfanmarket.dao.GfanCfgContentGroupDAO;
import com.wangli.data.etl.report.gfanmarket.dao.GfanCfgRankProductDAO;
import com.wangli.data.etl.report.gfanmarket.dao.GfanCodeBannerDAO;
import com.wangli.data.etl.report.gfanmarket.dao.SearchHotwordsLogDAO;
import com.wangli.data.etl.report.gfanmarket.dao.StatVersionDAO;
import com.wangli.data.etl.report.gfanmarket.module.GfanCfgContent;
import com.wangli.data.etl.report.gfanmarket.module.GfanCfgContentExample;
import com.wangli.data.etl.report.gfanmarket.module.GfanCfgContentGroup;
import com.wangli.data.etl.report.gfanmarket.module.GfanCfgContentGroupExample;
import com.wangli.data.etl.report.gfanmarket.module.GfanCfgRankProduct;
import com.wangli.data.etl.report.gfanmarket.module.GfanCfgRankProductExample;
import com.wangli.data.etl.report.gfanmarket.module.GfanCodeBanner;
import com.wangli.data.etl.report.gfanmarket.module.GfanCodeBannerExample;
import com.wangli.data.etl.report.gfanmarket.module.SearchHotwordsLog;
import com.wangli.data.etl.report.gfanmarket.module.SearchHotwordsLogExample;
import com.wangli.data.etl.report.gfanmarket.module.StatVersion;
import com.wangli.data.etl.report.gfanmarket.module.StatVersionExample;
import com.wangli.data.util.DateUtil;

public class CommonServiceImpl implements CommonService {

	private StatVersionDAO statVersionDAO;
	
	private GfanCfgRankProductDAO gfanCfgRankProductDAO;
	
	private GfanCodeBannerDAO gfanCodeBannerDAO;
	
	private GfanCfgContentGroupDAO gfanCfgContentGroupDAO;
	
	private GfanCfgContentDAO gfanCfgContentDAO;
	
	private SearchHotwordsLogDAO searchHotwordsLogDAO;
	
	private Date cfgDate;
	
	private Map<GfanMarketBehavior,Map<String,Integer>> recommendCache = new HashMap<GfanMarketBehavior,Map<String,Integer>>();
	
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
	public Integer isBehavior(String productId, GfanMarketBehavior behavior, Date date) throws SQLException {
		if(cfgDate==null||!cfgDate.equals(date)){
			recommendCache.clear();
			cfgDate = date;
		}
		Map<String,Integer> set = recommendCache.get(behavior);
		if(set==null){
			if(behavior.getType()==GfanMarketBehaviorType.BANNER){
				set = getBannerProductId(behavior.getSign().getSign(), date);
			}else if(behavior.getType()==GfanMarketBehaviorType.RECOMMEND){
				set = getRecommendProductId(behavior.getSign().getSign(), date);
			}else if(behavior.getType()==GfanMarketBehaviorType.OPERATELIMIT){
				set = getOperateProductIdLimit(behavior.getSign().getSign(), date);
			}else if(behavior.getType()==GfanMarketBehaviorType.OPERATEALL){
				set = getOperateProductIdAll(behavior.getSign().getSign(), date);
			}else if(behavior.getType()==GfanMarketBehaviorType.SEARCH){
				set = getSerachHotWords(date);
			}else if(behavior.getType()==GfanMarketBehaviorType.FEATURETOPIC){
				set = getOperateGroupIdAll(behavior.getSign().getSign(),date);
			}
			recommendCache.put(behavior, set);
		}
		return set.get(productId);
	}
	
	private Map<String,Integer> getBannerProductId(String sign,Date date) throws SQLException{
		Map<String,Integer> set = new HashMap<String,Integer>();
		GfanCodeBannerExample example = new GfanCodeBannerExample();
		example.createCriteria().andBannerCodeEqualTo(sign).andBeginTimeLessThanOrEqualTo(date).andEndTimeGreaterThanOrEqualTo(DateUtil.getLastTimeOfDate(date));
		List<GfanCodeBanner> list = gfanCodeBannerDAO.selectByExample(example);
		for(GfanCodeBanner banner : list){
			set.put(banner.getContentId(), banner.getBannerId());
		}
		return set;
	}
	
	private  Map<String,Integer> getOperateProductIdLimit(String sign,Date date) throws SQLException{
		Map<String,Integer> set = new HashMap<String,Integer>();
		GfanCfgContentGroupExample example = new GfanCfgContentGroupExample();
		example.createCriteria().andPublishTimeLessThanOrEqualTo(date).andCodeEqualTo(sign).andStatusEqualTo(1);
		example.setOrderByClause("publish_time desc");
		List<GfanCfgContentGroup> list = gfanCfgContentGroupDAO.selectByExample(example);
		for(GfanCfgContentGroup group:list){
			GfanCfgContentExample example2 = new GfanCfgContentExample();
			example2.createCriteria().andGroupIdEqualTo(group.getId()).andStatusEqualTo(1);
			List<GfanCfgContent> contents = gfanCfgContentDAO.selectByExample(example2);
			for(GfanCfgContent content : contents){
				set.put(content.getContentId(), content.getId());
				if(content.getContentIdExtra()!=null&&!content.getContentIdExtra().equals("")){
					set.put(content.getContentIdExtra(), content.getId());
				}
			}
			if(set.size()>=60){
				return set;
			}
		}
		return set;
	}
	
	private  Map<String,Integer> getOperateProductIdAll(String sign,Date date) throws SQLException{
		Map<String,Integer> set = new HashMap<String,Integer>();
		GfanCfgContentGroupExample example = new GfanCfgContentGroupExample();
		example.createCriteria().andPublishTimeLessThanOrEqualTo(date).andCodeEqualTo(sign).andStatusEqualTo(1);
		List<GfanCfgContentGroup> list = gfanCfgContentGroupDAO.selectByExample(example);
		for(GfanCfgContentGroup group:list){
			GfanCfgContentExample example2 = new GfanCfgContentExample();
			example2.createCriteria().andGroupIdEqualTo(group.getId()).andStatusEqualTo(1);
			List<GfanCfgContent> contents = gfanCfgContentDAO.selectByExample(example2);
			for(GfanCfgContent content : contents){
				set.put(content.getContentId(), content.getId());
				if(content.getContentIdExtra()!=null&&!content.getContentIdExtra().equals("")){
					set.put(content.getContentIdExtra(), content.getId());
				}
			}
		}
		return set;
	}
	
	private  Map<String,Integer> getOperateGroupIdAll(String sign,Date date) throws SQLException{
		Map<String,Integer> set = new HashMap<String,Integer>();
		GfanCfgContentGroupExample example = new GfanCfgContentGroupExample();
		example.createCriteria().andPublishTimeLessThanOrEqualTo(date).andCodeEqualTo(sign).andStatusEqualTo(1);
		List<GfanCfgContentGroup> list = gfanCfgContentGroupDAO.selectByExample(example);
		for(GfanCfgContentGroup group:list){
			set.put(Integer.toString(group.getId()),group.getId());
		}
		return set;
	}
	
	
	private Map<String,Integer> getRecommendProductId(String sign,Date date) throws SQLException{
		Map<String,Integer> set = new HashMap<String,Integer>();
		GfanCfgRankProductExample example = new GfanCfgRankProductExample();
		example.createCriteria().andPageIdEqualTo(Integer.parseInt(sign)).andBeginTimeLessThanOrEqualTo(date).andEndTimeGreaterThanOrEqualTo(DateUtil.getLastTimeOfDate(date));
		List<GfanCfgRankProduct> list = gfanCfgRankProductDAO.selectByExample(example);
		for(GfanCfgRankProduct product : list){
			set.put(Integer.toString(product.getProductId()), product.getId());
		}
		return set;
	}
	
	private Map<String,Integer> getSerachHotWords(Date date) throws SQLException{
		String dateStr = DateUtil.getFormDate(date);
		Map<String,Integer> set = new HashMap<String,Integer>();
		SearchHotwordsLogExample example = new SearchHotwordsLogExample();
		example.createCriteria().andDataTimeEqualTo(dateStr);
		List<SearchHotwordsLog> list = searchHotwordsLogDAO.selectByExample(example);
		for(SearchHotwordsLog hotword : list){
			set.put(hotword.getHotwords(), hotword.getId());
		}
		return set;
	}
	
	@Override
	public void generateHotWords() throws SQLException {
		String dateStr = DateUtil.getFormDate(DateUtil.getLastDate(0));
		SearchHotwordsLogExample example = new SearchHotwordsLogExample();
		example.createCriteria().andDataTimeEqualTo(dateStr);
		List<SearchHotwordsLog> list = searchHotwordsLogDAO.selectByExample(example);
		if(list.size()==0){
			Map<Integer,SearchHotwordsLog> hotwords = new HashMap<Integer,SearchHotwordsLog>();
			List<SearchHotwordsLog> allList = searchHotwordsLogDAO.selectHotWordsAllByExample(example);
			List<SearchHotwordsLog> allReplace = searchHotwordsLogDAO.selectHotWordsReplaceByExample(example);
			for(int i=0;i<allList.size();i++){
				SearchHotwordsLog hotword = allList.get(i);
				hotword.setRank(i+1);
				hotword.setDataTime(dateStr);
				hotword.setInsertTime(new Date());
				hotwords.put(hotword.getRank(), hotword);
			}
			for(SearchHotwordsLog hotword :allReplace){
				SearchHotwordsLog temp = hotwords.get(hotword.getRank());
				temp.setHotwords(hotword.getHotwords());
				hotwords.put(hotword.getRank(), temp);
			}
			for(SearchHotwordsLog hotword : hotwords.values()){
				searchHotwordsLogDAO.insert(hotword);
			}
		}
		
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

	public GfanCfgContentGroupDAO getGfanCfgContentGroupDAO() {
		return gfanCfgContentGroupDAO;
	}

	public void setGfanCfgContentGroupDAO(
			GfanCfgContentGroupDAO gfanCfgContentGroupDAO) {
		this.gfanCfgContentGroupDAO = gfanCfgContentGroupDAO;
	}

	public GfanCfgContentDAO getGfanCfgContentDAO() {
		return gfanCfgContentDAO;
	}

	public void setGfanCfgContentDAO(GfanCfgContentDAO gfanCfgContentDAO) {
		this.gfanCfgContentDAO = gfanCfgContentDAO;
	}

	public SearchHotwordsLogDAO getSearchHotwordsLogDAO() {
		return searchHotwordsLogDAO;
	}

	public void setSearchHotwordsLogDAO(SearchHotwordsLogDAO searchHotwordsLogDAO) {
		this.searchHotwordsLogDAO = searchHotwordsLogDAO;
	}

}
