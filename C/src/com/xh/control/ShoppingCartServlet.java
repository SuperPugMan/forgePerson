package com.xh.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import com.google.gson.GsonBuilder;
import com.xh.bean.Cart;
import com.xh.bean.CartItem;
import com.xh.bean.Product;
import com.xh.bean.ShoppingCart;
import com.xh.bean.User;
import com.xh.service.ProductService;
import com.xh.service.ShoppingCartService;
import com.xh.servicelmpl.ProductServiceImpl;
import com.xh.servicelmpl.ShoppingCartServiceImpl;

@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {

	Logger logger = Logger.getLogger(ShoppingCartServlet.class);
	ShoppingCartService shopping = new ShoppingCartServiceImpl();
	ProductService product = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.info("进入====================》ShoppingCartServlet");
		String page = req.getParameter("method");
		System.out.println(req.getParameter("method"));
		switch (page) {
		case "select":
			select(req, resp);
			break;
		case "finId":
			logger.info("进入====================》finId");
			finById(req, resp);
			break;
		case "def":
			logger.info("进入====================》def");
			getProduct(resp);
			break;
		case "addcar":
			logger.info("进入====================》addcar");
			addcart(req, resp);
			break;
		default:

			break;
		}
	}

	private void addcart(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// json格式的工具类
		Gson gson = new Gson();
		// 判断用户是否登录

		User user = (User) req.getSession().getAttribute("user");

		ShoppingCart cart = new ShoppingCart();// 购物车类

		if (user != null) {// 判断是否用户时登陆添加购物车
			cart.setUserId(user.getId());// 用户Id
			cart.setProductId(Integer.parseInt(req.getParameter("id")));// 商品Id
			cart.setProductNum(Integer.parseInt(req.getParameter("num")));// 数量
			boolean add = false;
			int num = 0;
			ShoppingCart select_Id = shopping.select_Id(cart.getProductId());
			// 若idxian
			if (null != select_Id.getProductId()) {
				if (select_Id.getProductId() == Integer.parseInt(req
						.getParameter("id"))) {
					logger.info("有该商品");
					System.out.println(select_Id);
					select_Id.setProductNum(select_Id.getProductNum()
							+ Integer.parseInt(req.getParameter("num")));
					boolean updata = shopping.updata(select_Id);
					if (updata) {
						req.getRequestDispatcher("page.jsp").forward(req, resp);
					}
				} else {
					add = shopping.add(cart);
					if (add) {
						req.getRequestDispatcher("page.jsp").forward(req, resp);
					}
				}
			} else {
				logger.info("没有该商品");
				add = shopping.add(cart);
				if (add) {
					req.getRequestDispatcher("page.jsp").forward(req, resp);
				}
			}
			/*
			 * if (null != select_Id) { cart.setProductNum(cart.getProductNum()
			 * + select_Id.getProductNum()); add = shopping.add(cart); }
			 */

			/*
			 * 
			 * //第一次用户的购物车购物车 //这里也可以直接跟数据库判断，发送sql语句，把用户id,商品id,发到购物车表
			 * List<ShoppingCart> list=service.select(user.getId());
			 * 
			 * if(list.size()>0){//用户ID的购物车下所有商品
			 * 
			 * 
			 * boolean flag=false; for (ShoppingCart shoppingCart : list)
			 * {//遍历商品
			 * 
			 * 
			 * if(shoppingCart.getProductId().intValue()==cart.getProductId().
			 * intValue()){//其中某个商品与要存进购物车的商品Id一致 flag=true;
			 * 
			 * cart.setProductNum(shoppingCart.getProductNum()+cart.getProductNum
			 * ());//将要存进购物车的数量与之前的数量相加
			 * if(service.updata(cart)){//调用service层方法，不为0即存进成功
			 * 
			 * }else{
			 * 
			 * } resp.sendRedirect("page.jsp?id="+req.getParameter("id")); } }
			 * 
			 * 
			 * if(!flag){ if(service.add(cart)){//调用service层方法，不为0即存进成功
			 * System.out.println("成功加入购物车=======>add"); }else{
			 * System.out.println("加入购物车失败"); }
			 * resp.sendRedirect("page.jsp?id="+req.getParameter("id")); }
			 * 
			 * 
			 * }else{//用户ID的购物车下没有商品，直接存进数据库
			 * if(service.add(cart)){//调用service层方法，不为0即存进成功
			 * System.out.println("成功加入购物车"); }else{
			 * System.out.println("加入购物车失败"); }
			 * resp.sendRedirect("page.jsp?id="+req.getParameter("id")); }
			 */
		} else {// 如果用户没登录，就存进cookie

			logger.info("用户没登录=========>购物车存在cookie");

			logger.info("商品Id======>" + req.getParameter("id"));
			logger.info("商品数量======>" + req.getParameter("num"));
			Cart carts1 = null;
			// 商品实体类
			Product product1 = product.select_Id(req.getParameter("id"));
			// 从请求中获取cookie
			Cookie[] cookies = req.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				logger.info("cookie长度========>" + (i + 1));
				if ("cart".equals(cookies[i].getName())) {// 判断是否存在购物车的商品

					// 获取cookie的值
					String value = URLDecoder.decode(cookies[i].getValue(),
							"UTF-8");
					// 将json数据反向生成对象gson.fromJson（）这是java代码获取json的方法、、$.parseJSON(data)这是前端
					carts1 = gson.fromJson(value, Cart.class);

					carts1.addProduct(product1,
							Integer.parseInt(req.getParameter("num")));// 将商品存进cart类

					String json = gson.toJson(carts1); // 用Json返回给前端
					logger.info("json=========>select:" + json);

					Cookie cookie1 = new Cookie("cart", URLEncoder.encode(json,
							"UTF-8"));
					cookie1.setPath("/");// 这个要设置
					cookie1.setMaxAge(60 * 60);
					resp.addCookie(cookie1);

				} else {// 如果cookie不存在购物车
					logger.info("cookie不存在========>" + (i + 1));
					Cart carts = new Cart();
					carts.addProduct(product1,
							Integer.parseInt(req.getParameter("num")));
					String json = gson.toJson(carts); // 用Json返回给前端
					logger.info("json=========>select:" + json);

					Cookie cookie = new Cookie("cart", URLEncoder.encode(json,
							"UTF-8"));
					cookie.setPath("/");// 这个要设置
					cookie.setMaxAge(60 * 60);
					resp.addCookie(cookie);
				}

			}
			resp.sendRedirect("page.jsp?id=" + req.getParameter("id"));
		}
	}

	private void select(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		logger.info("进入====================》select");
		User user1 = (User) req.getSession().getAttribute("user");
		Gson gson = new Gson();
		if (user1 != null) {// 判断是否有用户登陆添加购物车
			System.out.println("用户已登陆========》");
			List<ShoppingCart> list2 = shopping.select(user1.getId());// 查找购物车，返回给前段购物车页面(包含商品Id,及数量，用户Id)
			Product product1 = null;// 商品实体类
			List<CartItem> list3 = new ArrayList<>();// 存放购物车选项类
			CartItem cartItem = null;
			for (int i = 0; i < list2.size(); i++) {// 遍历某用户的购物车
				cartItem = new CartItem();
				product1 = product.select_Id(list2.get(i).getProductId());// 查找指定商品Id
				logger.info("商品=====》" + product1);
				cartItem.setProduct(product1);// 将值赋给购物车选项类
				logger.info(cartItem.getProduct());
				cartItem.setNum(list2.get(i).getProductNum());
				logger.info(cartItem.getNum());
				cartItem.setPrice(product1.getPrice());
				logger.info(cartItem.getPrice());
				list3.add(cartItem);// 添加购物车选项类到集合中
			}
			String json = gson.toJson(list3); // 用Json返回给前端
			logger.info("json=========>select:" + json);
			req.getSession().setAttribute("haveUserCart", list3);
			PrintWriter writer = resp.getWriter();
			writer.print(json); // 返回数据给前台
			writer.close();
		} else {// 用户没登陆，到cookie取值
			logger.info("用户未登陆============>");
			Cookie[] cookies = req.getCookies();
			Cart carts1 = new Cart();
			List<CartItem> list4 = new ArrayList<>();// 存放购物车选项类
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cart")) {
					String value = URLDecoder.decode(cookies[i].getValue(),
							"UTF-8");// 获取cookie的值
					carts1 = gson.fromJson(value, Cart.class);// 将json数据反向生成对象
					Map<String, CartItem> map = carts1.getMap();
					for (Entry<String, CartItem> product : map.entrySet()) {
						CartItem cartItem = product.getValue();
						logger.info("cartItem========>" + cartItem);
						list4.add(cartItem);
					}
				}
			}
			String json = gson.toJson(list4); // 用Json返回给前端
			logger.info("用户未登陆json=========>select:" + json);
			req.getSession().setAttribute("notUserCart", json);
			PrintWriter writer = resp.getWriter();
			writer.print(json); // 返回数据给前台
			writer.close();
		}
	}

	private void getProduct(HttpServletResponse resp) {

	}

	private void finById(HttpServletRequest req, HttpServletResponse resp) {

		List<ShoppingCart> list = shopping.select(req.getParameter("id"));

		Gson gson = new GsonBuilder().create();

		String json = gson.toJson(list);
		System.out.println(json);
		// 获取输出流对象
		PrintWriter writer;
		try {
			writer = resp.getWriter();
			writer.print(json); // 返回数据给前台
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
