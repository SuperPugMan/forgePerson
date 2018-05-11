package com.xh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 
 * @author LSZ
 *
 * 非宁静无以致远！
 * 2018-4-29下午4:25:59  多虑编码格式
 *
 */

@WebFilter("/*")
public class CharsetFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest reques, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		
		reques.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//放行
		filter.doFilter(reques, response);
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
