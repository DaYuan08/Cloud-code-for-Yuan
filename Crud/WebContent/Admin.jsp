<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="com.jsc.domain.*" import="java.sql.ResultSet" import="javax.sql.rowset.CachedRowSet" import="javax.sql.rowset.RowSetProvider" import="com.jsc.utils.JdbcConnectionUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin System.</title>
<style type="text/css">
body{text-align:center;font-size:14px;line-height:20px;}
</style>
</head>
<body>
<h2>欢迎管理员 [${sessionScope.user.username}] 登入系统，以下是系统所有用户信息:</h2><br/>
<table border="2px" cellpadding="8px" cellspacing="0px" align="center">
	<tr>
		<th width="80" align="center">id</th>
		<th width="100" align="center">username</th>
		<th width="100" align="center">password</th>
		<th width="100" align="center">type</th>
		<th width="100" align="center">U/D</th>
	</tr>
	<c:forEach items="${sessionScope.UserList}" var="user">
	<tr>
		<th width="80" align="center">${user.id}</th>
		<th width="100" align="center">${user.username}</th>
		<th width="100" align="center">${user.password}</th>
		<th width="100" align="center">${user.type}</th>
		<th width="100" align="center"><a href="Update_User?userId=${user.id}">Update</a>/<a href="Delete_User?id=${user.id}&operator_User=${sessionScope.user.username}">Delete</a></th>
	</tr>	
	</c:forEach>
	<tr>
		<th><a href="PagingServlet?line=${sessionScope.line - 5}" ${sessionScope.page == 1 ?"style='display:none;'" :""}>上一页</a></th>
		
		<th colspan="3">第 ${sessionScope.page} 页</th>
		<th><a href="PagingServlet?line=${sessionScope.line + 5}" ${sessionScope.page == maxPage ?"style='display:none'" :""}>下一页</a></th>
	</tr>
</table><br/>
<a href="Logout"><input type="button" value="Logout." style="width:88px"/></a>
</body>
</html>