<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Recipe Details</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty recipe }">
			<form action="sendToUpdateRecipe.do" method="GET">
			<a href="${recipe.recipeUrl }"><h3>${recipe.name }</h3></a>
				<ul>
					<li>Recipe ID: ${recipe.id }</li>
					<li>Meal Type: ${recipe.mealType }</li>
					<li>Cuisine:  ${recipe.cuisine }</li>
					<li>Main Ingredient:  ${recipe.mainIngredient }</li>
					<li>Cooking Time:  ${recipe.cookTimeMins }</li>
					<li>Description:  ${recipe.description }</li>
					<li>Servings:  ${recipe.servingSize }</li>
					<li>Calories per Serving:  ${recipe.calPerServing }</li>
						<li>Notes:  ${recipe.notes }</li>
				</ul>
					<input type="hidden" value="${recipe.id }" name="recipeId"/>
					<input type="submit" class="btn btn-warning btn-md" value="Update" />
					
					
			</form>
				
				<br>
				
				<form action="deleteRecipe.do" method="POST">
					<input type="hidden" value="${recipe.id}" name="recipeId"/>
					<input type="submit" class="btn btn-danger btn-md" value="Delete"/>
				</form>

				<br>
	
				<form action="goHome.do" method="GET">
					<input type="submit" class="btn btn-info btn-md" value="Return Home">
				</form>
		</c:when>
		<c:otherwise>>
			<p> No Recipe Found
		</c:otherwise>
	</c:choose>
</body>
</html>