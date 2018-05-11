package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import org.apache.log4j.Logger;

import com.xh.bean.Product;
import com.xh.bean.User;
import com.xh.bean.UserAddress;
import com.xh.dao.UserDao;
import com.xh.dao.lmpl.UserDaoImpl;
import com.xh.service.UserService;
import com.xh.util.Memcached;

public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	UserDao userDao = new UserDaoImpl();

	@Override
	public List<UserAddress> findAddress(Serializable id) {
		return userDao.findAddress(id);
	}

	@Override
	public String likeSelect(Serializable name) {
		List<Product> likeSelect = null;
		List<String> likename = new ArrayList<>();
		StringBuffer buf = new StringBuffer();
		MemcachedClient in = Memcached.getIn();
		// 先把所有的商品查到缓存中
		if (in.get("AllProduct") == null) {
			logger.info("从数据库中拿");
			likeSelect = userDao.likeSelect(name);
			in.set("AllProduct", 12, likeSelect);
		} else {
			logger.info("从缓存中查");
			likeSelect = (List<Product>) in.get("AllProduct");
		}
		for (Product product : likeSelect) {
			if (product.getName().contains((CharSequence) name)) {
				likename.add(product.getName());
			}

		}
		/*
		 * if (in.get("likeSelect") == null) { System.out.println("模糊查询到数据库中查");
		 * likeSelect = userDao.likeSelect(name); in.set("likeSelect", 12,
		 * likeSelect); } else { System.out.println("模糊查询到缓存中查"); likeSelect =
		 * (List<Product>) in.get("likeSelect"); }
		 */
		for (int i = 0; i < likename.size(); i++) {
			if (i > 0) {
				buf.append("," + likename.get(i));
			} else {
				buf.append(likename.get(i));
			}
		}
		logger.info("------------------>service模糊查询" + buf.toString());
		return buf.toString();
	}

	@Override
	public boolean add(User t) {
		// TODO Auto-generated method stub
		int add = userDao.add(t);
		if (add > 0) {
			logger.debug("新增成功！");
			return true;
		} else {
			logger.debug("新增失败！");
			return false;
		}
	}

	@Override
	public boolean delete(Serializable t) {
		// TODO Auto-generated method stub
		int delete = userDao.delete(t);
		if (delete > 0) {
			logger.info("更新成功！");

		} else {
			logger.info("更新失败！");
		}
		return false;

	}

	@Override
	public boolean updata(User t) {
		// TODO Auto-generated method stub

		int update = userDao.update(t);
		if (update > 0) {
			logger.info("删除成功！");

		} else {
			logger.info("删除失败！");
		}
		return false;

	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		List<User> selectAll = userDao.selectAll();

		return selectAll;
	}

	@Override
	public User select_Id(Serializable id) {
		// TODO Auto-generated method stub

		// MemcachedClient in = Memcached.getIn();
		MemcachedClient in = Memcached.getIn();

		if (in.get("user") == null) {

			logger.info("数据了拿数据！");
			User select_Id = userDao.select_Id(id);
			Memcached.getIn().set("user", 12, select_Id);
			return select_Id;

		} else {
			logger.info("缓存拿的数据！");
			return (User) Memcached.getIn().get("user");
		}

	}

	@Override
	public User login(String userName, String passWord) {

		User login = userDao.login(userName, passWord);

		if (login != null && login.getLoginName() != null) {

			logger.debug("登录 成功");
			return login;
		} else {
			logger.debug("登录失败！");
			return null;
		}

	}

	@Override
	public User loginPwd(String userName) {

		User login = userDao.loginPwd(userName);

		if (login != null && login.getLoginName() != null) {

			// logger.debug("登录 成功");
			return login;
		} else {
			// logger.debug("登录失败！");
			return null;
		}
	}

}
