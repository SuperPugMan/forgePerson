package com.forge.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.Properties;

import net.spy.memcached.MemcachedClient;

import com.forge.util.ConfigSingTon.LazyHolder;

public class MemcachedDBSington {
	private MemcachedClient client ;
	private MemcachedDBSington() {
		System.out.println("-----------------华丽丽的分割线------------------");
		try {
			client=new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class LazyHolder {
		private static final MemcachedDBSington INSTANCE= new MemcachedDBSington();
	}
	public static final MemcachedClient getInstanceClient(){
		return LazyHolder.INSTANCE.client;
	}
}
