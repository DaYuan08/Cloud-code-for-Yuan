package com.jsc.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsc.utils.TokenUtils;

@WebServlet("/TokenTest")
public class TokenTest extends HttpServlet{

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
		String unToken = TokenUtils.getToken();
		System.out.println(unToken);
		req.getSession().setAttribute("unToken", unToken);
		resp.sendRedirect("Test.jsp");
	}
}
