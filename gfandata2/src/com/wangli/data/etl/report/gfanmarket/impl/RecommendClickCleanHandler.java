package com.wangli.data.etl.report.gfanmarket.impl;

import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import com.wangli.data.etl.report.gfanmarket.service.RecommendClickCleanService;
import com.wangli.data.util.DateUtil;

public class RecommendClickCleanHandler extends RecommendCleanHandler{

	private RecommendClickCleanService recommendClickCleanService;
	
	private String name;
	
	private Map<String,GfanMarketBehavior> behaviors;
	
	private RecommendClickCleanHandler() {
		behaviors = new HashMap<String,GfanMarketBehavior>();
		behaviors.put(ClickEventSource.RECOMMENDAPP.getEventSource(), ClickEventSource.RECOMMENDAPP.getBehavior());
		behaviors.put(ClickEventSource.RECOMMENDBOUTIQUE.getEventSource(), ClickEventSource.RECOMMENDBOUTIQUE.getBehavior());
		behaviors.put(ClickEventSource.RECOMMENDGAME.getEventSource(), ClickEventSource.RECOMMENDGAME.getBehavior());
		behaviors.put(ClickEventSource.RECOMMENDHOT.getEventSource(), ClickEventSource.RECOMMENDHOT.getBehavior());
		behaviors.put(ClickEventSource.RECOMMENDNEW.getEventSource(), ClickEventSource.RECOMMENDNEW.getBehavior());
		behaviors.put(ClickEventSource.OPERATEABB.getEventSource(), ClickEventSource.OPERATEABB.getBehavior());
		behaviors.put(ClickEventSource.OPERATEAC.getEventSource(), ClickEventSource.OPERATEAC.getBehavior());
		behaviors.put(ClickEventSource.OPERATEAR.getEventSource(), ClickEventSource.OPERATEAR.getBehavior());
		behaviors.put(ClickEventSource.OPERATEGC.getEventSource(), ClickEventSource.OPERATEGC.getBehavior());
		behaviors.put(ClickEventSource.OPERATEGL.getEventSource(), ClickEventSource.OPERATEGL.getBehavior());
		behaviors.put(ClickEventSource.OPERATEGR.getEventSource(), ClickEventSource.OPERATEGR.getBehavior());
		behaviors.put(ClickEventSource.OPERATENECESSARY.getEventSource(), ClickEventSource.OPERATENECESSARY.getBehavior());
	}

	@Override
	protected int getCount() throws SQLException {
		return recommendClickCleanService.getCount(DateUtil.getFormDate(getDate()));
	}

	@Override
	protected void deleteAll() throws SQLException {
		for(GfanMarketBehavior behavior:behaviors.values()){
			recommendClickCleanService.deleteRepeatDate(DateUtil.getFormDate(getDate()),behavior.getBehaviorId());
		}
	}

	@Override
	protected void handleOnce(int startIndex, int maxlength2) throws ParserConfigurationException, SAXException, IOException, SQLException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
		List<ClientEventLog> list = recommendClickCleanService.getEventList(DateUtil.getFormDate(getDate()),startIndex, maxlength2);
		List<GfanClientEventClick> banners = new ArrayList<GfanClientEventClick>();
		for(ClientEventLog event : list){
			event = parseEventLog(event, dbBuilder);
			if(event!=null){
				GfanClientEventClick banner = transformToBannerClick(event);
				if(banner!=null){
					banners.add(banner);
				}
			}
		}
		recommendClickCleanService.insertBannerClick(banners);
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
		try {
			Gson gson = new Gson();
			Map<String,Object> arg = gson.fromJson(nValue.getTextContent(), new TypeToken<Map<String,String>>(){}.getType());
			event.setArgMap(arg);
			if(event.getArgMap()!=null){
				return event;
			}
		} catch (Exception e) {
			if(nValue.getTextContent().matches("^\\d+$")){
				Map<String,Object> arg = new HashMap<String,Object>();
				arg.put("pid", nValue.getTextContent());
				arg.put("path", event.getEventSource());
				event.setArgMap(arg);
				return event;
			}
		}
		
		return null;
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
			if(event.getArgMap()!=null&&event.getArgMap().get("pid")!=null){
				Integer pid = recommendClickCleanService.checkBannerId((String)event.getArgMap().get("pid"), behavior, getDate());
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

	public RecommendClickCleanService getRecommendClickCleanService() {
		return recommendClickCleanService;
	}

	public void setRecommendClickCleanService(RecommendClickCleanService recommendClickCleanService) {
		this.recommendClickCleanService = recommendClickCleanService;
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
