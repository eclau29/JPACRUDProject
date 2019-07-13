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
<title>Update/Delete Recipe</title>
</head>
<body>


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
		<li>Cooking Time: ${recipe.cookTimeMins }</li>
		<!-- not working -->
		<li>Ingredients: </li> 
				<ul>
					<c:forEach items="${recipe.ingredients}" var="ingredient">
						<li>${ingredient.ingredName}</li>
					</c:forEach>
				</ul>
		<!-- not working -->
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
		<%-- <label for="mainIngredient">Ingredients:</label>
			<input type="text" name="ingredients" value="${recipe.mainIngredient}">
			<br> --%>
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
		<label for="recipeUrl">Recipe URL:</label>
			<input type="text" name="recipeUrl" value="${recipe.recipeUrl}" size=65>
			<br>
		<input type="hidden" value="${recipe.id}" name="recipeId"/> 
		<input type="hidden" value="${recipe.ingredients }" name="ingredients"/>
		<input type="submit" class="btn btn-success btn-md" value="Make Changes ">
		     
	</form>
	<br>
	
	<h4><em>Make Changes to *INGREDIENTS* Here:</em></h4>
	
	<form action="addIngredientToRecipe.do" method="POST">
		<label for="ingredient">Ingredient to Add:</label>
			<input type="text" name="ingredient" size=50>
			<br>
		<input type="hidden" value="${recipe.id}" name="recipeId"/>
		<input type="submit" class="btn btn-warning btn-sm" value="Add Ingredient"/>
	</form>
	
	<br>
	<form action="delIngredientFromRecipe.do" method="POST">
		<label for="ingredient">Ingredient to Delete:</label>
			<input type="text" name="ingredient" size=50>
			<br>
		<input type="hidden" value="${recipe.id}" name="recipeId"/>
		<input type="submit" class="btn btn-warning btn-sm" value="Delete Ingredient"/>
	</form>
			<br>
			<br>
			<br>
			<form action="deleteRecipe.do" method="POST">
				<input type="hidden" value="${recipe.id}" name="recipeId"/>
				<input type="submit" class="btn btn-danger btn-md" value="Delete Recipe"/>
			</form>
			<br>
			<form action="goHome.do" method="GET">
				<input type="submit" class="btn btn-info btn-md" value="Return Home">
			</form>
			<br>
			<br>
			<br>
</body>
</html>