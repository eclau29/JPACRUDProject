<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Add Recipe</title>
</head>
<body>

		<h3><strong>Add New Recipe:</strong></h3>
		<h5><em>Items marked with * are required</em></h5>
	
		<form action="addRecipe.do" method="POST">
			<label for="name">*Name:</label>
				<input type="text" name="name">
			<br>
			<label for="mealType">Meal Type:</label>
				<input type="text" name="mealType">
			<br>
			<label for="cuisine">Cuisine:</label>
				<input type="text" name="cuisine">
			<br>
			<label for="cookTimeMins">*Cooking Time (mins):</label>
				<input type="number" name="cookTimeMins">
			<br>
			<label for="recipeUrl">Recipe URL:</label>
				<input type="text" name="recipeUrl" size=75>
			<br>
			<label for="description">Description:</label>
				<input type="text" name="description" size=50>
			<br>
			<label for="notes">Notes:</label>
				<input type="text" name="notes" size=50>
			<br>
			<label for="servingSize">*Servings:</label>
				<input type="number" name="servingSize">
			<br>
			<label for="calPerServing">Calories Per Serving:</label>
				<input type="number" name="calPerServing">
			<br>
			<br>
			<input type="submit" class="btn btn-success btn-md" value="Add Recipe">
		</form>
		<br>
	<%-- <form action="sendToUpdateRecipe.do">
		<input type="hidden" value="${recipe.id}" name="recipeId"/>
		<input type="submit" class="btn btn-info btn-md"value="Update"/>
	</form> --%>
		<br>
		<form action="goHome.do" method="GET">
			<input type="submit" class="btn btn-info btn-md" value="Return Home">
		</form>
</body>
</html>