package com.wangli.data.etl.report.gfanmarket.constant;

public enum DownLoadEventPath {

	/**
	 * BANNER-精品推荐
	 */
	BANNERBOUTIQUE("^7001,9002$",GfanMarketBehavior.BANNERBOUTIQUE),
	/**
	 * BANNER-今日热门
	 */
	BANNERHOT("^7001,9002$",GfanMarketBehavior.BANNERHOT),
	/**
	 * BANNER-最新上架
	 */
	BANNERNEW("^7001,9002$",GfanMarketBehavior.BANNERNEW),
	/**
	 * BANNER-电子书
	 */
	BANNERBOOK("^7001,9002$",GfanMarketBehavior.BANNERBOOK),
	/**
	 * 推荐位-今日热门
	 */
	RECOMMENDHOT("^1003(,9002)?$",GfanMarketBehavior.RECOMMENDHOT),
	/**
	 * 推荐位-最新上架
	 */
	RECOMMENDNEW("^1004(,9002)?$",GfanMarketBehavior.RECOMMENDNEW),
	/**
	 * 推荐位-精品推荐
	 */
	RECOMMENDBOUTIQUE("^1002(,9002)?$",GfanMarketBehavior.RECOMMENDBOUTIQUE),
	/**
	 * 推荐位-热门应用
	 */
	RECOMMENDAPP("^2005(,9002)?$",GfanMarketBehavior.RECOMMENDAPP),
	/**
	 * 推荐位-热门游戏
	 */
	RECOMMENDGAME("^3005(,9002)?$",GfanMarketBehavior.RECOMMENDGAME),
	/**
	 * 运营位-精品-装机必备
	 */
	OPERATENECESSARY("^1005(,9002)?$",GfanMarketBehavior.OPERATENECESSARY),
	/**
	 * 运营位-游戏-推荐
	 */
	OPERATEGR("^3002(,9002)?$",GfanMarketBehavior.OPERATEGR),
	/**
	 * 运营位-游戏-汉化
	 */
	OPERATEGC("^3003(,9002)?$",GfanMarketBehavior.OPERATEGC),
	/**
	 * 运营位-游戏-大作
	 */
	OPERATEGL("^3006(,9002)?$",GfanMarketBehavior.OPERATEGL),
	/**
	 * 运营位-应用-推荐
	 */
	OPERATEAR("^2002(,9002)?$",GfanMarketBehavior.OPERATEAR),
	/**
	 * 运营位-应用-汉化
	 */
	OPERATEAC("^2003(,9002)?$",GfanMarketBehavior.OPERATEAC),
	/**
	 * 运营位-应用-锋神榜
	 */
	OPERATEABB("^2006(,9002)?$",GfanMarketBehavior.OPERATEABB);
	
	private String path;
	
	private GfanMarketBehavior behavior;

	private DownLoadEventPath(String path, GfanMarketBehavior behavior) {
		this.path = path;
		this.behavior = behavior;
	}

	public String getPath() {
		return path;
	}

	public GfanMarketBehavior getBehavior() {
		return behavior;
	}
	
}
