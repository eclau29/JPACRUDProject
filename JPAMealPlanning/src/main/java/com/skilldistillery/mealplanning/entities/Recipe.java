package com.skilldistillery.mealplanning.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.ws.soap.MTOM;

import com.sun.istack.NotNull;

@Entity
public class Recipe {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="recipe_name")
	private String name;
	
	@Column(name="meal_type")
	private String mealType;
	
	private String cuisine;
	
	@Column(name="cook_time_mins")
	@NotNull
	private int cookTimeMins;
	
	@Column(name="recipe_url")
	private String recipeUrl;
	
	private String description;
	
	private String notes;
	
	@Column(name="serving_size")
	@NotNull
	private int servingSize;
	
	@Column(name="cal_per_serving")
	private Integer calPerServing;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "recipe_ingredient", 
		joinColumns = @JoinColumn(name = "recipe_id"), 
		inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients;
	
	
	// M E T H O D S
	
	public void addIngredient(Ingredient ingredient) {
		if (ingredients == null) {
			ingredients = new ArrayList<>();
		}
		if (!ingredients.contains(ingredient)) {
			ingredients.add(ingredient);
			System.out.println(ingredient);
			System.out.println(ingredients.size());
			ingredient.addRecipe(this);
		}
	}
	
	public boolean removeIngredient(Ingredient ingredient) {
		if (ingredients != null && ingredients.contains(ingredient)) {
			ingredients.remove(ingredient);
			ingredient.removeRecipe(this);
			return true;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public int getCookTimeMins() {
		return cookTimeMins;
	}

	public void setCookTimeMins(int cookTimeMins) {
		this.cookTimeMins = cookTimeMins;
	}

	public String getRecipeUrl() {
		return recipeUrl;
	}

	public void setRecipeUrl(String recipeUrl) {
		this.recipeUrl = recipeUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getServingSize() {
		return servingSize;
	}

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	public Integer getCalPerServing() {
		return calPerServing;
	}

	public void setCalPerServing(Integer calPerServing) {
		this.calPerServing = calPerServing;
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
		Recipe other = (Recipe) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", mealType=" + mealType + ", cuisine=" + cuisine
				+ ", cookTimeMins=" + cookTimeMins + ", recipeUrl=" + recipeUrl + ", description=" + description
				+ ", notes=" + notes + ", servingSize=" + servingSize + ", calPerServing=" + calPerServing
				+ ", ingredients=" + ingredients + "]";
	}

	
	
	
	
}
 