package com.jsc.crud.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsc.crud.service.UserService;
import com.jsc.crud.service.UserServiceImpl;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet{

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
		String userId = req.getParameter("userId") == null ? null : req.getParameter("userId");
		String[] userIds = req.getParameterValues("deleteIds");
		UserService us = new UserServiceImpl();
		if(userId != null) {
			us.deleteSingleUser(Integer.valueOf(userId));
		}
		if(userIds != null) {
			us.deleteMoreUser(userIds);
		}
		resp.sendRedirect(req.getHeader("referer"));
	}
}
