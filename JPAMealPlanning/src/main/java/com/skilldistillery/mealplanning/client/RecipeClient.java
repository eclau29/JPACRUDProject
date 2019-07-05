package com.skilldistillery.mealplanning.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.mealplanning.entities.Recipe;

public class RecipeClient {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MealPlanning");
	
	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		
		Recipe recipe = em.find(Recipe.class, 1);
		System.out.println("Recipe: " + recipe);
		em.close();
		emf.close();
		
	}

}
