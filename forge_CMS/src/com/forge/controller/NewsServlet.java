package com.forge.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.forge.bean.News;
import com.forge.service.NewsService;
import com.forge.service.impl.NewsServiceImpl;

@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private NewsService newsSer = new NewsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		switch (method) {
		case "message":
			try {
				message(req, resp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case "upload":
			try {
				upload(req, resp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		default:
			break;
		}
	}

	private void upload(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException, ParseException {
		System.out.println("临时文件存放的位置：====》"
				+ System.getProperty("java.io.tmpdir"));
		News news = new News();
		// 创建factory对象 可以设置缓冲区大小 以及存放位置
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 判断是否是文件上传类型
		boolean flag = upload.isMultipartContent(req);
		if (flag) { // form表单是文件上传类型
			try {
				List<FileItem> items = upload.parseRequest(req);// 获取所有的表单元素
				Iterator<FileItem> its = items.iterator();
				while (its.hasNext()) {
					FileItem item = its.next();
					// 判断表单元素是什么类型
					// 证明是文件的元素
					String uploadPath = req.getSession().getServletContext()
							.getRealPath("upload/");
					// 创建upload文件夹
					File file = new File(uploadPath);
					if (!file.exists()) {
						file.mkdirs();
					}
					String fileName = item.getName();// 获取上传文件的名称
					System.out.println(fileName);
					/*
					 * if (!"".equals(fileName) && null != fileName) { File
					 * saveFile = new File(uploadPath, fileName);
					 * item.write(saveFile); news.setImg(uploadPath + "\\" +
					 * fileName);// System.currentTimeMillis() }
					 */
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * boolean f = service.addNews(news); if (f) {
			 * System.out.println("成功"); } else { System.out.println("失败"); }
			 */
		}
	}

	private void message(HttpServletRequest req, HttpServletResponse resp)
			throws ParseException {
		String title = req.getParameter("title");
		String time = req.getParameter("datetime");
		String content = req.getParameter("descr");
		boolean add = newsSer.add(new News(title, content,
				new SimpleDateFormat("dd/MM/yy").parse(time)));
		if (add) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}

}
