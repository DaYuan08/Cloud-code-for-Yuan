<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update System.</title>
<style>
body{text-align:center;font-size:26px;line-height:20px;}
input{fon-size:18px;}
</style>
</head>
<body>
<h5>请填写新的信息.</h5>
<p>当前修改信息的用户id为 : ${sessionScope.userId}</p>
<form action="Update_User" method="post">
<input type="text" name="userId" value="${sessionScope.userId}" style="display:none;"/>
username : <input type="text" name="newUsername"/><br/>
password : <input type="password" name="newPassword"/><br/>
<input type="submit"/>&nbsp;<input type="reset"/>
</form>
</body>
</html>