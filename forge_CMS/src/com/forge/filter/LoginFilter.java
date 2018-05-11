package com.forge.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.log4j.Logger;

import com.forge.bean.User;
@WebFilter(value={"/*"})
public class LoginFilter implements Filter {
	Logger log=Logger.getLogger(CharacterFilter.class);
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		log.info("LoginFilter用户登录过滤-->doFilter");
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		User user=(User) request.getSession().getAttribute("user");
		log.info(user);
		String path = request.getRequestURI();
		log.info(path);
		if(null!=user||path.contains("login")||path.contains("js")||path.contains("css")||path.contains("fonts")||path.contains("img")||path.contains("images")){
			chain.doFilter(request, response);
		}else{
			response.sendRedirect("production/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
