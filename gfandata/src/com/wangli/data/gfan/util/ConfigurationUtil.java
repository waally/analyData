package com.wangli.data.gfan.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigurationUtil {

	private static Logger logger = Logger.getLogger(ConfigurationUtil.class);
	
	private static Properties propertie;
	private static String filePath = "conf.properties";
	
	public static void main(String[] args) throws IOException {
		System.out.println(getProValue("dbUserName"));
		setProValue("name", "wangli");
		storePro();
	}
	public static String getProValue(String key){
		if(propertie==null){
			try {
				propertie = new Properties();
				FileInputStream inputFile = new FileInputStream(filePath);
				propertie.load(inputFile);
				inputFile.close();
			} catch (Exception e) {
				logger.fatal("init properties error",e);
			}
		}
		return propertie.getProperty(key);
	}
	
	public static void setProValue(String key,String value){
		propertie.setProperty(key, value);
	}
	
	public static void storePro(){
		try {
			FileOutputStream outputFile = new FileOutputStream(filePath);
			propertie.store(outputFile, "save properties info");
			outputFile.close();
		} catch (Exception e) {
			logger.fatal("save properties error",e);
		}
	}
}
