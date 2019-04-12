package com.jsc.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsc.dao.UserHistoryDaoImpl;
import com.jsc.domain.User;
import com.jsc.domain.UserHistory;
import com.jsc.service.UserService;
import com.jsc.service.UserServiceImpl;

@WebServlet("/Delete_User")
public class DeleteUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UserService us;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			us = new UserServiceImpl();
			int userId = Integer.valueOf(req.getParameter("id"));
			String operator_User = req.getParameter("operator_User");
			User user = us.getUserByUserId(userId);
			if(!user.getType().equals("admin")) {
				us.delete_User(userId);
			}
			new UserHistoryDaoImpl().add_UserHistory(new UserHistory(user.getId(), user.getUsername(), user.getPassword(), user.getType(), operator_User, new Date()));
			req.getRequestDispatcher("PagingServlet").forward(req, resp);
		}catch (Exception e) {
			resp.sendRedirect("Error.jsp");
		}
	}
}
