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
		<strong>Edit Film </strong><span></span>
	</h4>
	<div class="form">
		<form action="updateFilm.do" method="POST">
			<input type="hidden" value="${film.id}" name="id">
			<label for="title">Title: </label> <input type="text"
				value="${film.title}" name="title" class="txt"><br> <label
				for="description">Description: </label>

			<textarea value="${film.description}" name="description" type="text"
				class="txt_3"></textarea>
			<br> <label for="releaseYear">Release Year: </label> <input
				type="text" value="${film.releaseYear}" name="releaseYear"
				class="txt">
			<%-- <label for="language">Pick
				language: </label> <select name="language">
				<c:forEach var="language" items="${languages}">
					<option value="${language.id}">${language.name}</option>
				</c:forEach> 
			</select> --%>
			<label for="rentalDuration">Rental Duration: </label> <input
				type="number" name="rentalDuration" value="${film.rentalDuration}" min="1"> <br>
			<label for="rentalRate">Rental Rate: </label> <input
				type="number" name="rentalRate" value="${film.rentalRate}" step="0.50" min="1.00">
			<br>
			<label for="length">Length: </label> <input type="number"
				name="length" value="${film.length}" min="1"> <br>
			<label for="replacementCost">Replacement Cost: </label> <br>
			<input type="number" name="replacementCost" value="${film.replacementCost}" step="0.50"
				min="1.00">
			<%-- <label for="rating">Pick rating: </label>
			<c:forEach var="rating" items="${ratings}">
				<option value="${rating}">${rating}</option>
			</c:forEach>
			<label for="specialFeature">Pick special feature: </label>
			<c:forEach var="specialFeature" items="${specialFeatures}">
				<input type="checkbox" name="specialFeatures"
					value="${specialFeature}">${specialFeature}<br>
			</c:forEach> --%>

			<!-- 			add actors
 -->
			<%-- <label for="actors">Select/Add Cast:</label>
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
