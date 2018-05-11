package com.xh.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class ConfigManager {

	/**
	 * @param args
	 */

	private	static Connection conn=null;
	private static ConfigManager manager=new ConfigManager();	
	private static Properties proper;


	private ConfigManager(){		
		/**
		 * 1：.properties的文件都是键值队存储的
		 * 
		 * 2：把"database.properties"文件加载到内存中,必须用加载器,ClassLoader
		 * InputStream stream = ConfigManager.class.getClassLoader()
		 * .getResourceAsStream("database.properties");	
		 * 
		 * 3；Properties 对象在输入流中获取数据,		  		  		  		  
		 */
		proper=new Properties();			
		InputStream stream = ConfigManager.class.getClassLoader()
				.getResourceAsStream("database.properties");


		try {
			proper.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**	  
	 * @return
	 * 
	 * 利用单例  只提供一个对象
	 */
	public static synchronized ConfigManager getInstance(){
		return manager;

	}

	/**
	 * 
	 * @param key
	 * @return  获取到配置文件里的键值对的  value值
	 */
	public static String getValue(String key){
		//通过键名字，获取到值，并返回去
		return proper.getProperty(key);		

	}


	/**
	 * 
	 * @return
	 * 获取连接数据库对象 Connection 对象
	 */
	/*public static Connection getConnection(){

		try {

			//加载驱动
			Class.forName(ConfigManager.getInstance().getValue("jdbc.driver"));

			//获取连接数据库对象
			conn = DriverManager.getConnection(ConfigManager.getInstance().getValue("jdbc.url"), 
					ConfigManager.getInstance().getValue("jdbc.userName"),
					ConfigManager.getInstance().getValue("jdbc.passWord"));


		} catch (SQLException e) {			
			e.printStackTrace();			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();			
		}finally{			
			if (conn!=null) {
				System.out.println("加载配置成功，获取到了连接数据库对象！");				
			}

		}
		return conn;	

	}*/


}
