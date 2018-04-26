package com.forge.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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

@WebServlet({"/user","/userlogin"})
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
		String userMethod = req.getParameter("method");
		System.out.println(userMethod);
		switch (userMethod) {
		case "login":
			try {
				login(req, resp);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
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
			break;
		case "findAll":
			findAll(req,resp);
			break;
		case "update":
			update(req,resp);
			break;
		case "findOne":
			findOne(req,resp);
			break;
		case "updateById":
			updateById(req,resp);
			break;
		case "delete":
			delete(req,resp);
			break;
		default:
			break;
		}

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id=req.getParameter("id");
		System.out.println(id);
		PrintWriter out = resp.getWriter();
		boolean delete = userSer.delete(id);
		System.out.println(delete);
		if(delete){
			out.print("<script>alert('删除成功!');</script>");
			resp.sendRedirect("/forge_CMS/user?method=findAll");
		}else{
			out.print("<script>alert('删除成功!');</script>");
			resp.sendRedirect("/forge_CMS/user?method=findAll");

		}
	}

	private void updateById(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String userId=req.getParameter("userid");
		String name=req.getParameter("loginName");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		User user=new User();
		user.setAddress(address);
		user.setEmail(email);
		user.setLoginName(name);
		user.setPhone(phone);
		boolean update = userSer.update(userId, user);
		if(update){
			resp.sendRedirect("/forge_CMS/user?method=findAll");
		}else{
			req.getRequestDispatcher("production/User_Info_table.jsp").forward(req, resp);
		}
		
	}

	private void findOne(HttpServletRequest req, HttpServletResponse resp) {
		String id= req.getParameter("id");
		User user = userSer.findById(id);
		req.setAttribute("user", user);
		try {
			req.getRequestDispatcher("production/User_Info_table.jsp").forward(req, resp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) {
		String id=req.getParameter("id");
		req.setAttribute("id", id);
		try {
			resp.sendRedirect("/forge_CMS/user?method=findOne&id="+id+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<User> userlist = userSer.findAll();
		req.getSession().setAttribute("userList", userlist);
		//try {
			resp.sendRedirect("production/tables_dynamic.jsp");
/*			req.getRequestDispatcher("production/tables_dynamic.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}*/
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
		String name = req.getParameter("name");
		String pwd = req.getParameter("password");
		User user = new User();
		//String encryptedPwd = Md5Encrypt.MD5(pwd);
		user.setLoginName(name);
		user.setPassword(pwd);
		User userQuery = userSer.login(name, pwd);
		if (userQuery == null) {
			// req.getSession().setAttribute("alert", "用户名或密码错误");
			resp.setContentType("text/html;charset=GBK");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
			out.print("<script>");
			out.print("alert('用户名或密码错误!');");
			out.print("window.location.href='production/login.jsp'");
			out.print("</script>");
			out.flush();
			out.close();
		} else {
			req.getSession().setAttribute("user", userQuery);
			Cookie nameCookie = new Cookie("name", name);
			nameCookie.setMaxAge(5 * 60);
			resp.addCookie(nameCookie);
			resp.sendRedirect("production/index.jsp");
		}
	}

}
