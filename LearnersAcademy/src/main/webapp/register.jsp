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
	<h3> Learners Management System Registration</h3><br>
	<form action="./register" method="post"></form>
		Username : <input type="text" name="username"/> <br>
		Password : <input type="password" name="password"/> <br>
		UserType : <select name="usertype">
			<option value="admin"> Admin </option>
			<option value="user"> User </option>
		</select>
		<input type="submit" value="Register"/><br>	
	</form>		

</body>
</html>