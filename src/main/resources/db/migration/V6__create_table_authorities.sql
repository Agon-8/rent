DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
`id` int not null primary key,
`user_id` int,
`authority` varchar(50) ,
UNIQUE KEY `authorities_idx_1` (`user_id`,`authority`),
CONSTRAINT `authorities_ibfk_1`
FOREIGN KEY (`user_id`)
REFERENCES `users` (`user_id`)
);