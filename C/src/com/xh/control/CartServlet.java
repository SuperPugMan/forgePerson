/*package com.xh.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xh.bean.Cart;
import com.xh.bean.CartItem;
import com.xh.bean.User;
import com.xh.service.ProductService;
import com.xh.service.ShoppingCartService;
import com.xh.servicelmpl.ProductServiceImpl;
import com.xh.servicelmpl.ShoppingCartServiceImpl;


@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	*//**
	 * 购物车的中转
	 *//*

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	private ProductService ps = new ProductServiceImpl();
	private ShoppingCartService cs = new ShoppingCartServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		switch (method) {
		case "shopping":
			shopping(req, resp);
			break;
		case "addCart":
			addCart(req, resp);
			break;
		case "queryCart":
			queryCart(req, resp);
			break;
		}
	}

	private void queryCart(HttpServletRequest req, HttpServletResponse resp) {

		
		 * User user = (User) req.getSession().getAttribute("user"); List list =
		 * new ArrayList<Product>(); List<Cart> query = null; if (null != user)
		 * { query = cs.query(user.getId()); for (int i = 0; i < query.size();
		 * i++) { int orderId = query.get(i).getOrderId(); int orderNum =
		 * query.get(i).getOrderNum(); Product fin = ps.findById(orderId);
		 * CartItem ct = new CartItem(); ct.setProduct(fin);
		 * ct.setNum(orderNum); list.add(ct); } } Gson gs = new Gson(); String
		 * json = gs.toJson(list); System.out.println(json); try { PrintWriter
		 * writer = resp.getWriter(); writer.print(json); writer.close(); }
		 * catch (IOException e) { e.printStackTrace(); }
		 
		User user = (User) req.getSession().getAttribute("user");
		Cookie[] cookies = req.getCookies();
		List<Cart> query = null;
		String json = null;
		Gson gs = new Gson();
		Map<Integer, CartItem> map = new LinkedHashMap<>();
		if (null != user) {
			if (null != cookies) {
				System.out.println("cookie");
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("cart")) {
						System.out.println("进入cookie" + "cart");
						json = cookie.getValue();
						System.out.println(json);
						Cart cart = gs.fromJson(json, Cart.class);
						System.out.println(cart);
						Map<Integer, CartItem> map2 = cart.getMap();
						Set<Entry<Integer, CartItem>> entrySet = map2
								.entrySet();
						Iterator<Entry<Integer, CartItem>> meIt = entrySet
								.iterator();
						while (meIt.hasNext()) {
							Entry<Integer, CartItem> entry = meIt.next();

							System.out.println("进入cookie" + user.getId() + ""
									+ entry.getKey().toString() + cart
									+ entry.getValue().getNum());

							vipCart(user.getId() + "", entry.getKey()
									.toString(), cart, entry.getValue()
									.getNum(), resp);
						}
						System.out.println("清除cookie");
						
						// 5, 清空Cookie 设置存活时间为0, 立马销毁
						cookie = new Cookie("cart", null);
						cookie.setPath("/");
						cookie.setMaxAge(-0);
						resp.addCookie(cookie);
					}
				}
			}
			Cart cart = new Cart();
			
			query = cs.query(user.getId());
			
			
			for (int i = 0; i < query.size(); i++) {
				int orderId = query.get(i).getOrderId();
				int userId = query.get(i).getUserId();
				int orderNum = query.get(i).getOrderNum();
				if (user.getId() == userId) {
					CartItem ct = new CartItem();
					ct.setNum(orderNum);
					ct.setProduct(ps.findById(orderId));
					map.put(orderId, ct);
					query.get(i).setMap(map);
					cart.setUserId(userId);
					cart.setMap(map);
				}
			}

			json = gs.toJson(cart);
			System.out.println(json);
			try {
				PrintWriter writer = resp.getWriter();
				writer.print(json);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			Cart cart = null;

			if (null != cookies) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("cart")) {
						json = cookie.getValue();
					}
				}
			}
		}
		PrintWriter writer;
		try {
			writer = resp.getWriter();
			writer.print(json);
			System.out.println(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// cookie成功**************************************************成功

	}

	private void addCart(HttpServletRequest req, HttpServletResponse resp) {
		String uid = req.getParameter("uid");
		String pid = req.getParameter("pid");

		Cookie[] cookies = req.getCookies();
		Cart cart = null;

		Gson gs = new Gson();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cart")) {
					cart = gs.fromJson(cookie.getValue(), Cart.class);
					// System.out.println(cart);
					// System.out.println("转出来就空格");
				}
			}
		}
		if (null == cart) {
			System.out.println("第一次购物");
			cart = new Cart();
		}

		ps.addCart(pid, cart);
		// 测试====================================================

		
		 * CartItem c = new CartItem(); Product product = ps.findById(pid);
		 * c.setProduct(product);
		 * 
		 * Map<Integer, CartItem> map = cart.getMap();
		 * map.put(Integer.parseInt(pid), c); ps.addCart(pid, cart);
		 

		// 测试====================================================

		if (null != uid) {
			vipCart(uid, pid, cart, 0, resp);
			
			 * System.out.println("清除cookie"); // 5, 清空Cookie 设置存活时间为0, 立马销毁
			 * Cookie cookie = new Cookie("cart", null); cookie.setPath("/");
			 * cookie.setMaxAge(-0); resp.addCookie(cookie);
			 
		} else {
			String json = gs.toJson(cart);
			System.out.println("cookie中存入======>" + json);
			Cookie cookie = new Cookie("cart", json);
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 7);
			resp.addCookie(cookie);
		}

	}

	public void vipCart(String uid, String pid, Cart cart, int num,
			HttpServletResponse resp) {
		Cart ca = cs.findById(uid, pid);
		System.out.println(ca.getUserId() + "\t" + Integer.parseInt(uid) + "\t"
				+ ca.getOrderId() + "\t" + Integer.parseInt(pid));
		if (null != ca && ca.getUserId() == Integer.parseInt(uid)
				&& ca.getOrderId() == Integer.parseInt(pid)) {
			if (0 > num) {
				ca.setOrderNum(ca.getOrderNum() + num);
			} else {
				ca.setOrderNum(ca.getOrderNum() + 1);
			}
			cs.update(ca);
		} else {
			System.out.println("进来啊");
			cart.setUserId(Integer.parseInt(uid));
			System.out.println(num);
			int save = 0;
			if (num == 0) {
				save = cs.save(uid, pid, 1);
			} else {
				save = cs.save(uid, pid, num);
			}
			if (save > 0) {
				System.out.println("成功");
			}
		}

	}

	private void shopping(HttpServletRequest req, HttpServletResponse resp) {
		
		
		String id = req.getParameter("id");
		Product findById = ps.findById(id);
		req.getSession().setAttribute("product", findById);
		try {
			resp.sendRedirect("home/introduction.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
*/