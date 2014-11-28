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
import com.wangli.data.etl.report.gfanmarket.module.ClientEventLog;
import com.wangli.data.etl.report.gfanmarket.module.GfanClientEventDownload;
import com.wangli.data.etl.report.gfanmarket.service.BannerDownLoadCleanService;
import com.wangli.data.util.DateUtil;

public class BannerDownLoadCleanHandler extends RecommendCleanHandler{

	private BannerDownLoadCleanService bannerDownLoadCleanService;
	
	private String name;
	
	@Override
	protected int getCount() throws SQLException {
		return bannerDownLoadCleanService.getCount(DateUtil.getFormDate(getDate()));
	}

	@Override
	protected void deleteAll() throws SQLException {
		bannerDownLoadCleanService.deleteRepeatDate(DateUtil.getFormDate(getDate()));
	}

	@Override
	protected void handleOnce(int startIndex, int maxlength2) throws ParserConfigurationException, SAXException, IOException, SQLException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
		List<ClientEventLog> list = bannerDownLoadCleanService.getEventList(DateUtil.getFormDate(getDate()),startIndex, maxlength2);
		List<GfanClientEventDownload> banners = new ArrayList<GfanClientEventDownload>();
		for(ClientEventLog event : list){
			event = parseEventLog(event, dbBuilder);
			if(event!=null){
				GfanClientEventDownload banner = transformToBannerClick(event);
				if(banner!=null){
					banners.add(banner);
				}
			}
		}
		bannerDownLoadCleanService.insertBannerClick(banners);
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
	private GfanClientEventDownload transformToBannerClick(ClientEventLog event) throws SQLException{
		GfanClientEventDownload banner = new GfanClientEventDownload();
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
		banner.setPid((String)event.getArgMap().get("pid"));
		banner.setPath((String)event.getArgMap().get("path"));
		return bannerDownLoadCleanService.markBehaviorId(banner, getDate());
	}

	public BannerDownLoadCleanService getBannerDownLoadCleanService() {
		return bannerDownLoadCleanService;
	}

	public void setBannerDownLoadCleanService(BannerDownLoadCleanService bannerDownLoadCleanService) {
		this.bannerDownLoadCleanService = bannerDownLoadCleanService;
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
