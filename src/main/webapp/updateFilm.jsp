<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="/Exam-12700-20161219-1/js/jquery-1.8.2.js"></script>
	<script type="text/javascript">
function check(){
	var title=$("#title").val();
	if(title==""){
		$("#span").text("请输入标题：");
		return false;
	}else{
		return true;
	}
}
</script>
<title>修改信息</title>
</head>
<body>
<form action="/Exam-12700-20161219-1/FilmServlet?method=updateFilm" method="post" onsubmit="return check();">
	<input name="id" value="${film.film_id}" type="hidden" >

	<br>
	  <h2 align="center">修改</h2>
		<table align="center" border="0px" style="margin-top: 20px"
			width="300">		
			<tr align="center">
				<td>标题</td>
				<td><input id="title" type="text" name="title" value="${film.title}"/></td>
			</tr>
			<tr align="center">
				<td>概要</td>
				<td>
				<textarea rows="5" cols="25" name="description" >${film.description}"</textarea>
				</td>
			</tr>
			<tr align="center">
				<td>语言</td>
			<td>
				<select name="language_name">
				<c:forEach items="${listName}" var="f">
				<c:if test="${f==film.language_name}"> 
				<option selected="selected">${f}</option>
				</c:if>
				<c:if test="${f!=film.language_name}"> 
				<option >${f}</option>
				</c:if>
				</c:forEach>
				</select>
			</td>
			</tr>
		</table>
		<div align="center" style="margin-top: 10px">
			<input type="submit" value="保存" />&nbsp;&nbsp;
			<input type="button" value="取消" onclick="history.go(-1)"><br>
		<span id="span" style="color: red;"></span>
		</div>
	</form>
</body>
</html>