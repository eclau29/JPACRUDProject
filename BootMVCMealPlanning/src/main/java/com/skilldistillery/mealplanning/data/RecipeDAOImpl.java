package com.skilldistillery.mealplanning.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.mealplanning.entities.Recipe;

@Service
@Transactional
public class RecipeDAOImpl implements RecipeDAO {
//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MealPlanning");

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Recipe> findAll() {
//		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "SELECT r FROM Recipe r";
		List<Recipe> allRecipes = em.createQuery(jpqlQuery, Recipe.class).getResultList();

//		em.close();
		return allRecipes;
	}

	@Override
	public Recipe searchById(int id) {
//		EntityManager em = emf.createEntityManager();
		String jpqlQuery = "SELECT r FROM Recipe r WHERE r.id = :id";
		Recipe recipe = em.createQuery(jpqlQuery, Recipe.class).setParameter("id", id).getResultList().get(0);

//		em.close();
		return recipe;
	}

	// search by keyword looking at name, mainIngredient
	@Override
	public List<Recipe> searchByKeyword(String keyword) {
//		EntityManager em = emf.createEntityManager();
		String query = "SELECT r FROM Recipe r WHERE r.name like :keyword OR r.mainIngredient like :keyword";
		List<Recipe> listByKeyword = em.createQuery(query, Recipe.class).setParameter("keyword", "%" + keyword + "%")
				.setParameter("keyword",  "%" + keyword + "%").getResultList();

		for (Recipe recipe : listByKeyword) {
			System.out.println(recipe.getName());
		}
//		em.close();
		return listByKeyword;
	}

	@Override
	public List<Recipe> searchByMealType(String meal) {
//		EntityManager em = emf.createEntityManager();
		String query = "SELECT r FROM Recipe r WHERE r.mealType = :meal";
		List<Recipe> listByMealType = em.createQuery(query, Recipe.class).setParameter("meal", meal).getResultList();

		for (Recipe recipe : listByMealType) {
			System.out.println(recipe.getName());
		}

//		em.close();
		return listByMealType;
	}

	@Override
	public List<Recipe> searchByCuisine(String cuisine) {
//		EntityManager em = emf.createEntityManager();
		String query = "SELECT r FROM Recipe r WHERE r.cuisine = :cuisine";
		List<Recipe> listByCuisine = em.createQuery(query, Recipe.class).setParameter("cuisine", cuisine)
				.getResultList();

//		for (Recipe recipe : listByCuisine) {
//			System.out.println(recipe.getName());
//		}
//		em.close();
		return listByCuisine;
	}

	@Override
	public List<Recipe> searchByCookTime(int cookTime) {
//		EntityManager em = emf.createEntityManager();
		String query = "SELECT r FROM Recipe r WHERE r.cookTimeMins = :cookTime OR r.cookTimeMins < :cookTime";
		List<Recipe> listByCookTime = em.createQuery(query, Recipe.class).setParameter("cookTime", cookTime)
				.setParameter("cookTime", cookTime).getResultList();

		for (Recipe recipe : listByCookTime) {
			System.out.println(recipe.getName());
		}
//		em.close();
		return listByCookTime;
	}

	@Override
	public List<Recipe> searchByCalPerServing(Integer cal) {
//		EntityManager em = emf.createEntityManager();
		String query = "SELECT r FROM Recipe r WHERE r.calPerServing = :calPerServing OR r.calPerServing < :calPerServing";
		List<Recipe> listByCalPerServing = em.createQuery(query, Recipe.class).setParameter("calPerServing", cal)
				.setParameter("calPerServing", cal).getResultList();

		for (Recipe recipe : listByCalPerServing) {
			System.out.println(recipe.getName());
		}
//		em.close();
		return listByCalPerServing;
	}

	// works! :D
	@Override
	public Recipe addRecipe(Recipe recipe) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
		em.persist(recipe);

		em.flush();
//		em.getTransaction().commit();
//		em.close();
		return recipe;
	}

	@Override
	public Recipe updateRecipe(int id, Recipe recipe) {
//		EntityManager em = emf.createEntityManager();
		Recipe recipeToUpdate = em.find(Recipe.class, id);
		
//		em.getTransaction().begin();

		recipeToUpdate.setName(recipe.getName());
		recipeToUpdate.setMealType(recipe.getMealType());
		recipeToUpdate.setCuisine(recipe.getCuisine());
		recipeToUpdate.setMainIngredient(recipe.getMainIngredient());
		recipeToUpdate.setCookTimeMins(recipe.getCookTimeMins());
		recipeToUpdate.setRecipeUrl(recipe.getRecipeUrl());
		recipeToUpdate.setDescription(recipe.getDescription());
		recipeToUpdate.setNotes(recipe.getNotes());
		recipeToUpdate.setServingSize(recipe.getServingSize());
		recipeToUpdate.setCalPerServing(recipe.getCalPerServing());

//		em.getTransaction().commit();
//		em.close();
		return recipeToUpdate;
	}

	@Override
	public boolean deleteRecipe(int id) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();

		Recipe recipeToDelete = em.find(Recipe.class, id);
		
			em.remove(recipeToDelete);
		
//			e.printStackTrace();
		
//		em.getTransaction().commit();
//		em.close();
		return true;
	}

}
