package com.skilldistillery.mealplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.mealplanning")
public class BootMvcMealPlanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcMealPlanningApplication.class, args);
	}

}
