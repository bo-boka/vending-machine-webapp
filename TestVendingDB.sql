DROP DATABASE IF EXISTS TestVendingDB;
CREATE DATABASE TestVendingDB;

USE TestVendingDB;

CREATE TABLE IF NOT EXISTS Items(
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

--
-- Table structure for table `users`
--
CREATE TABLE IF NOT EXISTS `users` (
 `user_id` int(11) NOT NULL AUTO_INCREMENT,
 `username` varchar(20) NOT NULL,
 `password` varchar(20) NOT NULL,
 `enabled` tinyint(1) NOT NULL,
 PRIMARY KEY (`user_id`),
 KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;
--
-- Dumping data for table `users`
--
INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`) VALUES
(1, 'admin', 'password', 1),
(2, 'user', 'password', 1),
(3, 'both', 'password', 1),
(4, 'neither', 'password', 1);
--
-- Table structure for table `authorities`
--
CREATE TABLE IF NOT EXISTS `authorities` (
 `username` varchar(20) NOT NULL,
 `authority` varchar(20) NOT NULL,
 KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Dumping data for table `authorities`
--
INSERT INTO `authorities` (`username`, `authority`) VALUES
('admin', 'ROLE_ADMIN'),
('user', 'ROLE_USER'),
('both', 'ROLE_ADMIN'),
('both', 'ROLE_USER'),
('neither', 'EATS_POTATOES');
--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
 ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

