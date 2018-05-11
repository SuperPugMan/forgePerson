package com.xh.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.xh.bean.Cart;
import com.xh.bean.CartItem;
import com.xh.bean.Order;
import com.xh.bean.ShoppingCart;
import com.xh.bean.User;
import com.xh.bean.UserAddress;
import com.xh.service.OrderService;
import com.xh.service.ShoppingCartService;
import com.xh.service.UserService;
import com.xh.servicelmpl.OrderServiceImpl;
import com.xh.servicelmpl.ShoppingCartServiceImpl;
import com.xh.servicelmpl.UserServiceImpl;
import com.xh.util.Md5Encrypt;

@WebServlet(value = { "/UserServlet", "/user" })
public class UserServlet extends HttpServlet {

	private static Logger logger = Logger.getLogger(UserServlet.class);

	UserService userService1 = new UserServiceImpl();

	private String show(String passward) {

		String pwd = "";
		try {
			pwd = Md5Encrypt.getEncryptedPwd(passward);// 获得加密后的16进制
			byte[] bs = Md5Encrypt.hexStringToByte(pwd);// 16进制的字符串转换成数组
			String q = Md5Encrypt.byteToHexString(bs);// baty数组转换成16进制字符串
			// System.out.println(q);
			/*
			 * String pwds = Md5Encrypt.getEncryptedPwd("1235");//获得加密后的16进制
			 * byte[] bss = Md5Encrypt.hexStringToByte(pwd);//16进制的字符串转换成数组
			 * String qs = Md5Encrypt.byteToHexString(bs);//baey数组转换成16进制字符串
			 * System.out.println(qs);
			 */
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}// 输入密码
		return pwd;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* req.setCharacterEncoding("UTF-8"); */

		String parameter = req.getParameter("method");
		logger.info("User--Method" + parameter);
		switch (parameter) {
		case "likeSelect":
			likeSelect(req, resp);
			break;
		case "address":
			address(req, resp);
			break;
		case "account":
			account(req, resp);
			break;
		case "deleteCart":
			delete(req, resp);
			break;
		case "paysuccess":
			try {
				paysuccess(req, resp);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			break;
		case "uname":

			// 这里是用户名查询是否相同

			String name = req.getParameter("username");

			User login1 = userService1.loginPwd(name);

			// 给ajax响应
			if (login1 != null && login1.getLoginName() != null) {
				resp.getWriter().print(false);// 返回数据到请求页面
			} else {
				// resp.getWriter().write("用户主");//可以是html页面
				resp.getWriter().print(true);
			}

			break;

		case "add":

			User user2 = new User();
			user2.setLoginName(req.getParameter("userName"));
			user2.setPassword(show(req.getParameter("passWord")));
			user2.setEmail(req.getParameter("email"));
			user2.setMobile(req.getParameter("phone"));
			logger.info("============================");
			if (userService1.add(user2)) {

				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.print("<script>");
				out.print("alert('用户添加成功!');");
				out.print("window.location.href='login.jsp'");
				out.print("</script>");
				out.flush();
				out.close();
				// resp.sendRedirect("login.jsp");

			} else {

				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.print("<script>");
				out.print("alert('用户添加成功!');");
				out.print("window.location.href='register.jsp'");
				out.print("</script>");
				out.flush();
				out.close();

			}

			break;
		case "login":

			String user = req.getParameter("user");
			String pwd = req.getParameter("pwd");

			// pwd=show(pwd);

			User login = userService1.loginPwd(user);

			if (login != null) {// 判断用户的有没有

				try {

					if (Md5Encrypt.validPassword(pwd, login.getPassword())
							|| login.getPassword().equals(pwd)) {
						String jizhu = req.getParameter("jizhu");
						Cookie co = new Cookie("user", user);
						Cookie co1 = new Cookie("pwd", login.getPassword());
						if (jizhu != null) {

							co.setMaxAge(60 * 60 * 24 * 14);
							co1.setMaxAge(60 * 60 * 24 * 14);
							resp.addCookie(co);
							resp.addCookie(co1);
							// resp.sendRedirect("showCookie75.jsp");

						} else {

							co.setMaxAge(0);
							co1.setMaxAge(0);
							resp.addCookie(co);
							resp.addCookie(co1);

						}
						//
						req.getSession().setAttribute("user", login);

						logger.info(login.getId() + "denglu=============");
						logger.debug("登录成功！");

						/*
						 * if (login.getType()==0) { //普通用户页面
						 * resp.sendRedirect("index.jsp");
						 * 
						 * }else{ //后台管理员登录页面
						 * resp.sendRedirect("backstage/index.jsp"); }
						 */

						addCookieCart(req, login, resp);
						resp.sendRedirect("index.jsp");

					} else {

						logger.debug("登录失败！");

						resp.sendRedirect("login.jsp");

					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}

			} else {
				// PrintWriter out = resp.getWriter();
				logger.debug("登录失败！");
				resp.sendRedirect("login.jsp");

			}

			break;

		default:
			break;
		}

	}

	private void paysuccess(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ParseException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		User user = (User) req.getSession().getAttribute("user");
		String allmoney = (String) req.getSession().getAttribute("allMoney");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		System.out.println(address);
		System.out.println(phone);
		int userId = user.getId();
		String loginName = user.getLoginName();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createTime = format.format(new Date());
		String serizableNumber = phone + System.currentTimeMillis();
		Order order = new Order();
		order.setCost(Float.valueOf(allmoney));
		order.setCreateTime(format.parse(createTime));
		order.setSerialNumber(serizableNumber);
		order.setLoginName(loginName);
		order.setUserAddress(address);
		order.setUserId(userId);
		OrderService orSer = new OrderServiceImpl();
		orSer.add(order);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		User login = (User) req.getSession().getAttribute("user");
		if (login != null) {
			String proId = req.getParameter("prodeId");
			logger.info("要删除的商品ID----》" + proId);
			ShoppingCartService shop = new ShoppingCartServiceImpl();
			boolean delete = shop.delete(proId);
			if (delete) {
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.print("<script>");
				out.print("alert('删除成功!');");
				out.print("window.location.href='my-car.jsp'");
				out.print("</script>");
				out.flush();
				out.close();
			}
		}
	}

	private void account(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		User login = (User) req.getSession().getAttribute("user");
		String all = req.getParameter("all");
		req.getSession().setAttribute("allMoney", all);
		if (login == null) {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.print("<script>");
			out.print("alert('您还未登录，请先登录!');");
			out.print("window.location.href='login.jsp'");
			out.print("</script>");
			out.flush();
			out.close();
		} else {
			resp.sendRedirect("my-add.jsp");
		}

	}

	private void address(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String parentId = req.getParameter("parentId");
		System.out.println(parentId);
		// 如果传的父结点为空，则默认赋值为中国的父结点，也就是每一级查询所有省份。
		if (parentId == null || parentId == "") {
			parentId = "0";
		}
		List<UserAddress> findAddress = userService1.findAddress(parentId);
		Gson gson = new Gson();
		String json = gson.toJson(findAddress);
		System.out.println(json);
		resp.setCharacterEncoding("UTF-8");// 防止出现中文乱码现象
		resp.getWriter().print(json);
	}

	private void likeSelect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		// 获取搜索框输入的内容
		String name = req.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		// 向server层调用相应的业务
		String likeSelect = userService1.likeSelect(name);
		// 返回结果
		resp.getWriter().write(likeSelect);
	}

	private void addCookieCart(HttpServletRequest req, User user,
			HttpServletResponse resp) {
		logger.info("进入===========》addCookieCart");
		Gson gson = new Gson();
		Cart carts1 = new Cart();

		List<CartItem> list4 = new ArrayList<>();// 存放购物车选项类

		Cookie[] cookies = req.getCookies();// 从请求获取cookie
		for (Cookie cookie2 : cookies) {// 循环cookie
			if (cookie2.getName().equals("cart")) {// 如果cookie有商品
				logger.info("cookie2有值===========》");
				ShoppingCartService service = new ShoppingCartServiceImpl();

				List<ShoppingCart> list = service.select(user.getId());// 根据用户从数据库查找购物车

				for (ShoppingCart shoppingCart : list) {
					logger.info(shoppingCart + "<----------shoppingCart");
				}

				ShoppingCart cart = new ShoppingCart();// 购物车类

				String value = "";
				try {
					value = URLDecoder.decode(cookie2.getValue(), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}// 获取cookie的值
				carts1 = gson.fromJson(value, Cart.class);// 将json数据反向生成对象
				Map<String, CartItem> map = carts1.getMap();
				for (Entry<String, CartItem> product : map.entrySet()) {// 遍历Map
					logger.info("遍历map=========>");
					CartItem cartItem = product.getValue();// 根据key找到商品value
					logger.info("cartItem========>" + cartItem);
					/* list4.add(cartItem);//把商品value存到list,每个商品唯一，因为map的key唯一 */
					cart.setProductId(cartItem.getProduct().getId());
					cart.setProductNum(cartItem.getNum());
					cart.setUserId(user.getId());

					if (list.size() != 0) {// 用户ID的购物车下有商品
						logger.info("用户登陆查看cookie=====2");
						boolean flag = false;
						for (ShoppingCart shoppingCart : list) {// 遍历数据库购物车商品
							logger.info(shoppingCart);
							logger.info("用户登陆查看cookie=====3");
							if (shoppingCart.getProductId().intValue() == cart
									.getProductId().intValue()) {// 其中某个商品与要存进购物车的商品Id一致
								flag = true;
								logger.info("shoppingCart=====>"
										+ shoppingCart.getProductId());
								logger.info("cart=====>" + cart.getProductId());
								logger.info("用户登陆查看cookie=====4");
								cart.setProductNum(shoppingCart.getProductNum()
										+ cart.getProductNum());// 将要存进购物车的数量与之前的数量相加
								if (service.updata(cart)) {// 调用service层方法，不为0即存进成功
									logger.info("成功加入购物车=====>updata");

								} else {
									logger.info("加入购物车失败");

								}

							}// if(!flag)不能在这，因为遍历只要有一个不相等就是新增，
						}
						if (!flag) {// 用户数据库存有商品，但没有cookie的商品
							logger.info("===========>没有cookie的商品");
							if (service.add(cart)) {// 调用service层方法，不为0即存进成功
								logger.info("成功加入购物车=======>add");
							} else {
								logger.info("加入购物车失败");
							}

						}
					} else {// 用户ID的购物车下没有商品，直接存进数据库
						if (service.add(cart)) {// 调用service层方法，不为0即存进成功
							logger.info("成功加入购物车");
						} else {
							logger.info("加入购物车失败");
						}

					}

				}

			}
		}
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cart")) {
					logger.info("===========>遍历cookies");
					Cookie cookie = new Cookie("cart", "");// 这边得用"",不能用null
					cookie.setPath("/");// 设置成跟写入cookies一样的
					// cookie.setDomain(".wangwz.com");//设置成跟写入cookies一样的
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					logger.info("清除完成");
				}
			}
		}
	}

}
