<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>All Recipes</title>
</head>
<body>
	<h3>
		<strong>All Recipes</strong>
	</h3>
	<c:choose>
		<c:when test="${! empty allRecipes }">
			<ul>
				<c:forEach items="${allRecipes }" var="recipe">
				<br>
				<a href="getRecipeById.do?recipeId=${recipe.id }"><h4>${recipe.name}</h4></a>
					<form action="sendToUpdateRecipe.do">
						<input type="hidden" value="${recipe.id}" name="recipeId"/>
						<input type="submit" value="Update/Delete"/>
					</form>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p>This Recipe Box is Empty :(</p>
		</c:otherwise>
	</c:choose>
				<br>
				<form action="goHome.do" method="GET">
					<input type="submit" class="btn btn-info btn-md" value="Return Home">
				</form>
				<br>
				<br>
				<br>
				
</body>
</html>