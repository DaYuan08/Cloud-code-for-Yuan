<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test.</title>
<style type="text/css">
body{
	text-align:center;
	font-size:26px;
	line-height:40px;
	color:black;
}
input{
	fon-size:18px;
}
</style>
</head>
<body>
<form action="TokenTest2">
<input type="text" name="unToken" value="${requestScope.unToken}" style="display:none;" /><br/>
username : <input type="text" name="username"/><br/>
<input type="submit"/>
</form>
</body>
</html>