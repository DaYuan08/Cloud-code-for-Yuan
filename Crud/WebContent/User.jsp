<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jsc.domain.*" import="java.sql.* " import="javax.servlet.*" import="java.io.*" import="com.jsc.utils.JdbcConnectionUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal System.</title>
<style type="text/css">
body{text-align:center;font-size:14px;line-height:20px;}
</style>
</head>
<body>
<h2>欢迎用户 [${sessionScope.user.username}] 登入系统，以下是当前登录用户的用户信息:</h2><br/>
<table border="2px" cellpadding="8px" cellspacing="0px" align="center">
	<tr>
		<th width="80" align="center">id</th>
		<th width="100" align="center">username</th>
		<th width="100" align="center">password</th>
		<th width="100" align="center">type</th>
	</tr>
	<tr>
		<th width="80" align="center">${sessionScope.user.id}</th>
		<th width="100" align="center">${sessionScope.user.username}</th>
		<th width="100" align="center">${sessionScope.user.password}</th>
		<th width="100" align="center">${sessionScope.user.type}</th>
	</tr>
</table><br/>
<a href="Logout"><input type="button" value="Logout." style="width:88px"/></a>
</body>
</html>