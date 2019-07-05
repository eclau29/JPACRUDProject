package com.skilldistillery.mealplanning.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="meal_type")
	private String mealType;
	
	private String cuisine;
	
	@Column(name="main_ingredient")
	private String mainIngredient;
	
	@Column(name="cook_time_mins")
	private int cookTimeMins;
	
	@Column(name="recipe_url")
	private String recipeUrl;
	
	private String description;
	
	private String notes;
	
	@Column(name="serving_size")
	private int servingSize;
	
	@Column(name="cal_per_serving")
	private Integer calPerServing;

	public int getId() {
		return id;
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

	public String getMainIngredient() {
		return mainIngredient;
	}

	public void setMainIngredient(String mainIngredient) {
		this.mainIngredient = mainIngredient;
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
		result = prime * result + ((calPerServing == null) ? 0 : calPerServing.hashCode());
		result = prime * result + cookTimeMins;
		result = prime * result + ((cuisine == null) ? 0 : cuisine.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((mainIngredient == null) ? 0 : mainIngredient.hashCode());
		result = prime * result + ((mealType == null) ? 0 : mealType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((recipeUrl == null) ? 0 : recipeUrl.hashCode());
		result = prime * result + servingSize;
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
		if (calPerServing == null) {
			if (other.calPerServing != null)
				return false;
		} else if (!calPerServing.equals(other.calPerServing))
			return false;
		if (cookTimeMins != other.cookTimeMins)
			return false;
		if (cuisine == null) {
			if (other.cuisine != null)
				return false;
		} else if (!cuisine.equals(other.cuisine))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (mainIngredient == null) {
			if (other.mainIngredient != null)
				return false;
		} else if (!mainIngredient.equals(other.mainIngredient))
			return false;
		if (mealType == null) {
			if (other.mealType != null)
				return false;
		} else if (!mealType.equals(other.mealType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (recipeUrl == null) {
			if (other.recipeUrl != null)
				return false;
		} else if (!recipeUrl.equals(other.recipeUrl))
			return false;
		if (servingSize != other.servingSize)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", mealType=" + mealType + ", cuisine=" + cuisine
				+ ", mainIngredient=" + mainIngredient + ", cookTimeMins=" + cookTimeMins + ", recipeUrl=" + recipeUrl
				+ ", description=" + description + ", notes=" + notes + ", servingSize=" + servingSize
				+ ", calPerServing=" + calPerServing + "]";
	}
	
	
	
}
 