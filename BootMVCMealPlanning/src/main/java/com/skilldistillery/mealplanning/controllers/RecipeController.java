package com.skilldistillery.mealplanning.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.mealplanning.data.RecipeDAO;
import com.skilldistillery.mealplanning.entities.Recipe;

@Controller
public class RecipeController {

	@Autowired
	private RecipeDAO dao;

	// this is the home page; it will show a list of all recipes available
	@RequestMapping(path = "showAll.do", method = RequestMethod.GET)
	public String showAllRecipes(Model model) {

		List<Recipe> allRecipes = dao.findAll();
		model.addAttribute("allRecipes", allRecipes);

		return "showAllRecipes";
	}

	@RequestMapping(path = "getRecipeById.do", method = RequestMethod.GET)
	public String getRecipeById(@RequestParam("recipeId") int id, Model model) {
		Recipe recipe = dao.searchById(id);
		if (recipe == null) {
			return "generalError";
		}
		model.addAttribute("recipe", recipe);
		return "recipeDetails";
	}

	@RequestMapping(path = "getRecipesKeyword.do", method = RequestMethod.GET)
	public String showResultsByKeyword(String keyword, Model model) {
		List<Recipe> recList = dao.searchByKeyword(keyword);
		model.addAttribute("recipes", recList);
		return "showResults";
	}

	@RequestMapping(path = "getRecipesMealType.do", method = RequestMethod.GET)
	public String showResultsByMealType(String mealType, Model model) {
		List<Recipe> recList = dao.searchByMealType(mealType);
		model.addAttribute("recipes", recList);

		return "showResults";
	}

	@RequestMapping(path = "getRecipesCuisine.do", method = RequestMethod.GET)
	public String showResultsByCuisine(String cuisine, Model model) {
		List<Recipe> recList = dao.searchByCuisine(cuisine);
		model.addAttribute("recipes", recList);

		return "showResults";
	}

	@RequestMapping(path = "getRecipesCookTime.do", method = RequestMethod.GET)
	public String showResultsByCookTime(int cookTime, Model model) {
		List<Recipe> recList = dao.searchByCookTime(cookTime);
		model.addAttribute("recipes", recList);

		return "showResults";
	}

	@RequestMapping(path = "getRecipesCalPerServing.do", method = RequestMethod.GET)
	public String showResultsByCalPerServing(Integer cal, Model model) {
		List<Recipe> recList = dao.searchByCalPerServing(cal);
		model.addAttribute("recipes", recList);

		return "showResults";
	}

	@RequestMapping(path = "getRecipes.do", method = RequestMethod.GET)
	public String goToSearchForm() {
		return "searchForm";
	}

	@RequestMapping(path = "addRecipe.do", method = RequestMethod.GET)
	public String goToAddForm() {
		return "addRecipeForm";
	}

	@RequestMapping(path = "addRecipe.do", method = RequestMethod.POST)
	public String addRecipe(@Valid Recipe recipe, Errors errors, Model model) {
		Recipe newRecipe;
		if (errors.getErrorCount() != 0) {
			return "addRecipeError";
		}
		newRecipe = dao.addRecipe(recipe);
		model.addAttribute("newRecipe", newRecipe);
		return "recipeDetails";
	}

	@RequestMapping(path = "updateRecipe.do", method = RequestMethod.POST)
	public String updateRecipe(@RequestParam("recipeId") int id, Recipe recipe, Model model) {
		System.out.println(id);
		Recipe updatedRecipe = dao.updateRecipe(id, recipe);
		model.addAttribute("recipe", updatedRecipe);

		return "recipeDetails";
	}

	@RequestMapping(path = "updateRecipeForm.do", method = RequestMethod.GET)
	public String sendToUpdateForm() {
		return "updateRecipeForm";
	}

	@RequestMapping(path = "deleteRecipe.do", method = RequestMethod.POST)
	public String deleteRecipe(@RequestParam("recipeId") int id, Model model) {
		boolean isDeleted = dao.deleteRecipe(id);
		if (isDeleted) {
			model.addAttribute("deletedRecipe", isDeleted);
			return "deletedRecipe";
		} else {
			return "deleteError";
		}
	}

	@RequestMapping(path = "sendToUpdateRecipe.do", method = RequestMethod.GET)
	public String sendToEdit(@RequestParam("recipeId") int id, Model model) {
		Recipe recipe = dao.searchById(id);
		model.addAttribute("recipe", recipe);
		return "updateRecipeForm";
	}

	@RequestMapping(path = "goHome.do", method = RequestMethod.GET)
	public String goHome() {
		return "index";
	}
}
