<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/><br/><br/><br/><br/>
<center>
<h1>登陆</h1></br></br>
<form action="/Exam-12700-20161219-1/LoginServlet" method="post">
<input type="hidden" name="method" value="login">
请输入登陆名：<input type="text" name="name"/><br/><br/>
<input type="submit" value="登陆"/> &nbsp; &nbsp;<input type="reset" value="重置" /></br>
<span style="color: red">${tip}</span> 
</form>
</center>
</body>
</html>