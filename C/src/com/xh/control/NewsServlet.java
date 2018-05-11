package com.xh.control;



import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.xh.bean.News;
import com.xh.dao.NewsDao;
import com.xh.dao.lmpl.NewsDaolmpl;
import com.xh.service.NewsServiceDao;
import com.xh.servicelmpl.NewsServicelmpl;





@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {


	private static StringBuffer  url;


	//private static Logger logger=Logger.getLogger(clazz);


	NewsServiceDao service_news=new NewsServicelmpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置post乱码
		System.err.println("================================");
		/*req.setCharacterEncoding("utf-8");*/
		String method = req.getParameter("method");
		System.out.println(method);
		switch (method) {
		case "addNews":
			add_news(req, resp);    // 新增新闻的方法
			break;

		case "getAllNews":
			findAllNews(req, resp); // 查询的方法

			break;
		case "findById":
			findById(req, resp);    // 查询的方法
			break;
		case "delNews":
			delNews(req, resp);     // 删除的方法
			break;
		case "updateNews":
			updateNews(req, resp);  // 修改方法
			break;

		default:
			break;
		}



	}

	/**
	 * 获取用户传递过来的id
	 * 根据id查询这个新闻的详情   跳转到修改页面（会显示新闻的详情）
	 */
	private void findById(HttpServletRequest req, HttpServletResponse resp) {


		String id = req.getParameter("id");
		System.err.println(id+"----------------------");
		News news = service_news.select_Id(id);
		// 保存在request作用域
		req.setAttribute("news", news);
		try {
			req.getRequestDispatcher("backstage/new_edit.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	// 查询的方法
	private void findAllNews(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("进入了 findAll查询所有的方法");

		List<News> newsList = service_news.select();

		// 把集合保存在request作用域中
		req.setAttribute("newsList", newsList);
		try {


			/*	for (News news : newsList) {
				System.err.println(news);
			}*/
			// 转发到主页面
			req.getRequestDispatcher("/backstage/New.jsp").forward(req, resp); 


		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	// 修改新闻
	private void updateNews(HttpServletRequest req, HttpServletResponse resp) {



		News news=add_update(req);

		String img = service_news.select_Id(news.getId()).getImg();
		boolean	flag = service_news.updata(news);


		if (flag) {

			File file=new File("F:\\LSL\\Tomcat\\apache-tomcat-9.0.6\\webapps\\C\\upload\\"+img);
			if (file!=null&&file.isFile()) {
				file.delete();
			}				

			try {

				resp.sendRedirect("NewsServlet?method=getAllNews");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//跳转查询所有
		} else {


			File file=new File("F:\\LSL\\Tomcat\\apache-tomcat-9.0.6\\webapps\\C\\upload\\"+news.getImg());
			if (file!=null&&file.isFile()) {
				file.delete();

			}	
			try {
				resp.sendRedirect("NewsServlet?method=findById&id="+news.getId());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//
		}	




		/**

		// 创建News对象
		News news = new News();

		System.out.println("文件存放的位置在项目里："
				+ System.getProperty("java.io.tmpdir"));
		// 创建factory对象 可以设置缓冲区大小 以及存放位置
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 判断是否是上传文件类型
		boolean flag = upload.isMultipartContent(req);
		if (flag) { // form表单是文件上传类型
			try {
				List<FileItem> items = upload.parseRequest(req);// 获取所有的表单元素
				Iterator<FileItem> its = items.iterator();
				while (its.hasNext()) {
					FileItem item = its.next();
					// 判断表单元素是什么类型


					if (item.isFormField()) { // 证明是普通的元素
						String fieldName = item.getFieldName();// title context
						// createTime
						switch (fieldName) {

						case "id":
							news.setId(Integer.valueOf(item.getString("UTF-8")));	

							news.setCreateTime(req.getParameter("createTime"));
							break;

						case "createTime":
							news.setCreateTime(new SimpleDateFormat("dd/MM/yy")
									.parse(item.getString("UTF-8")));	

							news.setCreateTime(req.getParameter("createTime"));
							break;


						case "module":

							news.setModule(item.getString("UTF-8"));	

							news.setCreateTime(req.getParameter("createTime"));
							break;
						case "title":
							news.setTitle(item.getString("UTF-8"));
							break;

						case "content":
							news.setContent(item.getString("UTF-8"));
							break;
						}


					} else {// 证明是上传文件的元素也就是name 属性值 
						String uploadPath = req.getSession().getServletContext().getRealPath("upload/");//获取到路径
						// 创建upload文件夹
						File file = new File(uploadPath);
						if (!file.exists()) {//不存在就创建
							file.mkdirs();//多级文件创建
						}


						String fileName = item.getName();// 获取上传文件的名称

						//fileName = new String(fileName.getBytes(), "utf-8");// 解决中文乱码可以去除



						if (!"".equals(fileName) && null != fileName) {//判断不是为空的值


							long currentTimeMillis = System.currentTimeMillis();
							// System.currentTimeMillis();防止文件被覆盖


							//							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
							//							String format = sdf.format(new Date());
							//System.out.println("format()===》把日期转换成String类型的数据：" + sdf.format(new Date()));



							//url=new StringBuffer(format+currentTimeMillis+fileName.substring(fileName.lastIndexOf(".")));

							String url=currentTimeMillis+fileName.substring(fileName.lastIndexOf("."));
							File saveFile = new File(uploadPath,url);

							item.write(saveFile);



							//取得对象的图片路径
							//System.out.println(saveFile.getAbsolutePath()+"==============="+fileName);

							//news.setImg(uploadPath+url);

							news.setImg(url);
							//news.setImg(uploadPath + "\\" +System.currentTimeMillis()+ fileName);


						}
					}

				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			}
		 */




	}

	private void delNews(HttpServletRequest req, HttpServletResponse resp) {


		boolean flag = service_news.delete(req.getParameter("id"));
		if (flag) {
			
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		
		try {
			resp.sendRedirect("NewsServlet?method=getAllNews");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*	try {
			resp.sendRedirect("NewsServlet?method=getAllNews");
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}


	private void add_news(HttpServletRequest req, HttpServletResponse resp) {





		News news = add_update(req);

		boolean add = service_news.add(news);

		if (add) {

		} else {

			File file=new File("F:\\LSL\\Tomcat\\apache-tomcat-9.0.6\\webapps\\C\\upload\\"+news.getImg());
			if (file!=null&&file.isFile()) {
				
				file.delete();
			}	
			System.out.println("新增失败！");

		}


	}

	private News add_update(HttpServletRequest req) {
		// 创建News对象
		News news = new News();

		System.out.println("文件存放的位置在项目里："
				+ System.getProperty("java.io.tmpdir"));
		// 创建factory对象 可以设置缓冲区大小 以及存放位置
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 判断是否是上传文件类型
		boolean flag = upload.isMultipartContent(req);
		if (flag) { // form表单是文件上传类型
			try {
				List<FileItem> items = upload.parseRequest(req);// 获取所有的表单元素
				Iterator<FileItem> its = items.iterator();
				while (its.hasNext()) {
					FileItem item = its.next();
					// 判断表单元素是什么类型
					if (item.isFormField()) { // 证明是普通的元素
						String fieldName = item.getFieldName();// title context
						// createTime
						switch (fieldName) {

						case "id":

							news.setId(Integer.valueOf(item.getString("UTF-8")));	

							break;
						case "createTime":

							/*news.setCreateTime(new SimpleDateFormat("dd/MM/yy")
							.parse(item.getString("UTF-8")));	*/
							/*news.setCreateTime(req.getParameter("createTime"));*/

							break;


						case "module":

							news.setModule(item.getString("UTF-8"));	
							/*news.setCreateTime(req.getParameter("createTime"));*/
							
							break;
						case "title":
							news.setTitle(item.getString("UTF-8"));
							break;

						case "content":
							news.setContent(item.getString("UTF-8"));
							break;
						}


					} else {// 证明是上传文件的元素也就是name 属性值 

						String uploadPath = req.getSession()
								.getServletContext().getRealPath("upload/");//获取到路径
						// 创建upload文件夹
						File file = new File(uploadPath);
						if (!file.exists()) {//不存在就创建
							file.mkdirs();//多级文件创建
						}
						String fileName = item.getName();// 获取上传文件的名称

						//fileName = new String(fileName.getBytes(), "utf-8");// 解决中文乱码可以去除

						if (!"".equals(fileName) && null != fileName) {//判断不是为空的值，为空就不写入数据库
							long currentTimeMillis = System.currentTimeMillis();
							// System.currentTimeMillis();防止文件被覆盖
							//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
							//String format = sdf.format(new Date());
							//System.out.println("format()===》把日期转换成String类型的数据：" + sdf.format(new Date()));
							//url=new StringBuffer(format+currentTimeMillis+fileName.substring(fileName.lastIndexOf(".")));

							//毫秒+截取图片的后缀.png
							String url=currentTimeMillis+fileName.substring(fileName.lastIndexOf("."));
							//
							File saveFile = new File(uploadPath,url);
							//写入文件里
							item.write(saveFile);
							//取得对象的图片路径
							//System.out.println(saveFile.getAbsolutePath()+"==============="+fileName);
							news.setImg(url);

						}
					}

				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return news;
	}
}


