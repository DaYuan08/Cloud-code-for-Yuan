package com.jsc.crud.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsc.crud.domain.User;
import com.jsc.crud.service.UserService;
import com.jsc.crud.service.UserServiceImpl;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {

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
		String name = req.getParameter("name") == null || req.getParameter("name").trim().length() == 0 ? "%" : req.getParameter("name");
		String sex = req.getParameter("sex") == null || Integer.valueOf(req.getParameter("sex")) == 0 ? "%" : req.getParameter("sex");
		String workTimeStart = req.getParameter("workTimeStart") == null || req.getParameter("workTimeStart").trim().length() == 0 ? "0" : req.getParameter("workTimeStart");
		String workTimeEnd = req.getParameter("workTimeEnd") == null || req.getParameter("workTimeEnd").trim().length() == 0 ? "150" : req.getParameter("workTimeEnd");
		String birthDayStart = req.getParameter("birthDayStart") == null || req.getParameter("birthDayStart").trim().length() == 0 ? "0001-01-01" : req.getParameter("birthDayStart");
		String birthDayEnd = req.getParameter("birthDayEnd") == null || req.getParameter("birthDayEnd").trim().length() == 0 ? "9999-12-31" : req.getParameter("birthDayEnd");
		int cpage = req.getParameter("cpage") == null ? 1 : Integer.valueOf(req.getParameter("cpage"));
		int pageRow = req.getParameter("pageRows") == null ? 20 : Integer.parseInt(req.getParameter("pageRow"));
		
		UserService us = new UserServiceImpl();
		List<User> userList = us.userList(name, sex, workTimeStart, workTimeEnd, birthDayStart, birthDayEnd, cpage, pageRow);
		int maxPage = us.getMaxPage(name, sex, Double.valueOf(workTimeStart), Double.valueOf(workTimeEnd), birthDayStart, birthDayEnd);
		req.setAttribute("userList", userList);
		req.setAttribute("name", name);
		req.setAttribute("sex", sex.equals("%") ? 0 : sex);
		req.setAttribute("workTimeStart", workTimeStart.equals("0") ? "" : workTimeStart);
		req.setAttribute("workTimeEnd", workTimeEnd.equals("150") ? "" : workTimeEnd);
		req.setAttribute("birthDayStart", birthDayStart.equals("0001-01-01") ? "" :birthDayStart);
		req.setAttribute("birthDayEnd", birthDayEnd.equals("9999-12-31") ? "" :birthDayEnd);
		req.setAttribute("cpage", cpage);
		req.setAttribute("pageRow", pageRow);
		req.setAttribute("maxPage", maxPage);
		req.getRequestDispatcher("crud.jsp").forward(req, resp);
	}
}
