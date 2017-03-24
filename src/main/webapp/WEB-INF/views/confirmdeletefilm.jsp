<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="css/master.css">
</head>
<body>	
	<div>
		
		<c:choose>
		<c:when test="${filmDeleted.booleanValue()}">
		Film ${film.title} has been deleted!				
		</c:when>
		<c:otherwise>
		Film not deleted!
		</c:otherwise>
		</c:choose>
	</div>
	<a href="home.do">Home</a>
	
</body>
</html>
