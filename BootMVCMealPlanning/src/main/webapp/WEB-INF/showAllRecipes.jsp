<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
				<a href="getRecipeById.do?recipeId=${recipe.id }">${recipe.name}</a>
					<form action="sendToUpdateRecipe.do">
						<input type="hidden" value="${recipe.id}" name="recipeId"/>
						<input type="submit" value="Update/Delete"/>
						
					</form>
					<br>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p>This Recipe Box is Empty :(</p>
		</c:otherwise>
	</c:choose>
</body>
</html>