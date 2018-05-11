package com.xh.service;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Forge_Users_Tracks;

public interface Forge_Users_TracksService extends
		BaseService<Forge_Users_Tracks> {

	// 增加足迹
	void addTrack(int userId, String id);

	List<Forge_Users_Tracks> findAll(Serializable userId);

	void update(Serializable userId, String productId);

}
