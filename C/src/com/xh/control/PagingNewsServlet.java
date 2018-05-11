package com.xh.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xh.bean.News;
import com.xh.service.NewsServiceDao;
import com.xh.servicelmpl.NewsServicelmpl;
import com.xh.util.PageInfo;

/**
 * 
 * @author LSZ
 * 
 *         2018-4-30上午10:33:51 Ajax异步获取数据，并通过循环输出在页面
 * 
 */
@WebServlet("/list")
public class PagingNewsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/*
		 * req.setCharacterEncoding("utf-8");
		 * resp.setCharacterEncoding("utf-8");
		 */

		NewsServiceDao newsServletlmpl = new NewsServicelmpl();

		// 获取到数据数据显示的页数下标>>PageInf工具类
		PageInfo<News> news = newsServletlmpl.findAlls(
				Integer.parseInt(req.getParameter("pageNum")), 6);
		// 给当前页赋值
		news.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		// 总页面赋值
		news.setTotal(newsServletlmpl.getTotalCount());

		// 谷歌的jar的类
		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss")
				.create();
		// 把数据转换为json格式
		String json = gson.toJson(news);
		// 获取输出流对象
		PrintWriter writer = resp.getWriter();
		// 返回数据给前台页面
		writer.print(json);
		/*
		 * 前台通过success : function(data) { 到数据[writer.print(json); 的json数据] var
		 * data = $.parseJSON(data); }
		 */
		// 清空、关闭流
		writer.flush();
		writer.close();

	}

}
