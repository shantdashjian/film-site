<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="css/master.css">
</head>
<body>
	<h1>New Film Added</h1>
	
	<div>
		
		<c:choose>
		<c:when test="${! empty film}">
		Title: <strong>${film.title}</strong>
			<br>
		Description: <strong>${film.description}</strong>
			<br>
				
		</c:when>
		<c:otherwise>
		Film not added!
		</c:otherwise>
		</c:choose>
	</div>
	<a href="home.do">Home</a>
	
</body>
</html>
