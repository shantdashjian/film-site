<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="css/master.css">
</head>
<body>
	<h1>Welcome to Java Movie Data Base (JMDB)</h1>
	<div>
		<form action="getTitle.do" method="GET">
			<input type="text" name="id" value="${id}"> <input type="submit"
				value="Get Film by ID">
		</form>
		<c:choose>
		<c:when test="${! empty film}">
		Title: <strong>${film.title}</strong>
			<br>
		Description: <strong>${film.description}</strong>
			<br>
		<caption><h2>Cast:</h2></caption>
				<table>
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="actor" items="${film.actors}">
							<tr>
								<td>${actor.firstName}</td>
								<td>${actor.lastName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</c:when>
		<c:otherwise>
		Film not found!
		</c:otherwise>
		</c:choose>
	</div>
	<hr>
	<div>
		<form action="searchFilmsByTitle.do" method="GET">
			<input type="text" name="keyword" value="${keyword}"> <input type="submit"
				value="Search">
		</form>
		<c:choose>
			<c:when test="${! empty searchResults}">
				<caption>Search Results</caption>
				<table>
					<thead>
						<tr>
							<th>Title</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="result" items="${searchResults}">
							<tr>
								<td>${result.title}</td>
								<td>${result.description}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				No Results Found
			</c:otherwise>
				
		</c:choose>
	</div>
</body>
</html>
