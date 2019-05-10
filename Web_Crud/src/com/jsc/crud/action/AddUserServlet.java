package com.jsc.crud.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsc.crud.domain.User;
import com.jsc.crud.service.UserServiceImpl;
import com.jsc.crud.utils.FileUtils;

@WebServlet("/add")
@MultipartConfig
public class AddUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String workExperiencesex = req.getParameter("worktime");
		String sex = req.getParameter("sex");
		//获取项目名
		String storeDir = req.getServletContext().getRealPath("/");
		String headerPath = FileUtils.getHeaderPath(req.getPart("headerPath"), storeDir);
		String birthDay = req.getParameter("birthDay");
		new UserServiceImpl().addUser(new User(name, Double.valueOf(workExperiencesex), Integer.valueOf(sex), headerPath, birthDay));
		resp.sendRedirect(req.getHeader("referer"));
	}
}
