CREATE TABLE `authorities` (
`user_id` int NOT NULL,
`authority` varchar(50) NOT NULL,
UNIQUE KEY `authorities_idx_1` (`user_id`,`authority`),
CONSTRAINT `authorities_ibfk_1`
FOREIGN KEY (`user_id`)
REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;