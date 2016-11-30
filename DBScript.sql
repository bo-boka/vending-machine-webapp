DROP DATABASE IF EXISTS VendingMachine;
CREATE DATABASE VendingMachine;

USE VendingMachine;

CREATE TABLE Items(
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	`cost` DECIMAL(10,4),
	`inventory` INT,
	PRIMARY KEY(`id`)
);

INSERT INTO `Items` (`id`, `name`, `cost`, `inventory`) 
			VALUES (1, "Iced Tea", 2.2, 2),
					(2, "Water", 1.2, 3),
					(3, "Trail Mix", 3.55, 1),
					(4, "Licorice", 1.95, 2),
					(5, "Chips", 1.75, 2),
					(6, "Crackers", 2.0, 1),
					(7, "Bag of Nuts", 2.9, 2),
					(8, "Dried Fruit", 3.25, 3),
					(9, "Sunflower Seeds", 2.5, 1),
					(10, "Gronola Bar", 3.15, 2),
					(11, "Pretzels", 1.65, 2),
					(12, "Soda", 2.12, 1),
					(13, "Oreos", 3.88, 4),
					(14, "Chocolate Bar", 2.5, 3);



