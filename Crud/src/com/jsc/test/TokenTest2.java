package com.jsc.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsc.utils.TokenUtils;

@WebServlet("/TokenTest2")
public class TokenTest2 extends HttpServlet{

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
		if(TokenUtils.isUnique(req)) {
			System.out.println("失败 ："+req.getParameter("unToken"));
			System.out.println("失败 ："+req.getAttribute("unToken"));
			System.out.println("重复提交.");
		}else {
			System.out.println("成功 ："+req.getParameter("unToken"));
			System.out.println("成功 ："+req.getAttribute("unToken"));
			System.out.println("提交成功.");
			req.getSession().removeAttribute("unToken");
		}
	}
}
