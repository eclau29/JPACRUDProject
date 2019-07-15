<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ingredient</title>
</head>
<body>
<h3><em>I don't know that ingredient yet...please add it to my knowledge base</em></h3>
<form action="addNewIngredient.do" method="POST">
		<label for="name">Ingredient to add:  </label> 
			<input type="text" name="ingredName">
			<input type="hidden" name="recipeId" value="${recipeId}">
			<input type="submit" class="btn btn-success btn-md" value="Add Ingredient">
		</form>
		<h5><em>(This will also add it to the current recipe.)</em></h5>
	<form action="goHome.do" method="GET">
		<input type="submit" class="btn btn-info btn-md" value="Return Home">
	</form>

</body>
</html>