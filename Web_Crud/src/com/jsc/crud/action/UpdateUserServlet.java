package com.jsc.crud.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsc.crud.domain.User;
import com.jsc.crud.service.UserService;
import com.jsc.crud.service.UserServiceImpl;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {

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
		UserService us = new UserServiceImpl();
		User user = us.getUserByUserId(Integer.valueOf(req.getParameter("userId")));
		String name = req.getParameter("name").equals("") ? user.getName() : req.getParameter("name");
		double worktime = req.getParameter("worktime").equals("") ? user.getWorkExperiencesex() : Double.valueOf(req.getParameter("worktime"));
		String sex = req.getParameter("sex");
		String headerPath = req.getParameter("headerPath").equals("") ? user.getHeaderImg() : req.getParameter("headerPath");
		String birthDay = req.getParameter("birthDay").equals("") ? user.getBirthDay() : req.getParameter("birthDay");
		us.updateUser(new User(user.getId(),name, worktime, Integer.valueOf(sex), headerPath, birthDay));
		resp.sendRedirect(req.getHeader("referer"));
	}
}
