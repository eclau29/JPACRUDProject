-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema recipedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `recipedb` ;

-- -----------------------------------------------------
-- Schema recipedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `recipedb` DEFAULT CHARACTER SET utf8 ;
USE `recipedb` ;

-- -----------------------------------------------------
-- Table `recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipe` ;

CREATE TABLE IF NOT EXISTS `recipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  `meal_type` VARCHAR(45) NULL,
  `cuisine` VARCHAR(45) NULL,
  `main_ingredient` VARCHAR(45) NULL,
  `cook_time_mins` INT NULL,
  `recipe_url` VARCHAR(200) NULL,
  `description` TEXT(1000) NULL,
  `notes` TEXT(1000) NULL,
  `serving_size` INT NULL,
  `cal_per_serving` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS recipeuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'recipeuser'@'localhost' IDENTIFIED BY 'recipeuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'recipeuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `recipe`
-- -----------------------------------------------------
START TRANSACTION;
USE `recipedb`;
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (1, 'Chicken Khao Soi', 'Lunch, Dinner', 'Thai', 'Chicken', 80, 'https://www.bonappetit.com/recipe/chicken-khao-soi', 'Chicken curry soup', 'includes soak time for chiles', 6, 700);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (2, 'Blueberry Lemon Cake', 'Breakfast, Dessert', 'American', 'Blueberry', 70, 'https://natashaskitchen.com/blueberry-lemon-cake/', 'Buckle-like cake', 'can use frozen berries', 10, 353);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (3, 'Sticky Slow Roast Lamb', 'Dinner', 'American', 'Lamb', 310, 'https://www.thelondoner.me/2016/03/sticky-slow-roast-lamb.html', NULL, 'includes gravy', 5, NULL);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (4, 'Baklava Babka', 'Breakfast, Dessert', 'Middle Eastern, Eastern European', 'Nuts', 180, 'https://smittenkitchen.com/2018/12/baklava-babka/', 'Baklava/Babka hybrid', 'makes 2 loaf pans or one tube pan', 12, NULL);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (5, 'Garlic Naan', 'Appetizer', 'Indian', 'Garlic', 40, 'https://rasamalaysia.com/garlic-naan/', 'Makes 8 pieces', 'Use cast iron skillet for best results. Uses plain Greek yoghurt', 8, 192);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (6, 'Honey Mustard Chicken Wings', 'Appetizer', 'American', 'Chicken', 60, 'https://food52.com/recipes/26997-honey-mustard-chicken-wings', 'combines dijon mustard, bourbon, soy sauce, and Sriracha', 'Needs sheet pan, cooling rack', 6, NULL);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (7, 'Croissant Brittle', 'Breakfast, Dessert', 'American', 'Croissant', 65, 'https://food52.com/recipes/77961-croissant-brittle', NULL, '', 8, NULL);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (8, 'Chinese Crullers', 'Breakfast', 'Chinese', 'Flour', 330, 'https://www.thestar.com.my/lifestyle/food/features/2014/06/22/chinese-crullers-two-recipes-plus-how-to-use-them/', NULL, 'needs caster sugar, double-action baking powder, 1.5 L cooking oil', 5, NULL);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (9, 'Hum chim paeng', 'Breakfast, Snack', 'Chinese', 'Flour', 280, 'https://www.thestar.com.my/lifestyle/food/features/2014/07/06/ham-chim-paeng-the-original-doughnut/', NULL, 'needs caster sugar, double-action baking powder, five-spice powder, 1.5L cooking oil', 8, NULL);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (10, 'Brown Buter Bacon Chocolate Chip Cookie', 'Dessert', 'American', 'Bacon', 45, 'https://thetakeout.com/how-to-make-a-killer-brown-butter-bacon-chocolate-chip-1821667488', NULL, 'Vanilla paste', 12, NULL);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (11, 'Cold Sesame Noodles', 'Lunch, Dinner', 'Chinese', 'Pasta', 30, 'https://thetakeout.com/cold-sesame-peanut-noodles-is-the-summer-dish-for-vegan-1798262022', 'Sesame noodles with chicken, cucumber', 'Uses roast chicken breast', 4, NULL);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (12, 'Vincisgrassi', 'Dinner', 'Italian', 'Wild Mushroom', 125, 'https://food52.com/recipes/74509-vincisgrassi-wild-mushroom-and-prosciutto-lasagna', 'Wild Mushroom and Prosciutto Lasagna', 'Makes fresh pasta', 6, NULL);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (13, 'Spicy Cumin Lamb Biang Biang Noodles', 'Dinner', 'Chinese', 'Lamb', 188, 'https://thewoksoflife.com/cumin-lamb-biang-biang-noodles/?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+TheWoksOfLife+%28The+Woks+of+Life%29&utm_content=Google+International', NULL, 'Mortar and Pestle, fresh dough', 4, 425);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (14, 'Milk Bread (Bao)', 'Side', 'Chinese', 'Cream', 205, 'https://thewoksoflife.com/milk-bread-2/', 'Chinese Bakery Bread', 'Uses heavy cream, milk, cake flour, bread flour', 16, 184);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (15, 'Coconut Bao', 'Dessert, Snack', 'Chinese', 'Coconut', 195, 'https://thewoksoflife.com/coconut-buns-cocktail-buns/', 'Gai Mei Bao', 'Uses heavy cream, milk, cake flour, bread flour, coconut flakes', 12, 389);
INSERT INTO `recipe` (`id`, `name`, `meal_type`, `cuisine`, `main_ingredient`, `cook_time_mins`, `recipe_url`, `description`, `notes`, `serving_size`, `cal_per_serving`) VALUES (16, 'Hot Dog Bao', 'Lunch, Snack', 'Chinese', 'Hot Dog', 180, 'https://thewoksoflife.com/chinese-hot-dog-buns/', NULL, 'Uses heavy cream, milk, cake flour, bread flour', 12, 360);

COMMIT;

