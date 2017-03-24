<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page session="false"%>
<html>
<head>
<title>Add</title>
<link rel="stylesheet" href="css/master.css">
</head>
<body>
	<h4 class="heading">
		<strong>Add a New Film </strong><span></span>
	</h4>
	<div class="form">
		<form action="createFilm.do" method="POST">
			<input type="text" placeholder="Enter title" name="title" class="txt"><br>
			<textarea placeholder="Enter description" name="description"
				type="text" class="txt_3"></textarea><br>
			<input type="text" placeholder="Enter release year"
				name="releaseYear" class="txt"> <%-- <label for="language">Pick
				language: </label> <select name="language">
				<c:forEach var="language" items="${languages}">
					<option value="${language.id}">${language.name}</option>
				</c:forEach> 
			</select> --%><label for="rentalDuration">Pick rental duration: </label> <input
				type="number" name="rentalDuration" value="1" min="1"> <br><label
				for="rentalRate">Pick rental rate: </label> <input type="number"
				name="rentalRate" value="1.00" step="0.50" min="1.00"> <br><label
				for="length">Pick length: </label> <input type="number"
				name="length" value="1" min="1"> <br><label
				for="replacementCost">Pick replacement cost: </label> <br><input
				type="number" name="replacementCost" value="1.00" step="0.50"
				min="1.00"> <%-- <label for="rating">Pick rating: </label>
			<c:forEach var="rating" items="${ratings}">
				<option value="${rating}">${rating}</option>
			</c:forEach>
			<label for="specialFeature">Pick special feature: </label>
			<c:forEach var="specialFeature" items="${specialFeatures}">
				<input type="checkbox" name="specialFeatures"
					value="${specialFeature}">${specialFeature}<br>
			</c:forEach> --%>

<!-- 			add actors
 -->			<%-- <label for="actors">Select/Add Cast:</label>
			<datalist name="actors" multiple>
				<c:forEach var="actor" items="${actors}">
				<option value="${actor.id}">${actor.firstName} ${actor.lastName}</option>
			</c:forEach>
			</datalist> --%>
			<input type="submit" value="Add Film" name="submit" class="txt2">
		</form>
	</div>
</body>
</html>
