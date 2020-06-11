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
	<form action='user?method=update' method="post" onsubmit="return regist()">
		姓名：<input name='username' id='username'  value="${user.username }"> 
		<br>
		学号：<input type="password" name='sno'  id='sno' value="${user.sno }"><br>
		系别：<input type="text" name='xi'  id='xi' value="${user.xi }"><br>
		区队：<input type="text" name='qudui'  id='qudui' value="${user.qudui }"><br>
		<input hidden name='id' value="${user.id }">
		<button>修改</button>
	</form>
</body>
</html>
<script>
	function regist(){
		var username = document.getElementById("username")
		var sno = document.getElementById("sno")
		var xi = document.getElementById("xi")
		var qudui = document.getElementById("qudui")
		
		if(username.value=='' || sno.value=='' || xi.value=='' || qudui.value==''){
			alert("请完善信息")
			return false
		}
	}
</script>
