<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Update/Delete Recipe</title>
</head>
<body>

<
	<h3>
		<strong>Edit ${recipe.name} Recipe</strong>
	</h3>
	<br>
	<h5><em>Current Entry:</em></h5>
	<ul>
		<li>${recipe.name}</li>
		<li>Recipe ID: ${recipe.id }</li>
		<li>Meal Type: ${recipe.mealType }</li>
		<li>Cuisine: ${recipe.cuisine }</li>
		<li>Main Ingredient: ${recipe.mainIngredient }</li>
		<li>Cooking Time: ${recipe.cookTimeMins }</li>
		<li>Description: ${recipe.description }</li>
		<li>Servings: ${recipe.servingSize }</li>
		<li>Calories per Serving: ${recipe.calPerServing }</li>
		<li>Notes: ${recipe.notes }</li>
	</ul>
	<br>
	<br>
	<h4><em>Make Changes Here:</em></h4>
	<form action="updateRecipe.do" method="POST">
		<label for="name">Recipe Name:</label> 
			<input type="text" name="name" value="${recipe.name}">
			<br>
		<label for="mealType">Meal Type:</label>
			<input type="text" name="mealType" value="${recipe.mealType}">
			<br>
		<label for="cuisine">Cuisine:</label>
			<input type="text" name="cuisine" value="${recipe.cuisine}">
			<br>
		<label for="mainIngredient">Main Ingredient:</label>
			<input type="text" name="mainIngredient" value="${recipe.mainIngredient}">
			<br>
		<label for="cookTime">Cooking Time (mins):</label>
			<input type="number" name="cookTimeMins" value="${recipe.cookTimeMins}">
			<br>
		<label for="description">Description:</label>
			<input type="text" name="description" value="${recipe.description}" size=50>
			<br>
		<label for="servingSize">Servings:</label>
			<input type="text" name="servingSize" value="${recipe.servingSize}">
			<br>
		<label for="calPerServing">Calories Per Serving:</label>
			<input type="number" name="calPerServing" value="${recipe.calPerServing}">
			<br>
		<label for="notes">Notes:</label>
			<input type="text" name="notes" value="${recipe.notes}" size=50>
			<br>
		<input type="hidden" value="${recipe.id}" name="recipeId"/> 
		<input type="submit" class="btn btn-success btn-md" value="Make Changes ">
		     
	</form>
			<br>
			<form action="deleteRecipe.do" method="POST">
				<input type="hidden" value="${recipe.id}" name="recipeId"/>
				<input type="submit" class="btn btn-danger btn-md"value="Delete"/>
			</form>
			<br>
			<form action="goHome.do" method="GET">
				<input type="submit" class="btn btn-info btn-md" value="Return Home">
			</form>
</body>
</html>