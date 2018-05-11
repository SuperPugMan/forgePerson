package com.forge.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/news")
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
		case "findAll":
			findAll(req,resp);
			break;
		case "findById":
			findById(req,resp);
			break;
		case "update":
			update(req,resp);
			break;
		case "delete":
			delete(req,resp);
			break;
		default:
			break;
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id=req.getParameter("id");
		PrintWriter out = resp.getWriter();
		int delete = newsSer.delete(id);
		System.out.println(delete);
		if(delete>0){
			out.print("<script>alert('删除成功!');</script>");
			resp.sendRedirect("/forge_CMS/news?method=findAll");
		}else{
			out.print("<script>alert('删除失败!');</script>");
			resp.sendRedirect("/forge_CMS/news?method=findAll");

		}
	}

	private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		News news = newsSer.findById(id);
		if(news.getImg()!=null){
			int start = news.getImg().lastIndexOf("/");  
	        if (start != -1 ) {  
	        	news.setImg(news.getImg().substring(start + 1));
	        }
		  }else{
			  news.setImg("此新闻无图片");
		  }
		req.setAttribute("news", news);
		req.getRequestDispatcher("production/tables_news_Info.jsp").forward(req, resp);
		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id=req.getParameter("id");
		String title=req.getParameter("newstitle");
		String content=req.getParameter("newscontent");
		News news=new News();
		news.setContent(content);
		news.setTitle(title);
		int num = newsSer.update(id, news);
		PrintWriter out = resp.getWriter();
		if(num>0){
			resp.sendRedirect("/forge_CMS/news?method=findAll");
		}else{
			out.print("<script>alert('更新失败,请重新更新!');</script>");
			req.getRequestDispatcher("production/tables_news_Info.jsp");
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		List<News> news = newsSer.findAll();
		for (News news2 : news) {
			if(news2.getImg()!=null){
				int start = news2.getImg().lastIndexOf("/");  
		        if (start != -1 ) {  
		            news2.setImg(news2.getImg().substring(start + 1));
		        }
			  }
			}
		req.getSession().setAttribute("newsList", news);
		try {
			resp.sendRedirect("production/tables_news.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void message(HttpServletRequest req, HttpServletResponse resp)
			throws ParseException, IOException {
		// 创建New对象
		News news = new News();
		System.out.println("临时文件的存放位置：--->"
				+ System.getProperty("java.io.tmpdir"));
		// 创建Factory对象 可以设置缓冲区大小 以及存储位置
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 判断是否是文件上传类型
		boolean flag = upload.isMultipartContent(req);
		// 如果是文件上传类型
		if (flag) {
			try {
				// 获取所有的表单元素
				List<FileItem> items = upload.parseRequest(req);
				Iterator<FileItem> its = items.iterator();
				// 遍历表单元素
				while (its.hasNext()) {
					// 获取遍历器
					FileItem item = its.next();
					// 判断表单是什么元素
					if (item.isFormField()) {
						// 若是普通元素
						String fieldName = item.getFieldName();
						switch (fieldName) {
						case "title":
							news.setTitle(item.getString("UTF-8"));
							break;
						case "time":
							news.setCreateTime(new SimpleDateFormat("dd/MM/yy")
									.parse(item.getString("UTF-8")));
							break;
						case "content":
							news.setContent(item.getString("UTF-8"));
							break;
						}
					} else {
						// 若是文件元素
						String uploadPath = req.getSession()
								.getServletContext().getRealPath("upload/"+System.currentTimeMillis()+"");
						// 创建upload文件夹
						File file = new File(uploadPath);
						if (!file.exists()) {
							file.mkdirs();
						}
						// 获取上传文件的名称
						String fileName = item.getName();
						System.out.println(fileName);
						if (!"".equals(fileName) && null != fileName&&(fileName.contains("jpg")||fileName.contains("png")||fileName.contains("gif"))) {
							File saveFile = new File(uploadPath, fileName);
							item.write(saveFile);
							news.setImg(uploadPath + "\\" + fileName);
						}else{
							resp.setContentType("text/html;charset=GBK");
							PrintWriter out = resp.getWriter();
							out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
							out.print("<script>");
							out.print("alert('新闻添加失败,请检查文件上传格式!');");
							out.print("window.location.href='production/form_upload.jsp'");
							out.print("</script>");
							out.flush();
							out.close();

						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			boolean add = newsSer.addOne(news);
			if (add) {
				resp.setContentType("text/html;charset=GBK");
				PrintWriter out = resp.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
				out.print("<script>");
				out.print("alert('新闻添加成功!');");
				out.print("window.location.href='table_news.jsp'");
				out.print("</script>");
				out.flush();
				out.close();
			} else {
				resp.setContentType("text/html;charset=GBK");
				PrintWriter out = resp.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
				out.print("<script>");
				out.print("alert('新闻添加失败，请重新添加!');");
				out.print("window.location.href='production/form_upload.jsp'");
				out.print("</script>");
				out.flush();
				out.close();
			}		
		}
	}
}
