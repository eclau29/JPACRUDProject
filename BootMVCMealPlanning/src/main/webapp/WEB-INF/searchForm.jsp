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
<title>Search Recipes</title>
</head>
<body>
<h3><strong>Search Recipes By:</strong></h3>

	<form action="getRecipeById.do" method="GET">
		Recipe ID:
			<input type="number" name="recipeId">
			<input type="submit" value="Search">
			<br>
	</form> 
	<form action="getRecipesKeyword.do" method="GET">
		Keyword:
			<input type="text" name="keyword">
			<input type="submit" value="Search">
			<br>
	</form> 
	<form action="getRecipesMealType.do" method="GET">
		Meal Type:
			<input type="text" name="mealType" value="${recipe.mealType }">
			<input type="submit" value="Search">
			<br>
	</form> 
	<form action="getRecipesCuisine.do" method="GET">
		Cuisine: 
			<input type="text" name="cuisine" value="${recipe.cuisine }">
			<input type="submit" value="Search">
			<br>
	</form> 
	<form action="getRecipesCookTime.do" method="GET">
		Cook Time (mins):
			<input type="text" name="cookTime" value="${recipe.cookTimeMins }">
			<input type="submit" value="Search">
			<br>
	</form> 
	<form action="getRecipesCalPerServing.do" method="GET">
		Calories Per Serving:
			<input type="text" name="cal" value="${recipe.calPerServing }">
			<input type="submit" value="Search">
			<br>
	</form> 
	<br>
	<form action="goHome.do" method="GET">
			<input type="submit" class="btn btn-info btn-md" value="Return Home">
	</form>
</body>
</html>