package com.jsc.action;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsc.domain.User;
import com.jsc.utils.JdbcConnectionUtils;
import com.jsc.utils.PagingUtils;

@WebServlet("/PagingServlet")
public class PagingServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static HttpSession session;
	private static ResultSet rs;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			session = req.getSession();
			User user = (User) session.getAttribute("user");
			if(user.getType().equals("admin")) {
				rs = JdbcConnectionUtils.getConnection().createStatement().executeQuery(" SELECT COUNT(*) FROM user ");
				rs.next();
				int line = 1;
				int count = rs.getInt(1);
				int maxPage = (int) Math.ceil(((double)count/5));
				if(req.getParameter("line") != null) {
					line = Integer.valueOf(req.getParameter("line"));
					session.setAttribute("UserList", PagingUtils.getUserList(line));
				}else {
					session.setAttribute("UserList", PagingUtils.getUserList(line));
				}
				session.setAttribute("line", line);
				session.setAttribute("page", (line/5) + 1);
				session.setAttribute("maxPage", maxPage);
				session.setAttribute("user", user);
				resp.sendRedirect("Admin.jsp");
			}else {
				int list = 1;
				rs = JdbcConnectionUtils.getConnection().createStatement().executeQuery(" SELECT * FROM user WHERE id = "+user.getId()+" ");
				rs.next();
				session.setAttribute("user", new User(rs.getInt(list++), rs.getString(list++), rs.getString(list++), rs.getString(list++)));
				resp.sendRedirect("User.jsp");
			}
		} catch (Exception e) {
			resp.sendRedirect("Error.jsp");
		}
	}
}
