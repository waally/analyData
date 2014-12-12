package com.wangli.data.etl.report.gfanmarket.impl;

import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wangli.data.etl.report.gfanmarket.RecommendCleanHandler;
import com.wangli.data.etl.report.gfanmarket.constant.ClickEventSource;
import com.wangli.data.etl.report.gfanmarket.constant.GfanMarketBehavior;
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLog;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventClick;
import com.wangli.data.etl.report.gfanmarket.service.BannerClickCleanService;
import com.wangli.data.util.DateUtil;

public class BannerClickCleanHandler extends RecommendCleanHandler{

	private BannerClickCleanService bannerClickCleanService;
	
	private String name;
	
	private Map<String,GfanMarketBehavior> behaviors;
	
	
	
	private BannerClickCleanHandler() {
		behaviors = new HashMap<String,GfanMarketBehavior>();
		behaviors.put(ClickEventSource.BANNERBOUTIQUE.getEventSource(), ClickEventSource.BANNERBOUTIQUE.getBehavior());
		behaviors.put(ClickEventSource.BANNERHOT.getEventSource(), ClickEventSource.BANNERHOT.getBehavior());
		behaviors.put(ClickEventSource.BANNERNEW.getEventSource(), ClickEventSource.BANNERNEW.getBehavior());
		behaviors.put(ClickEventSource.BANNERBOOK.getEventSource(), ClickEventSource.BANNERBOOK.getBehavior());
	}

	@Override
	protected int getCount() throws SQLException {
		return bannerClickCleanService.getCount(DateUtil.getFormDate(getDate()));
	}

	@Override
	protected void deleteAll() throws SQLException {
		for(GfanMarketBehavior behavior:behaviors.values()){
			bannerClickCleanService.deleteRepeatDate(DateUtil.getFormDate(getDate()),behavior.getBehaviorId());
		}
	}

	@Override
	protected void handleOnce(int startIndex, int maxlength2) throws ParserConfigurationException, SAXException, IOException, SQLException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
		List<ClientEventLog> list = bannerClickCleanService.getEventList(DateUtil.getFormDate(getDate()),startIndex, maxlength2);
		List<GfanClientEventClick> banners = new ArrayList<GfanClientEventClick>();
		for(ClientEventLog event : list){
			event = parseEventLog(event, dbBuilder);
			GfanClientEventClick banner = transformToBannerClick(event);
			if(banner!=null){
				banners.add(banner);
			}
		}
		bannerClickCleanService.insertBannerClick(banners);
	}
	
	/**
	 * 格式化数据
	 * @param event
	 * @param dbBuilder
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 */
	private ClientEventLog parseEventLog(ClientEventLog event,DocumentBuilder dbBuilder) throws SAXException, IOException{
		String xmlstr="<args>" + event.getArgs() + "</args>";
		StringReader sr = new StringReader(xmlstr);
		InputSource is = new InputSource(sr);
		Document doc = dbBuilder.parse(is);
		Node nValue = doc.getElementsByTagName("value").item(0);
		Gson gson = new Gson();
		Map<String,Object> arg = gson.fromJson(nValue.getTextContent(), new TypeToken<Map<String,String>>(){}.getType());
		event.setArgMap(arg);
		return event;
	}

	/**
	 * 数据转换类型
	 * @param event
	 * @return
	 * @throws SQLException
	 */
	private GfanClientEventClick transformToBannerClick(ClientEventLog event) throws SQLException{
		GfanMarketBehavior behavior = behaviors.get(event.getEventSource());
		if(behavior!=null){
			if(event.getArgMap()!=null&&event.getArgMap().get("id")!=null){
				Integer pid = bannerClickCleanService.checkBannerId((String)event.getArgMap().get("id"), behavior, getDate());
				if(pid!=null){
					GfanClientEventClick banner = new GfanClientEventClick();
					banner.setArgs(event.getArgs());
					banner.setCid(event.getCid());
					banner.setClientId(event.getClientId());
					banner.setClientName(event.getClientName());
					banner.setClientVersion(event.getClientVersion());
					banner.setDataTime(event.getDataTime());
					banner.setEventId(event.getEventId());
					banner.setEventSource(event.getEventSource());
					banner.setEventValue(event.getEventValue());
					banner.setImei(event.getImei());
					banner.setInsertTime(new Date());
					banner.setLogtime(event.getInsertTime());
					banner.setPid(Integer.toString(pid));
					banner.setBehaviorId(behavior.getBehaviorId());
					return banner;
				}
			}
		}
		return null;
	}

	public BannerClickCleanService getBannerClickCleanService() {
		return bannerClickCleanService;
	}

	public void setBannerClickCleanService(BannerClickCleanService bannerClickCleanService) {
		this.bannerClickCleanService = bannerClickCleanService;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	
}
