package com.skilldistillery.mealplanning.data;

import java.util.List;

import com.skilldistillery.mealplanning.entities.Recipe;

public interface RecipeDAO {
	
	//show all Recipes
	public List<Recipe> findAll();
	
	public Recipe searchById (int id);
	
	//search by keyword looking at name, mainIngredient,
	public List<Recipe> searchByKeyword (String keyword);
	
	//search by mealType
	public List<Recipe> searchByMealType (String meal);
	
	//search by Cuisine
	public List<Recipe> searchByCuisine (String cuisine);
	
	//search by cookTime
	public List<Recipe> searchByCookTime (int cookTime);
	
	//search by calPerServing
	public List<Recipe> searchByCalPerServing (Integer cal);

	public Recipe addRecipe(Recipe recipe);
	
	public Recipe updateRecipe(int id, Recipe recipe);
	
	public boolean deleteRecipe(int id);
	
}
