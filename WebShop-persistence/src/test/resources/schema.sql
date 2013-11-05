drop table if exists users;
drop table if exists orders;

CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  login varchar(256) NOT NULL,
  password varchar(512) NOT NULL,
  enabled int(1) NOT NULL DEFAULT '1',
  name varchar(256) DEFAULT NULL,
  surname varchar(256) DEFAULT NULL,
  patronymic varchar(256) DEFAULT NULL,
  tel varchar(256) DEFAULT NULL,
  email varchar(256) DEFAULT NULL,
  creationdate date DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY login_UNIQUE (login)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `phoneId` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;