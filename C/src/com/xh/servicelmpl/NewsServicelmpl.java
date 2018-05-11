package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.xh.bean.News;
import com.xh.dao.NewsDao;
import com.xh.dao.lmpl.NewsDaolmpl;
import com.xh.service.NewsServiceDao;
import com.xh.util.PageInfo;

/**
 * 
 * @author LSZ
 * 
 *         2018-4-30上午10:39:40 这个是逻辑层
 * 
 */

public class NewsServicelmpl implements NewsServiceDao {

	private static Logger logger = Logger.getLogger(NewsServicelmpl.class);

	//
	NewsDao news = new NewsDaolmpl();

	@Override
	public boolean add(News t) {
		if (news.add(t) > 0) {
			return true;
		}
		return false;

	}

	@Override
	public boolean delete(Serializable id) {

		int delete = news.delete(id);

		if (delete > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updata(News t) {

		int update = news.update(t);

		if (update > 0) {

			return true;

		}

		return false;
	}

	@Override
	public List<News> select() {
		// TODO Auto-generated method stub

		return news.selectAll();
	}

	@Override
	public News select_Id(Serializable id) {

		return news.select_Id(id);

	}

	@Override
	public PageInfo<News> findAlls(int pageNum, int pageSize) {

		PageInfo<News> pageInfo = new PageInfo<>();

		if (pageNum != 0) {// 因为前端的分页符没下标1的，跳了加1,===>0,2,3,4,5,6
			pageNum = pageNum * 6 - 6;// 做处理把2转换为1
		}
		// 获取分页后的新闻记者集合，并赋值给 PageInfo<News>，对象 当前页pageNum，显示的条数pageSize
		pageInfo.setList(news.findAlls(pageNum, pageSize));

		return pageInfo;
	}

	@Override
	public int getTotalCount() {

		return news.getTotalCount();
	}

}
