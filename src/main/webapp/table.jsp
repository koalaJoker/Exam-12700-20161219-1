<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影信息</title>
</head>
<body>
<br><br><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='/Exam-12700-20161219-1/FilmServlet?method=toAddFilm' style="font-size: 30px">新增</a>

	<table align='center' border='1px' style='margin-top: 20px' width='800' height='250'>
		<tr>
			<th>序号</th>
			<th>电影编号</th>
			<th>标题</th>
			<th>概要</th>
			<th>语言</th>
			<th>操作</th>
		</tr>
         <c:forEach items="${list}" var="film" varStatus="c">
			<tr>
				<td>${c.count}</td>
				<td>${film.film_id}</td>
				<td>${film.title}</td>
				<td>${film.description}</td>
				<td>${film.language_name}</td>
				<td width="90"><a href='/Exam-12700-20161219-1/FilmServlet?method=toUpdateFilm&id=${film.film_id}'>修改</a>&nbsp;<a
					href='/Exam-12700-20161219-1/FilmServlet?method=deleteFilm&id=${film.film_id}'  onClick="return confirm('确定要删除?')">删除</a></td>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>