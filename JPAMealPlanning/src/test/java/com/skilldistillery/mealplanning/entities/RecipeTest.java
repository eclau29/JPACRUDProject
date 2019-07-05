package com.skilldistillery.mealplanning.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class RecipeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Recipe recipe;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("MealPlanning");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		recipe = em.find(Recipe.class, 13);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		recipe = null;
	}

	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	void test_Recipe_mappings() {
		assertEquals(13, recipe.getId());
		assertEquals("Spicy Cumin Lamb Biang Biang Noodles", recipe.getName());
		assertEquals("Dinner", recipe.getMealType());
		assertEquals("Chinese", recipe.getCuisine());
		assertEquals("Lamb", recipe.getMainIngredient());
		assertEquals(188, recipe.getCookTimeMins());
		assertEquals("https://thewoksoflife.com/cumin-lamb-biang-biang-noodles/?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+TheWoksOfLife+%28The+Woks+of+Life%29&utm_content=Google+International", recipe.getRecipeUrl());
		assertEquals("Chinese", recipe.getCuisine());
		assertEquals("Chinese", recipe.getCuisine());
		assertNull(recipe.getDescription());
		assertEquals("Mortar and Pestle, fresh dough", recipe.getNotes());
		assertEquals(4, recipe.getServingSize());
		assertEquals(425, recipe.getCalPerServing());
		
		
	}

}
