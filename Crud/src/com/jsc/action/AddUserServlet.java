package com.jsc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsc.domain.User;
import com.jsc.service.UserServiceImpl;

@WebServlet("/Add_User")
public class AddUserServlet extends HttpServlet {

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
		try{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String type = req.getParameter("type");
			if(username != null && password != null) {
				User newUser = new User(username, password, type);
				new UserServiceImpl().add_User(newUser);
				resp.sendRedirect("UserSystem.html");
			}else {
				resp.sendRedirect("Register.html");
			}
		}catch (Exception e) {
			resp.sendRedirect("Error.jsp");
		}
	}
}
