package com.jsc.utils;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class TokenUtils {

	public static String getToken() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static boolean isUnique(HttpServletRequest req) {
		if(req.getParameter("unToken") == null) {
			return true;
		}
		if(req.getSession().getAttribute("unToken") == null) {
			return true;
		}
		return false;
	}
}
