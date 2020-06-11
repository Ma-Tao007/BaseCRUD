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
<%
	UserDao ud = new UserDao();
	List<User> list = ud.getAllByPage();
	request.setAttribute("list", list);
	User userinfo = (User)request.getSession().getAttribute("userinfo");
	if(userinfo==null){
		
	}else{
		request.setAttribute("username", userinfo.getUsername());
	}
	
%>
<body>
<h2>欢迎您：${username }</h2>
<div>
	<button>登陆</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button>注册</button>
</div>
	<table cellspacing="0" width="500px" border="1px" style="text-align: center">
		<thead>
            <tr>
				<th>序号</th>
				<th>系别</th>
				<th>区队</th>
				<th>学号</th>
				<th>姓名</th>
				<th>操作</th>
            </tr>
        </thead>
        <tbody>
			<c:forEach  items="${list}" var="item" varStatus="i" >
				<tr>
					<td>${i.index+1 }</td>
					<td>${item.xi}</td>
					<td>${item.qudui}</td>
					<td>${item.sno}</td>
					<td>${item.username}</td>
					<td>
						<a  href="location.href='user?method=editPage&id=${item.id}'">修改</a>
						<a  href="location.href='user?method=showPage&id=${item.id}'">查看</a>
					</td>
				</tr>
			</c:forEach>
        </tbody>
	</table>
</body>
</html>