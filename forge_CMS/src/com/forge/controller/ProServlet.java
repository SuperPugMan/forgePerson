package com.forge.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.mail.SendFailedException;
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
import com.forge.bean.Product;
import com.forge.bean.ProductCategory;
import com.forge.dao.impl.ProductDaoImpl;
import com.forge.service.ProductService;
import com.forge.service.impl.ProductServeicImpl;

@WebServlet(value={"/pro","/prodetail"})
public class ProServlet  extends HttpServlet{
	ProductService proSer=new ProductServeicImpl();

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
			message(req, resp);
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
		case "findAllDetail":
			findAllDetail(req,resp);
			break;
		case "addprodetail":
			addprodetail(req,resp);
			break;
		case "deleteDetail":
			deleteDetail(req,resp);
			break;
		default:
			break;
		}

	}

	private void deleteDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ProductDaoImpl pro=new ProductDaoImpl();
		String id = req.getParameter("id");
		int num = pro.deleteDetail(id);
		if(num>0){
			resp.sendRedirect("/forge_CMS/prodetail?method=findAllDetail");
		}
		
	}

	private void addprodetail(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		ProductDaoImpl pro=new ProductDaoImpl();
		String name=req.getParameter("name");
		String parentid=req.getParameter("parentid");
		ProductCategory pro1=new ProductCategory();
		pro1.setName(name);
		pro1.setParentId(Integer.valueOf(parentid));
		int addDetail = pro.addDetail(pro1);
		if(addDetail>0){
			resp.setContentType("text/html;charset=GBK");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
			out.print("<script>");
			out.print("alert('添加成功!');");
			out.print("window.location.href='/forge_CMS/prodetail?method=findAllDetail'");
			out.print("</script>");
			out.flush();
			out.close();
		}else{
			resp.setContentType("text/html;charset=GBK");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
			out.print("<script>");
			out.print("alert('添加失败，请重新添加!');");
			out.print("window.location.href='production/form_upload.jsp'");
			out.print("</script>");
			out.flush();
			out.close();

		}
		
		
	}
	private void findAllDetail(HttpServletRequest req, HttpServletResponse resp) {
		ProductDaoImpl pro=new ProductDaoImpl();
		List<ProductCategory> findAllDetail = pro.findAllDetail();
		req.getSession().setAttribute("prodetailList", findAllDetail);
		try {
			resp.sendRedirect("production/tables_product_category.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void message(HttpServletRequest req, HttpServletResponse resp) throws IOException {
				Product pro=new Product();
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
								case "name":
									pro.setName(item.getString("utf-8"));
									break;
								case "price":
									pro.setPrice(Double.valueOf(item.getString("utf-8")));
									break;
								case "stock":
									pro.setStock(Integer.valueOf(item.getString("utf-8")));
									break;
								case "level1":
									pro.setCategorylevel1(Integer.valueOf(item.getString("utf-8")));
									break;
								case "level2":
									pro.setCategorylevel2(Integer.valueOf(item.getString("utf-8")));
									break;
								case "level3":
									pro.setCategorylevel3(Integer.valueOf(item.getString("utf-8")));
									break;
								case "score":
									pro.setScore(Integer.valueOf(item.getString("UTF-8")));
									break;
								case "description":
									pro.setDescription(item.getString("utf-8"));
									break;
								}
							} else {
								// 若是文件元素
								String uploadPath = req.getSession()
										.getServletContext().getRealPath("uploadProduct/"+System.currentTimeMillis()+"");
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
									pro.setFileName(uploadPath + "\\" + fileName);
								}else{
									resp.setContentType("text/html;charset=GBK");
									PrintWriter out = resp.getWriter();
									out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
									out.print("<script>");
									out.print("alert('新闻添加失败,请检查文件上传格式!');");
									out.print("window.location.href='production/tables_product_add.jsp'");
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
					boolean add = proSer.add(pro);
					if (add) {
						resp.setContentType("text/html;charset=GBK");
						PrintWriter out = resp.getWriter();
						out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
						out.print("<script>");
						out.print("alert('添加成功!');");
						out.print("window.location.href='/forge_CMS/pro?method=findAll'");
						out.print("</script>");
						out.flush();
						out.close();
					} else {
						resp.setContentType("text/html;charset=GBK");
						PrintWriter out = resp.getWriter();
						out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");
						out.print("<script>");
						out.print("alert('添加失败，请重新添加!');");
						out.print("window.location.href='production/tables_product_add.jsp'");
						out.print("</script>");
						out.flush();
						out.close();
					}		
				}
		}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id=req.getParameter("id");
		String price=req.getParameter("price");
		String stock=req.getParameter("stock");
		String description=req.getParameter("description");
		String score=req.getParameter("score");
		Product pro=new Product();
		pro.setPrice(Double.valueOf(price));
		pro.setStock(Integer.valueOf(stock));
		pro.setDescription(description);
		pro.setScore(Integer.valueOf(score));
		PrintWriter out = resp.getWriter();
		if(proSer.update(id, pro)){
			resp.sendRedirect("/forge_CMS/pro?method=findAll");
		}else{
			out.print("<script>alert('更新失败,请重新更新!');</script>");
			req.getRequestDispatcher("production/tables_product_info.jsp");
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id=req.getParameter("id");
		PrintWriter out = resp.getWriter();
		if(proSer.delete(id)){
			out.print("<script>alert('删除成功!');</script>");
			resp.sendRedirect("/forge_CMS/pro?method=findAll");
		}else{
			out.print("<script>alert('删除失败!');</script>");
			resp.sendRedirect("/forge_CMS/pro?method=findAll");

		}

	}

	private void findById(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		Product pro = proSer.findById(id);
		if(pro.getFileName()!=null){
			int start = pro.getFileName().lastIndexOf("/");  
	        if (start != -1 ) {  
	        	pro.setFileName(pro.getFileName().substring(start + 1));
	        }
		  }else{
			  pro.setFileName("此新闻无图片");
		  }
		req.setAttribute("production", pro);
		try {
			req.getRequestDispatcher("production/tables_product_info.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		List<Product> pros = proSer.findAll();
		for (Product pro : pros) {
			if(pro.getFileName()!=null){
				int start = pro.getFileName().lastIndexOf("/");  
		        if (start != -1 ) {  
		        	pro.setFileName(pro.getFileName().substring(start + 1));
		        }
			  }
			}
		req.getSession().setAttribute("proList", pros);
		try {
			resp.sendRedirect("production/tables_product.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
