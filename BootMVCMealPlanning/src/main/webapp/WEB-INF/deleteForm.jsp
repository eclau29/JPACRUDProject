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
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${! empty recipe }">
<h3>
		<strong>Delete ${recipe.name} Recipe</strong>
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
	<form action="deleteRecipe.do" method="POST">
			<input type="hidden" value="${recipe.id }" name="recipeId"/>
			<input type="submit" class="btn btn-danger btn-md" value="Click here to DELETE" />
		</form>
	</c:when>		
</c:choose>
</body>
</html>