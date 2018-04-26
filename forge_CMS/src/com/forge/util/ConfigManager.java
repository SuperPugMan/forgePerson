package com.forge.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *读取properties文件的单例类
 */
public class ConfigManager {
	//01.创建本类的静态变量
	private static ConfigManager maneger=new ConfigManager();
	private static Properties properties;
	//02.私有化构造
	private ConfigManager(){
		properties=new Properties();
		InputStream stream = ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//03.提供对外访问的接口
	public static synchronized ConfigManager getInstance(){
		return maneger;
	}
	//04.让用户传递一个文件中的key 返回文件中的value
	public static String getValue(String key){
		return properties.getProperty(key);
	}
}
