package com.wangli.data.gfan.analysis.parse;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wangli.data.gfan.analysis.DownClickAnalysis;
import com.wangli.data.gfan.analysis.bean.DownLoad;

public class DownLoadParse {

	private static Logger logger = Logger.getLogger(DownLoadParse.class);
	
	public List<DownLoad> parseList(List<DownLoad> list) {
		List<DownLoad> newList = new ArrayList<DownLoad>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			for (DownLoad download : list) {
				parseDownLoad(download, dbBuilder);
				if(isNeed(download)){
					newList.add(download);
				}
			}
		} catch (Exception e) {
			logger.error("parse download failed");
		}
		return newList;
	}
	
	private DownLoad parseDownLoad(DownLoad download,DocumentBuilder dbBuilder) throws SAXException, IOException{
		String xmlstr="<args>" + download.getArgs() + "</args>";
		StringReader sr = new StringReader(xmlstr);
		InputSource is = new InputSource(sr);
		Document doc = dbBuilder.parse(is);
		Node nValue = doc.getElementsByTagName("value").item(0);
		try {
			Gson gson = new Gson();
			Map<String,String> arg = gson.fromJson(nValue.getTextContent(), new TypeToken<Map<String,String>>(){}.getType());
			download.setPid(Integer.parseInt(arg.get("pid")));
			download.setPath(arg.get("path"));
		} catch (Exception e) {
			try {
				download.setPid(Integer.parseInt(nValue.getTextContent()));
			} catch (Exception e2) {
				download.setPid(0);
			}
		}
		return download;
	}
	
	private boolean isNeed(DownLoad downLoad){
		String path = downLoad.getPath();
		if(path==null){
			return downLoad.getEventSource().equals("1005");
		}
		return path.matches("^1005(,9002)?$");
	}
	
	public static void main(String[] args) {
		DownClickAnalysis analysis = new DownClickAnalysis("2014-11-03");
		analysis.process();
	}
}
