<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcom to Learners Academy</h1><br><br>
	<hr>
	<h3> Learners Management System</h3><br>
	<form action="./login" method="post"></form>
		User : <input type="text" name="username"/> <br>
		Password : <input type="password" name="password"/> <br>
		<input type="submit" value="Login"/><br>
		<a href="register.jsp">Register</a>
	</form>		
	<br>
	<h3> 
		<p style="color:red;"> ${requestScope.msg}
	</h3>
</body>
</html>