package com.xh.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bean.Forge_Users_Tracks;
import com.xh.bean.User;
import com.xh.dao.lmpl.Forge_Users_TracksDaoImpl;
import com.xh.service.Forge_Users_TracksService;
import com.xh.servicelmpl.Forge_Users_TracksServiceImpl;

@WebFilter("/page.jsp")
public class PageFilter implements Filter {
	// 如果user不为空才增加浏览记录
	Forge_Users_TracksService traSer = new Forge_Users_TracksServiceImpl();

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String id = req.getParameter("id");
		System.out.println("pageFilter------>" + id);
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			Forge_Users_Tracks track = new Forge_Users_Tracks();
			// 先获取所有的浏览记录，如果相同再添加，如果不同不添加
			List<Forge_Users_Tracks> findAllTrack = traSer
					.findAll(user.getId());
			if (!findAllTrack.isEmpty()) {

				Forge_Users_TracksDaoImpl dao = new Forge_Users_TracksDaoImpl();

				Forge_Users_Tracks BiId = null;

				BiId = dao.selectById(user.getId(), id);

				System.out.println(BiId);
				if (BiId.getProductId() != null) {
					traSer.update(user.getId(), id);
					chain.doFilter(req, resp);
				} else if (BiId.getProductId() == null) {
					// 如果id不同，就添加
					traSer.addTrack(user.getId(), id);
					chain.doFilter(req, resp);
				}
			} else {
				// 如果id不同，就添加
				traSer.addTrack(user.getId(), id);
				chain.doFilter(req, resp);
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
