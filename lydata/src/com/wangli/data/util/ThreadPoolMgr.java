package com.wangli.data.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolMgr {

	public static String REMAINTHREAD = "RemainThreadPool";
	
	private static Map<String,ThreadPoolExecutor> threadpools= new HashMap<String,ThreadPoolExecutor>();
	
    public static ThreadPoolExecutor getThreadPool(String threadName,int initSize,int maxSize){
    	ThreadPoolExecutor threadPool = threadpools.get(threadName);
        if(null == threadPool){
        	threadPool = new ThreadPoolExecutor(initSize,maxSize,60L,TimeUnit.SECONDS,  new LinkedBlockingQueue<Runnable>());
        	threadpools.put(threadName, threadPool);
        }
        return threadPool;
    }
}
