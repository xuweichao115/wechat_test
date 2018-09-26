package com.utility;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log extends TypeConversionUtility{
	// Logger实例
	public Logger logger = null;

	// 将Log类封装为单例模式
	private static Log log;

	// 构造函数，用于初始化Logger配置需要的属性
	public Log() {
		// 获得当前目录路径
		String filePath = this.getClass().getResource("/").getPath();
		// 获得日志类logger的实例
		logger = Logger.getLogger(this.getClass());
		// logger所需的配置文件路径
		PropertyConfigurator.configure(filePath + "config/" + "log4j.properties");
		String log = StringUtils.substringBeforeLast(filePath, "/WEB-INF");
		System.setProperty("WORKDIR", log);
	}

	public static Log getLogger() {
		if (log != null)
			return log;
		else
			return new Log();
	}

}
