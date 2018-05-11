package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xh.bean.News;
import com.xh.dao.NewsDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;

/**
 * 
 * @author LSZ
 *
 * 非宁静无以致远！
 * 2018-4-30上午10:40:41   新闻Dao层访问数据库，返回前端页面
 *
 */

public class NewsDaolmpl extends JdbcUtil implements NewsDao {

	@Override
	public int add(News t) {

		StringBuffer bf11=new StringBuffer();	
		StringBuffer bf=new StringBuffer();	
		StringBuffer na=new StringBuffer();	
		List<Object> list=new ArrayList();
		List<String> str=new ArrayList();
		List<String> name=new ArrayList();

		if (t.getContent()!=null) {
			list.add(t.getContent());   str.add("?");name.add("content");
		}
		if (t.getCreateTime()!=null) {
			list.add(t.getCreateTime());   str.add("?");name.add("createTime");
		}
		if (t.getImg()!=null) {
			list.add(t.getImg());   str.add("?");name.add("img");
		}
		if (t.getTitle()!=null) {
			list.add(t.getTitle());   str.add("?");name.add("title");
		}
		if (t.getModule()!=null) {
			list.add(t.getModule());   str.add("?");name.add("module");
		}
		
		for (int i = 0; i < str.size(); i++) {
			if (i==str.size()-1) {
				bf11.append(str.get(i));
			}else {
				bf11.append(str.get(i)+",");
			}
		}
		for (int i = 0; i < name.size(); i++) {
			if (i==name.size()-1) {
				na.append(name.get(i));
			}else {
				na.append(name.get(i)+",");
			}
		}
		Object[] params=new Object[list.size()];
		for (int i = 0; i < params.length; i++) {
			params[i]=list.get(i);
		}
		String sql = "INSERT INTO `easybuy_news`("+na.toString()+")VALUES("+bf11.toString()+")";
		int rowNum = 0;
		rowNum = exceuteUpdate(sql, params);
		return rowNum;
	}


	@Override
	public int delete(Serializable id) {
		
		String sql = "DELETE FROM easybuy_news WHERE id=? ";
//		Object[] parmas = { id };
		int rowNum = 0;
		rowNum = exceuteUpdate(sql, id);
		return rowNum;

	}

	@Override
	public int update(News t) {








		/*t.getCreateTime(),createTime=?*/


		StringBuffer bf11=new StringBuffer();

		StringBuffer bf=new StringBuffer();	

		List<Object> list=new ArrayList();
		List<String> str=new ArrayList();



		if (t.getContent()!=null) {
			list.add(t.getContent());   str.add("content=? ");
		}
		if (t.getCreateTime()!=null) {
			list.add(t.getCreateTime());   str.add("createTime=? ");
		}
		if (t.getImg()!=null) {
			list.add(t.getImg());   str.add("img=? ");
		}
		if (t.getTitle()!=null) {
			list.add(t.getTitle());   str.add("title=? ");
		}
		if (t.getModule()!=null) {
			list.add(t.getModule());   str.add("module=? ");
		}



		for (int i = 0; i < str.size(); i++) {

			if (i==str.size()-1) {
				bf11.append(str.get(i));
			}else {
				bf11.append(str.get(i)+",");
			}


		}

		String sql="update easybuy_news set "+bf11.toString()+" where id=?";


		Object[] params=new Object[list.size()+1];

		for (int i = 0; i < params.length-1; i++) {
			params[i]=list.get(i);

		}
		params[list.size()]=t.getId();








		int rowNum = 0;

		rowNum = exceuteUpdate(sql, params);

		return rowNum;
	}

	@Override
	public List<News> selectAll() {
		String sql = "select * from easybuy_news";
		//创建一个集合保存所有新闻信息
		List<News> newss = new ArrayList<>();

		try {
			result = exceuteQuery(sql);

			newss=ResultSet_Util.selectAllsa(result, News.class);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAss(conn, pre, result);
		}

		return newss;
	}


	@Override
	public News select_Id(Serializable id) {

		String sql = "select * from easybuy_news where id=?";
		// 给参数赋值
		Object[] params = { id };
		News user = null;
		try {
			result = exceuteQuery(sql, params);
			user = ResultSet_Util.selectAlla(result, News.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close_();


		}

		System.err.println(user+"++++++++++++++++++++++++++++++++++++++++++++");
		return user;
	}


	@Override
	public List<News> findAlls(int pageNum, int pageSize) {		
		
		String sql = "select * from easybuy_news limit ?,?";

		//创建一个集合保存分页新闻信息
		List<News> newss = new ArrayList<>();
		Object[] params={pageNum,pageSize};

		try {
			result = exceuteQuery(sql,params);

			newss=ResultSet_Util.selectAllsa(result, News.class);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAss(conn, pre, result);
		}
		
		return newss;

	}


	@Override
	public int getTotalCount() {
		
		//访问数据库的sql
		String sql = "select count(*) as 'count' from easybuy_News";
		int count=0;
		try {
			//因为这里生产一个伪表，列名为'count'
			result= exceuteQuery(sql);

			if (result.next()) {
				count = result.getInt("count");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAss(conn, pre, result);
		}
		return count;
	}

}

