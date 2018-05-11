package com.xh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bean.User;



@WebFilter("/backstage/*")//这里是拦截所有后台的访问的页面！防止随便人访问后台的页面
public class LoginFilter implements Filter {



	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {


		//接口，子接口
		HttpServletRequest  req= (HttpServletRequest)request;

		HttpServletResponse  resq= (HttpServletResponse)response;

		String path = req.getRequestURI();//获取的请求的uri

		//定位，url
		User user = (User) req.getSession().getAttribute("user"); // 看看session是否存有用户



		/*	System.err.println("000000000000000000");		
		System.err.println("(user!=null&&user.getType()==1)= path.contains(.js)= (path.contains(.jsp)&&!path.contains(index.jsp))path.contains(.css)");		
		System.err.println((user!=null&&user.getType()==1)+"="+ path.contains(".js")+"="+ (path.contains(".jsp")&&!path.contains("index.jsp"))+"="+ path.contains(".css"));
		 */
		//		System.err.println("user!=null&&user.getType()==1");
		//		System.err.println((user!=null)+"========="+user);

		/*|| path.contains(".js")|| (path.contains(".jsp")&&!path.contains("index.jsp"))|| path.contains(".css")*/

		System.err.println("00000000044000000000"+user);	
		/*这里如果是后台独立一个页面就不需要！||path.contains("login.jsp")  //判断有没有登录成功！记得放行页面！*/
		if(user!=null&&user.getType()==1){//取巧的方式，前后台是一个登录页面
			System.err.println("00000000044000000000");	
			//放行
			filter.doFilter(request, response);
			//resq.sendRedirect("../index.jsp");

		}else {

			//在webroot   就可以直接拿到	
			//因为这个拦截器是拦截所有后台的页面的，所以相对于前台的登录页面，相对路径就是上一级		
			resq.sendRedirect("../login.jsp");			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

		System.out.println("init>>>>>>>>>.启动");

	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub

		System.out.println("destroy>>>>>>>>>销毁");

	}

}
