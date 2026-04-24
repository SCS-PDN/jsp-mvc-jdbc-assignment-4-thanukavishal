<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Registration LogIn</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Login</h2>

<form method="post" action="login">
    Email: <input type="text" name="email"/><br>
    Password: <input type="password" name="password"/><br>
    <button type="submit">Login</button>
</form>

<p style="color:red;">${error}</p>
</body>
</html>