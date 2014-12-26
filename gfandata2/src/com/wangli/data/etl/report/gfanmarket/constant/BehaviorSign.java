package com.wangli.data.etl.report.gfanmarket.constant;

public enum BehaviorSign {

	/**
	 * BANNER-精品推荐
	 */
	BANNERBOUTIQUE("home.boutique"),
	/**
	 * BANNER-今日热门
	 */
	BANNERHOT("home.dailyhot"),
	/**
	 * BANNER-最新上架
	 */
	BANNERNEW("home.newpublish"),
	/**
	 * BANNER-电子书
	 */
	BANNERBOOK("book.home"),
	/**
	 * 推荐位-今日热门
	 */
	RECOMMENDHOT("1"),
	/**
	 * 推荐位-最新上架
	 */
	RECOMMENDNEW("2"),
	/**
	 * 推荐位-精品推荐
	 */
	RECOMMENDBOUTIQUE("5"),
	/**
	 * 推荐位-热门应用
	 */
	RECOMMENDAPP("3"),
	/**
	 * 推荐位-热门游戏
	 */
	RECOMMENDGAME("4"),
	/**
	 * 运营位-精品-装机必备
	 */
	OPERATENECESSARY("necessary_installed"),
	/**
	 * 运营位-游戏-推荐
	 */
	OPERATEGR("game_recommend"),
	/**
	 * 运营位-游戏-汉化
	 */
	OPERATEGC("game_cn"),
	/**
	 * 运营位-游戏-大作
	 */
	OPERATEGL("game_large"),
	/**
	 * 运营位-应用-推荐
	 */
	OPERATEAR("app_recommend"),
	/**
	 * 运营位-应用-汉化
	 */
	OPERATEAC("app_cn"),
	/**
	 * 运营位-应用-锋神榜
	 */
	OPERATEABB("app_gfanBillboard"),
	/**
	 * 运营位-专题
	 */
	OPERATETOPIC("topic"),
	/**
	 * 运营位-专题
	 */
	FEATURETOPIC("topic");
	
	private String sign;

	private BehaviorSign(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}
	
}
