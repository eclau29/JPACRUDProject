package com.skilldistillery.mealplanning.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class IngredientTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Ingredient ingred;
	
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
		ingred = em.find(Ingredient.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		ingred = null;
	}
	
	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void test_Ingredient_mappings() {
		assertEquals(1,ingred.getId());
		assertEquals("chicken", ingred.getIngredName());
	}
	
	@Test
	void test_Ingredient_knows_its_recipes() {
		Recipe recipe = em.find(Recipe.class, 1);
		ingred.addRecipe(recipe);
		assertNotNull(ingred.getRecipeList());
		assertTrue(ingred.getRecipeList().size() > 0);
		assertEquals("Chicken Khao Soi", ingred.getRecipeList().get(0).getName());
	}
	
	

}
