package com.forge.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.Sides;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.forge.bean.Order;
import com.forge.bean.Order_Detail;
import com.forge.bean.User;
import com.forge.dao.impl.OrderDaoImpl;
import com.forge.service.OrderService;
import com.forge.service.UserService;
import com.forge.service.impl.OrderServiceImpl;
import com.forge.service.impl.UserServiceImpl;
import com.forge.util.Md5Encrypt;

@WebServlet({"/order","/orderDetail"})
public class OrderServlet extends HttpServlet {
	OrderService ordSer=new OrderServiceImpl();

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
		switch (userMethod) {
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
			try {
				updateById(req,resp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			delete(req,resp);
			break;
		case "findAllDetail":
			findAllDetail(req,resp);
			break;
		case "findorderDetail":
			findorderDetail(req,resp);
			break;
		case "updateDetailById":
			updateDetailById(req,resp);
			break;
		default:
			break;
		}

	}

	private void updateDetailById(HttpServletRequest req,
			HttpServletResponse resp) {
		Order_Detail order=new Order_Detail();
		String quantity1=req.getParameter("quanTity");
		int quantity=Integer.valueOf(quantity1);
		String cost1=req.getParameter("cost");
		double cost=Double.valueOf(cost1);
		order.setCost(cost);
		order.setQuanTity(quantity);
		String id=req.getParameter("id");
		OrderServiceImpl orderSer=new OrderServiceImpl();
		 orderSer.updateDetai(id, order);
		try {
			resp.sendRedirect("/forge_CMS/orderDetail?method=findAllDetail");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findorderDetail(HttpServletRequest req,
			HttpServletResponse resp) {
		String id = req.getParameter("id");
		OrderDaoImpl order=new OrderDaoImpl();
		Order_Detail order_Detail = order.findDetailById(id);
		req.setAttribute("orderDetail", order_Detail);
		req.setAttribute("serizaNumber", order_Detail.getSerizalNumber());
		req.setAttribute("name", order_Detail.getName());
		try {
			req.getRequestDispatcher("production/table_order_detail_info.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findAllDetail(HttpServletRequest req, HttpServletResponse resp) {
		OrderServiceImpl order=new OrderServiceImpl();
		List<Order_Detail> findAllDetail = order.findAllDetail();
		req.getSession().setAttribute("orderDetails", findAllDetail);
		try {
			resp.sendRedirect("production/tables_order_detail.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id=req.getParameter("id");
		PrintWriter out = resp.getWriter();
		int delete = ordSer.delete(id);
		if(delete>0){
			out.print("<script>alert('删除成功!');</script>");
			resp.sendRedirect("/forge_CMS/order?method=findAll");
		}else{
			out.print("<script>alert('删除成功!');</script>");
			resp.sendRedirect("/forge_CMS/order?method=findAll");

		}
	}

	private void updateById(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, ParseException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String orderid=req.getParameter("orderid");
		int id=Integer.valueOf(orderid);
		String name=req.getParameter("loginName");
		String time=req.getParameter("time");
		String address=req.getParameter("address");
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date createTime = sm.parse(time);
		String money=req.getParameter("money");
		Double parseMoney=Double.valueOf(money);
		String serialNumber=req.getParameter("serialNumber");
		Order order=new Order(id,name,createTime, address,parseMoney,serialNumber);
		System.out.println(order);
		int update = ordSer.update(id, order);
		if(update>0){
			resp.sendRedirect("/forge_CMS/order?method=findAll");
		}else{
			resp.setContentType("text/html;charset=GBK");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
			out.print("<script>");
			out.print("alert('因服务器或内部错误修改失败!');");
			out.print("window.location.href='/forge_CMS/order?method=findAll'");
			out.print("</script>");
			out.flush();
			out.close();
		}
		
	}

	private void findOne(HttpServletRequest req, HttpServletResponse resp) {
		String id= req.getParameter("id");
		Order order = ordSer.findById(id);
		req.setAttribute("order", order);
		String express=null;
		if(order.getStatus()==1){
			express="正在运送中";
		}else if(order.getStatus()==2){
			express="转运中";
		}else if(order.getStatus()==3){
			express="正在派送中";
		}else{
			express="订单已签收";
		}
		req.setAttribute("express", express);
		try {
			req.getRequestDispatcher("production/tables_order_Info.jsp").forward(req, resp);
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
			resp.sendRedirect("/forge_CMS/order?method=findOne&id="+id+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Order> orderList = ordSer.findAll();
		req.getSession().setAttribute("orderList", orderList);
		resp.sendRedirect("production/tables_order.jsp");

	}



}
