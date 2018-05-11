package com.xh.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Snippet {
	public static void main(String[] args) {
		
		
	    	try {
	    		String pwd = Md5Encrypt.getEncryptedPwd("1235");//获得加密后的16进制
	    		byte[] bs = Md5Encrypt.hexStringToByte(pwd);//16进制的字符串转换成数组
	    		String q = Md5Encrypt.byteToHexString(bs);//baty数组转换成16进制字符串
	    		System.out.println(q);
	    	/*	String pwds = Md5Encrypt.getEncryptedPwd("1235");//获得加密后的16进制
	    		byte[] bss = Md5Encrypt.hexStringToByte(pwd);//16进制的字符串转换成数组
	    		String qs = Md5Encrypt.byteToHexString(bs);//baey数组转换成16进制字符串
	    		System.out.println(qs);	*/
	    	} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
	    		e.printStackTrace();
	    	}//输入密码
	    	}
}

