package com.forge.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigSingTon {
	private static Properties pstmt;

	private ConfigSingTon() {
		pstmt = new Properties();
		InputStream stream = ConfigSingTon.class.getClassLoader()
				.getResourceAsStream("database.properties");
		try {
			pstmt.load(stream);
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

	public static class LazyHolder {
		private static final ConfigSingTon INSTANCE = new ConfigSingTon();
	}

	public static final ConfigSingTon getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	public  String getValue(String key){
		return pstmt.getProperty(key);
	}
	
	
}
