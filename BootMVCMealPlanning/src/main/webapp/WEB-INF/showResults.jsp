<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><strong>Search Results</strong></title>
</head>
<body>
<h3><strong>Search Results</strong></h3>
	<c:choose>
		<c:when test="${! empty recipes }">
			<ul>
				<c:forEach items="${recipes}" var="recipe">
					<li>${recipe.name }<a href="${recipe.recipeUrl }"></a></li>
					<li>Recipe ID: ${recipe.id }</li>
					<li>Meal Type: ${recipe.mealType }</li>
					<li>Cuisine: ${recipe.cuisine }</li>
					<li>Main Ingredient: ${recipe.mainIngredient }</li>
					<li>Cooking Time: ${recipe.cookTimeMins }</li>
					<li>Description: ${recipe.description }</li>
					<li>Servings: ${recipe.servingSize }</li>
					<li>Calories per Serving: ${recipe.calPerServing }</li>
					<li>Notes: ${recipe.notes }</li>
					<form action="GetFilm.do">
					<input type="hidden" value="${recipe.id }" name="rid" />
					<input type="submit" action="findfilmbyid.do" value="Update/Delete Film" />
					<hr>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No Recipes Found</p>
		</c:otherwise>
	</c:choose>

</body>
</html>