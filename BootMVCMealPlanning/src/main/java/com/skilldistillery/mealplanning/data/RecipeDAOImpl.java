package com.skilldistillery.mealplanning.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.skilldistillery.mealplanning.entities.Ingredient;
import com.skilldistillery.mealplanning.entities.Recipe;

@Service
@Transactional
public class RecipeDAOImpl implements RecipeDAO {
//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MealPlanning");

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Recipe> findAll() {
		String jpqlQuery = "SELECT r FROM Recipe r";
		List<Recipe> allRecipes = em.createQuery(jpqlQuery, Recipe.class).getResultList();

		return allRecipes;
	}

	@Override
	public Recipe searchById(int id) {
		String jpqlQuery = "SELECT r FROM Recipe r WHERE r.id = :id";
		List<Recipe> recipe = em.createQuery(jpqlQuery, Recipe.class).setParameter("id", id).getResultList();
		if (recipe.size() < 1) {
			return null;
		} else {
			return recipe.get(0);
		}
	}

	// search by keyword looking at name, ingredients
	@Override
	public List<Recipe> searchByKeyword(String keyword) {
		String query = "SELECT DISTINCT(r) FROM Recipe r WHERE r.name like :keyword ";
//				+ "OR r.ingredients.ingredName like :keyword";
		List<Recipe> listByKeyword = em.createQuery(query, Recipe.class).setParameter("keyword", "%" + keyword + "%")
				.setParameter("keyword", "%" + keyword + "%").getResultList();

		for (Recipe recipe : listByKeyword) {
			System.out.println(recipe.getName());
		}
		return listByKeyword;
	}
	
	@Override
	public List<Recipe> searchByIngredient(String ingredient){
		String query = "SELECT i FROM Ingredient i WHERE i.ingredName like :ingredient"; //couldn't search based on recipe for some 
												//reason; some recipes displayed all their ingredients, 
												//other recipes showed only the ingredient you searched for...
												//couldn't figure out how to fix that so used a query based on ingredients
		
		List<Recipe> listByIngredients = em.createQuery(query, Ingredient.class).setParameter("ingredient", "%" + ingredient + "%")
				.getResultList().get(0).getRecipeList(); //doesn't work if ingredient input from form includes the name of another ingredient (for example, milk & sweetened condensed milk)
		
		return listByIngredients;
	}

	@Override
	public List<Recipe> searchByMealType(String meal) {
		String query = "SELECT r FROM Recipe r WHERE r.mealType like :meal";
		List<Recipe> listByMealType = em.createQuery(query, Recipe.class).setParameter("meal", "%" + meal + "%")
				.getResultList();

		for (Recipe recipe : listByMealType) {
			System.out.println(recipe.getName());
		}

		return listByMealType;
	}

	@Override
	public List<Recipe> searchByCuisine(String cuisine) {
		String query = "SELECT r FROM Recipe r WHERE r.cuisine like :cuisine";
		List<Recipe> listByCuisine = em.createQuery(query, Recipe.class).setParameter("cuisine", "%" + cuisine + "%")
				.getResultList();

//		for (Recipe recipe : listByCuisine) {
//			System.out.println(recipe.getName());
//		}
		return listByCuisine;
	}

	@Override
	public List<Recipe> searchByCookTime(int cookTime) {
		String query = "SELECT r FROM Recipe r WHERE r.cookTimeMins = :cookTime OR r.cookTimeMins < :cookTime";
		List<Recipe> listByCookTime = em.createQuery(query, Recipe.class).setParameter("cookTime", cookTime)
				.setParameter("cookTime", cookTime).getResultList();

		for (Recipe recipe : listByCookTime) {
			System.out.println(recipe.getName());
		}
		return listByCookTime;
	}

	@Override
	public List<Recipe> searchByCalPerServing(Integer cal) {
		String query = "SELECT r FROM Recipe r WHERE r.calPerServing = :calPerServing OR r.calPerServing < :calPerServing";
		List<Recipe> listByCalPerServing = em.createQuery(query, Recipe.class).setParameter("calPerServing", cal)
				.setParameter("calPerServing", cal).getResultList();

		for (Recipe recipe : listByCalPerServing) {
			System.out.println(recipe.getName());
		}
		return listByCalPerServing;
	}

	@Override
	public Recipe addRecipe(Recipe recipe) {
		em.persist(recipe);

		em.flush();
		return recipe;
	}

	@Override
	public Recipe updateRecipe(int id, Recipe recipe) {
		Recipe recipeToUpdate = em.find(Recipe.class, id);

		recipeToUpdate.setName(recipe.getName());
		recipeToUpdate.setMealType(recipe.getMealType());
		recipeToUpdate.setCuisine(recipe.getCuisine());
//		recipeToUpdate.setIngredients(recipe.getIngredients());
		recipeToUpdate.setCookTimeMins(recipe.getCookTimeMins());
		recipeToUpdate.setRecipeUrl(recipe.getRecipeUrl());
		recipeToUpdate.setDescription(recipe.getDescription());
		recipeToUpdate.setNotes(recipe.getNotes());
		recipeToUpdate.setServingSize(recipe.getServingSize());
		recipeToUpdate.setCalPerServing(recipe.getCalPerServing());

		return recipeToUpdate;
	}

	@Override
	public boolean deleteRecipe(int id) {

		Recipe recipeToDelete = em.find(Recipe.class, id);

		try {
			em.remove(recipeToDelete);
		} catch (Exception e) {
			return false;
			// e.printStackTrace();
		}

		return true;
	}

	@Override
	public Ingredient findIngredientByName(String ingredient) {
		String query = "SELECT i FROM Ingredient i WHERE i.ingredName = :ingredient";
		Ingredient foundIngredient = em.createQuery(query, Ingredient.class).setParameter("ingredient", ingredient).getSingleResult();
		
		return foundIngredient;
	}

	@Override
	public Ingredient addNewIngredient(@Valid Ingredient ingredient) {
		System.out.println("************************* IN DAOIMPL ************8" + ingredient);
		em.persist(ingredient);

		em.flush();
		return ingredient;
	}
	
	

}
