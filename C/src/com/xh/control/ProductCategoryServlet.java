package com.xh.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.fabric.xmlrpc.base.Array;

import com.xh.bean.Product;
import com.xh.bean.ProductCategory;
import com.xh.service.ProductCategoryService;
import com.xh.servicelmpl.ProductCategoryServiceImpl;

//@WebServlet("/ProductCategoryServlet")
public class ProductCategoryServlet extends HttpServlet {


	ProductCategoryService p=new ProductCategoryServiceImpl();
	//	List<ProductCategory> product = p.getProduct();//1
	//List<ProductCategory> product2=null;//2
	//List<List<ProductCategory>> productda=new ArrayList<>();//2
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println(req.getParameter("id")+"====2id=3级");

		String key=req.getParameter("methon");
		//System.err.println(key+"====2id=3级");
		//ProductCategoryServlet?methon=yiji


		switch (key) {
		case "yiji":			
			getProductCategory(req,resp);						
			break;

		case "erji":

			getProductCategoryEj(req,resp);

			break;
			
		case "sanjiye":
			getProductCategoryESanJi(req,resp);

			break;

		default:
			break;
		}

	}

	private void getProductCategoryESanJi(HttpServletRequest req,
			HttpServletResponse resp) {




		List<Product> nameList = p.name(req.getParameter("id"));


		System.err.println("333放行==================================="+req.getParameter("id"));

		for (Product product : nameList) {
			System.err.println(product+"333放行");
		}

		req.setAttribute("mingzi", req.getParameter("mingzi"));
		req.setAttribute("iddd", nameList);

		try {
			req.getRequestDispatcher("my-all.jsp").forward(req, resp);

		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	private void getProductCategoryEj(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub

		//System.err.println("5555wang===="+req.getParameter("pageNum"));

		List<Product> product3 = p.name(req.getParameter("pageNum"));

		//上去实现就可以了
		//req.getParameter("pageNum")这个是1级菜单的主键
		//		for (int i = 0; i < product.size(); i++) {
		//			
		//			  List<ProductCategory> product3 = p.getProduct(product.get(i).getId());
		//			  
		//		  
		//			productda.add(product3);
		//			
		//		}






		Gson gson = new Gson();
		//把数据转换为json格式
		String json = gson.toJson(product3);
		// 获取输出流对象
		PrintWriter writer = resp.getWriter();



		System.err.println(json+"===================>json格式");
		// 返回数据给前台页面
		writer.print(json);      
		/*前台通过success : function(data) { 到数据[writer.print(json); 的json数据]
			var data = $.parseJSON(data);
		  }*/		
		//清空、关闭流
		writer.flush();
		writer.close();






	}

	private void getProductCategory(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {



		/*	try {

			req.setAttribute("list", product);
			req.getRequestDispatcher("index.jsp").forward(req, resp);


		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */


		//System.err.println(product+"\n-nn--------------------------------");

		Gson gson = new Gson();
		//把数据转换为json格式
		String json = gson.toJson("");
		// 获取输出流对象
		PrintWriter writer = resp.getWriter();
		// 返回数据给前台页面
		writer.print(json);      
		/*前台通过success : function(data) { 到数据[writer.print(json); 的json数据]
			var data = $.parseJSON(data);
		  }		*/
		//清空、关闭流
		writer.flush();
		writer.close();

	}



}
