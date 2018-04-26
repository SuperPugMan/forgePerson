package com.forge.util;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;


public class MemcachedUtil {
	//01.私有化本类对象
	private static MemcachedUtil util;
	private static MemcachedClient client=null;
	static{
		util= new MemcachedUtil();
		try {
			client=new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//02.私有化构造
	private MemcachedUtil(){
	}
	//03.提供对外访问的接口
	public static MemcachedClient getInstance(){
		return client;
	}
}
