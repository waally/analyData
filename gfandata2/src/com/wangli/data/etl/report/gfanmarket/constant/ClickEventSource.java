package com.wangli.data.etl.report.gfanmarket.constant;

public enum ClickEventSource {

	/**
	 * BANNER-精品推荐
	 */
	BANNERBOUTIQUE("1002",GfanMarketBehavior.BANNERBOUTIQUE),
	/**
	 * BANNER-今日热门
	 */
	BANNERHOT("1003",GfanMarketBehavior.BANNERHOT),
	/**
	 * BANNER-最新上架
	 */
	BANNERNEW("1004",GfanMarketBehavior.BANNERNEW),
	/**
	 * BANNER-电子书
	 */
	BANNERBOOK("14001",GfanMarketBehavior.BANNERBOOK),
	/**
	 * 推荐位-今日热门
	 */
	RECOMMENDHOT("1003",GfanMarketBehavior.RECOMMENDHOT),
	/**
	 * 推荐位-最新上架
	 */
	RECOMMENDNEW("1004",GfanMarketBehavior.RECOMMENDNEW),
	/**
	 * 推荐位-精品推荐
	 */
	RECOMMENDBOUTIQUE("1002",GfanMarketBehavior.RECOMMENDBOUTIQUE),
	/**
	 * 推荐位-热门应用
	 */
	RECOMMENDAPP("2005",GfanMarketBehavior.RECOMMENDAPP),
	/**
	 * 推荐位-热门游戏
	 */
	RECOMMENDGAME("3005",GfanMarketBehavior.RECOMMENDGAME),
	/**
	 * 运营位-精品-装机必备
	 */
	OPERATENECESSARY("1005",GfanMarketBehavior.OPERATENECESSARY),
	/**
	 * 运营位-游戏-推荐
	 */
	OPERATEGR("3002",GfanMarketBehavior.OPERATEGR),
	/**
	 * 运营位-游戏-汉化
	 */
	OPERATEGC("3003",GfanMarketBehavior.OPERATEGC),
	/**
	 * 运营位-游戏-大作
	 */
	OPERATEGL("3006",GfanMarketBehavior.OPERATEGL),
	/**
	 * 运营位-应用-推荐
	 */
	OPERATEAR("2002",GfanMarketBehavior.OPERATEAR),
	/**
	 * 运营位-应用-汉化
	 */
	OPERATEAC("2003",GfanMarketBehavior.OPERATEAC),
	/**
	 * 运营位-应用-锋神榜
	 */
	OPERATEABB("2006",GfanMarketBehavior.OPERATEABB),
	/**
	 * 运营位-专题
	 */
	OPERATETOPIC("4002",GfanMarketBehavior.OPERATETOPIC),
	/**
	 * 运营位-搜索-标签
	 */
	SEARCHTITLE("6001",GfanMarketBehavior.SEARCHTITLE),
	/**
	 * 特色-专题
	 */
	FEATURETOPIC("4001",GfanMarketBehavior.FEATURETOPIC);
	
	private String eventSource;
	
	private GfanMarketBehavior behavior;

	private ClickEventSource(String eventSource, GfanMarketBehavior behavior) {
		this.eventSource = eventSource;
		this.behavior = behavior;
	}

	public String getEventSource() {
		return eventSource;
	}

	public GfanMarketBehavior getBehavior() {
		return behavior;
	}
	
}
