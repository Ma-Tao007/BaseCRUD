<%@page import="bean.User"%>
<%@page import="java.util.List"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='user?method=login' method="post" onsubmit="return login()">
		用户名：<input name='username' id='username'>
		<br>
		密码：<input type="password" name='sno' id='sno'><br>
		<button>登陆</button>
	</form>
</body>
</html>
<script>
	function login(){
		var username = document.getElementById("username")
		var sno = document.getElementById("sno")
		if(username.value=='' || sno.value==''){
			alert("请输入用户名和密码")
			return false
		}
	}
</script>