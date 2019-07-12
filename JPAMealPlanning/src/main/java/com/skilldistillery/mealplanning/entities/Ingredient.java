package com.skilldistillery.mealplanning.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ingredient_name")
	private String ingredName;
	
	@ManyToMany(mappedBy = "ingredients")
	private List<Recipe> recipeList;

	// C O N S T R U C T O R S
	
	public Ingredient() {
		super();
	}

	public Ingredient(int id, String ingredName, List<Recipe> recipeList) {
		super();
		this.id = id;
		this.ingredName = ingredName;
		this.recipeList = recipeList;
	}

	// GETTERS N' SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngredName() {
		return ingredName;
	}

	public void setIngredName(String ingredName) {
		this.ingredName = ingredName;
	}

	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	
	// M E T H O D S
	
	public void addRecipe(Recipe recipe) {
		if (recipeList == null) {
			recipeList = new ArrayList<>();
		}
		if (!recipeList.contains(recipe)) {
			recipeList.add(recipe);
			recipe.addIngredient(this);
		}
	}
	
	public void removeRecipe(Recipe recipe) {
		if (recipeList != null && recipeList.contains(recipe)) {
			recipeList.remove(recipe);
			recipe.removeIngredient(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", ingredName=" + ingredName + "]";
	}

	
	
}
