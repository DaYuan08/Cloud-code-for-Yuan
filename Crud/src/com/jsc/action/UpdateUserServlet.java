package com.jsc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsc.dao.UserDaoImpl;
import com.jsc.domain.User;

@WebServlet("/Update_User")
public class UpdateUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int userId = Integer.valueOf(req.getParameter("userId"));
			if(req.getParameter("newUsername") != null && req.getParameter("newPassword") != null) {
				String newUsername = req.getParameter("newUsername");
				String newPassword = req.getParameter("newPassword");
				new UserDaoImpl().update_User(new User(userId, newUsername, newPassword));
				req.getRequestDispatcher("PagingServlet").forward(req, resp);
			}else {
				req.getSession().setAttribute("userId", userId);
				resp.sendRedirect("Update.jsp");
			}
		}catch (Exception e) {
			resp.sendRedirect("Error.jsp");
		}
	}
}
