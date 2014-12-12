package com.wangli.data.etl.report.gfanmarket.constant;

public enum GfanMarketBehavior {
	/**
	 * BANNER-精品推荐
	 */
	BANNERBOUTIQUE(101000,GfanMarketBehaviorType.BANNER,BehaviorSign.BANNERBOUTIQUE),
	/**
	 * BANNER-今日热门
	 */
	BANNERHOT(101001,GfanMarketBehaviorType.BANNER,BehaviorSign.BANNERHOT),
	/**
	 * BANNER-最新上架
	 */
	BANNERNEW(101002,GfanMarketBehaviorType.BANNER,BehaviorSign.BANNERNEW),
	/**
	 * BANNER-电子书
	 */
	BANNERBOOK(101003,GfanMarketBehaviorType.BANNER,BehaviorSign.BANNERBOOK),
	/**
	 * 推荐位-今日热门
	 */
	RECOMMENDHOT(102000,GfanMarketBehaviorType.RECOMMEND,BehaviorSign.RECOMMENDHOT),
	/**
	 * 推荐位-最新上架
	 */
	RECOMMENDNEW(102001,GfanMarketBehaviorType.RECOMMEND,BehaviorSign.RECOMMENDNEW),
	/**
	 * 推荐位-精品推荐
	 */
	RECOMMENDBOUTIQUE(102002,GfanMarketBehaviorType.RECOMMEND,BehaviorSign.RECOMMENDBOUTIQUE),
	/**
	 * 推荐位-热门应用
	 */
	RECOMMENDAPP(102003,GfanMarketBehaviorType.RECOMMEND,BehaviorSign.RECOMMENDAPP),
	/**
	 * 推荐位-热门游戏
	 */
	RECOMMENDGAME(102004,GfanMarketBehaviorType.RECOMMEND,BehaviorSign.RECOMMENDGAME),
	/**
	 * 运营位-精品-装机必备
	 */
	OPERATENECESSARY(103000,GfanMarketBehaviorType.OPERATEALL,BehaviorSign.OPERATENECESSARY),
	/**
	 * 运营位-游戏-推荐
	 */
	OPERATEGR(103001,GfanMarketBehaviorType.OPERATELIMIT,BehaviorSign.OPERATEGR),
	/**
	 * 运营位-游戏-汉化
	 */
	OPERATEGC(103002,GfanMarketBehaviorType.OPERATELIMIT,BehaviorSign.OPERATEGC),
	/**
	 * 运营位-游戏-大作
	 */
	OPERATEGL(103003,GfanMarketBehaviorType.OPERATELIMIT,BehaviorSign.OPERATEGL),
	/**
	 * 运营位-应用-推荐
	 */
	OPERATEAR(103004,GfanMarketBehaviorType.OPERATELIMIT,BehaviorSign.OPERATEAR),
	/**
	 * 运营位-应用-汉化
	 */
	OPERATEAC(103005,GfanMarketBehaviorType.OPERATELIMIT,BehaviorSign.OPERATEAC),
	/**
	 * 运营位-应用-锋神榜
	 */
	OPERATEABB(103006,GfanMarketBehaviorType.OPERATEALL,BehaviorSign.OPERATEABB),
	/**
	 * 运营位-搜索-标签
	 */
	SEARCHTITLE(104001,GfanMarketBehaviorType.SEARCH,null);
	
	private int behaviorId;
	
	private GfanMarketBehaviorType type;
	
	private BehaviorSign sign;
	
	private GfanMarketBehavior(int behaviorId,GfanMarketBehaviorType type,BehaviorSign sign) {
		this.behaviorId = behaviorId;
		this.type = type;
		this.sign = sign;
	}

	public int getBehaviorId() {
		return behaviorId;
	}

	public GfanMarketBehaviorType getType() {
		return type;
	}

	public BehaviorSign getSign() {
		return sign;
	}

}
