DROP DATABASE IF EXISTS VendingMachine;
CREATE DATABASE VendingMachine;

USE VendingMachine;

CREATE TABLE IF NOT EXISTS Items(
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	`cost` DECIMAL(10,4),
	`inventory` INT,
	PRIMARY KEY(`id`)
);

INSERT INTO `Items` (`id`, `name`, `cost`, `inventory`) 
			VALUES (1, "iPhone 22", 999.99, 25),
					(2, "Hoverpad", 350.20, 31),
					(3, "Nanobot Vaccine", 55, 886),
					(4, "Daily News Chip", 9.95, 207),
					(5, "Weekly Soylent", 19.75, 62),
					(6, "VR Movie", 14.50, 45),
					(7, "Mind Cloud Storage", 75.95, 752),
					(8, "Macintosh AI", 868.25, 3),
					(9, "Novelgram", 72.5, 796),
					(10, "Vintage Book", 33.15, 21),
					(11, "Earbuds", 15.65, 80),
					(12, "Vintage Earbuds", 32.12, 5),
					(13, "Translator Earpiece", 63.88, 47),
					(14, "Chips", 2.5, 23);

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

