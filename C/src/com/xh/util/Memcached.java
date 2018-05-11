package com.xh.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;



/**
 * 
 * @author LSZ
 *
 * 非宁静无以致远！
 * 2018-4-13上午11:58:06
 * 
 * 
 * 通过spymemcached jar包提供的接口，实现缓存，减少数据库查询的压力！
 * 缓存技术,把一些东西存在缓存中，方便下一次查找的东西，直接拿！不在访问数据库！
 * 
 * 键值对存储！
 * MemcachedClient 对象的，get(key)//取得键值对应的,set(key,time,object),//设置存入缓存池的东西
 * delete()
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */
public class Memcached {
	
	private static Memcached menc;
	
	private static MemcachedClient me=null;
	
	//加载取动项目的加载一次生成了唯一个对象
	static{
		
		 try {
			 //新建对象！    new InetSocketAddress("127.0.0.1//本机地址", 11211//端口号)
			me=new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private Memcached(){
						
	}
	
	public static synchronized MemcachedClient getIn(){
		
		
		return me;
		
		
	}
	
	

}
