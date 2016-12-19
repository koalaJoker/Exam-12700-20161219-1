<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
<br/><br/><br/><br/><br/>
<center>
<c:if test="${username==null}">
<a href="login.jsp">登陆</a>
</c:if>
<c:if test="${username!=null}">
您好，${username}&nbsp;&nbsp;
<a href="/Exam-12700-20161219-1/LoginServlet?method=exit"> 退出</a>
</c:if>
<br/><br/><br/><br/>
<h1>欢迎使用电影租赁系统</h1>
<br/><br/>
<a href='/Exam-12700-20161219-1/FilmServlet?method=table'>主页面</a>
<a href='/Exam-12700-20161219-1/FilmServlet?method=toAddFilm'>新增</a>
</center>
</body>
</html>