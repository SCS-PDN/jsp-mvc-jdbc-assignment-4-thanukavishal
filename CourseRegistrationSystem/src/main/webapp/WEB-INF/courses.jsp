<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses Dashboard</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Courses</h2>

<c:forEach var="c" items="${courses}">
    <p>
        ${c.name} - ${c.instructor}
        <form method="post" action="register/${c.id}">
            <button type="submit">Register</button>
        </form>
    </p>
</c:forEach>
</body>
</html>