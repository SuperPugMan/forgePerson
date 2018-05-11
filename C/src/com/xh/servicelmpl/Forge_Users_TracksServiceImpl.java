package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Forge_Users_Tracks;
import com.xh.dao.Forge_Users_TracksDao;
import com.xh.dao.lmpl.Forge_Users_TracksDaoImpl;
import com.xh.service.Forge_Users_TracksService;

public class Forge_Users_TracksServiceImpl implements Forge_Users_TracksService {

	Forge_Users_TracksDao dao = new Forge_Users_TracksDaoImpl();

	@Override
	// 添加用户浏览记录
	public void addTrack(int userId, String id) {
		dao.addTrack(userId, id);
	}

	@Override
	// 查找浏览的所有商品
	public List<Forge_Users_Tracks> findAll(Serializable userId) {
		List<Forge_Users_Tracks> products = dao.findAll(userId);
		return products;
	}

	@Override
	// 更新浏览记录
	public void update(Serializable userId, String productId) {
		dao.update(userId, productId);
	}

	@Override
	public boolean updata(Forge_Users_Tracks t) {
		return false;
	}

	@Override
	public List<Forge_Users_Tracks> select() {
		return null;
	}

	@Override
	public Forge_Users_Tracks select_Id(Serializable id) {
		return null;
	}

	@Override
	public boolean add(Forge_Users_Tracks t) {
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		return false;
	}

}
