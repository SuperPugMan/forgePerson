package com.forge.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.print.attribute.standard.Sides;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.forge.bean.User;
import com.forge.service.UserService;
import com.forge.service.impl.UserServiceImpl;
import com.forge.util.Md5Encrypt;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	UserService userSer = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String slider_block = req.getParameter("slider_block");
		String userMethod = req.getParameter("method");
		switch (userMethod) {
		case "login":
			if (slider_block.equals("100")) {
				try {
					login(req, resp);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			} else {
				resp.setContentType("text/html;charset=GBK");
				PrintWriter out = resp.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
				out.print("<script>");
				out.print("alert('请滑动滑块以完成验证!');");
				out.print("window.location.href='login.jsp'");
				out.print("</script>");
				out.flush();
				out.close();
			}
			break;
		case "register":
			try {
				register(req, resp);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		case "mycount":
			mycount(req,resp);
		default:
			break;
		}

	}

	private void mycount(HttpServletRequest req, HttpServletResponse resp) {
		String name = (String) req.getSession().getAttribute("name");
		User user = userSer.mycount(name);
		req.getSession().setAttribute("address", user.getAddress());
		req.getSession().setAttribute("phone", user.getPhone());
		req.getSession().setAttribute("email", user.getEmail());
		req.getSession().setAttribute("phone3", user.getPhone());
		
	}

	private void register(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NoSuchAlgorithmException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		// MD5加密
		String encryptedPwd = Md5Encrypt.MD5(pwd);
		User user = new User();
		user.setEmail(email);
		user.setAddress(address);
		user.setLoginName(firstName + lastName);
		user.setPassword(encryptedPwd);
		user.setPhone(phone);
		boolean add = userSer.add(user);
		if (add) {
			resp.sendRedirect("index.jsp");
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NoSuchAlgorithmException {
		String name = req.getParameter("email");
		String pwd = req.getParameter("password");
		User user = new User();
		String encryptedPwd = Md5Encrypt.MD5(pwd);
		user.setLoginName(name);
		user.setPassword(encryptedPwd);
		User userQuery = userSer.login(name, encryptedPwd);
		if (userQuery == null) {
			// req.getSession().setAttribute("alert", "用户名或密码错误");
			resp.setContentType("text/html;charset=GBK");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
			out.print("<script>");
			out.print("alert('用户名或密码错误!');");
			out.print("window.location.href='login.jsp'");
			out.print("</script>");
			out.flush();
			out.close();
		} else {
			req.getSession().setAttribute("user", userQuery);
			String remember = req.getParameter("remember");
			if ((remember != null) && remember.equals("on")) {
				Cookie nameCookie = new Cookie("name", name);
				nameCookie.setMaxAge(5 * 60);
				resp.addCookie(nameCookie);
			}
			resp.sendRedirect("index.jsp");
		}
	}

}
