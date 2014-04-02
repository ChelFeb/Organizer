-- Table 'users'
CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `registrationDate` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1;

-- Table 'events'
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(250) COLLATE utf8_bin NOT NULL,
  `description` longtext COLLATE utf8_bin DEFAULT NULL,
  `isDone` bit(1) DEFAULT NULL,
  `ownerId` int(11) NOT NULL,
  'type' varchar(50),
  `dateStart` datetime DEFAULT NULL,
  `dateEnd` datetime DEFAULT NULL,
  `deadLine` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ownerId` (`ownerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1;

-- Foreign key events.ownerId -> users.id
ALTER TABLE `events`
  ADD CONSTRAINT `FKEventsOwnerID` FOREIGN KEY (`ownerId`) REFERENCES `users` (`ID`) ON DELETE CASCADE;

-- table 'userroles`
CREATE TABLE IF NOT EXISTS `userroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKUserRolesUserID` (`userId`),
  KEY `FKUserRolesRoleID` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- table `roles`
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(25) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role` (`role`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

-- table `roles`
INSERT INTO `roles` (`id`, `role`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- foreign keys `userroles`
ALTER TABLE `userroles`
  ADD CONSTRAINT `FKUserRolesRoleID` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKUserRolesUserID` FOREIGN KEY (`userId`) REFERENCES `users` (`ID`) ON DELETE CASCADE;

