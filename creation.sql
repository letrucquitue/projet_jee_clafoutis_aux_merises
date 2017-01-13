DROP DATABASE IF EXISTS `SimulateurPanneSQL`;
CREATE DATABASE `SimulateurPanneSQL`;
USE `SimulateurPanneSQL`;

DROP TABLE IF EXISTS `machine`;
CREATE TABLE `machine`(
	`type` VARCHAR(30) NOT NULL,
	`id_machine` VARCHAR(16) NOT NULL,
	PRIMARY KEY (`id_machine`)
);

DROP TABLE IF EXISTS `panne`;
CREATE TABLE `panne`(
	`type` VARCHAR(30) NOT NULL,
	`date_apparition` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`id_machine` VARCHAR(16) NOT NULL,
	`reparee` BOOLEAN NOT NULL DEFAULT 0,
	PRIMARY KEY (`type`, `id_machine`),
	FOREIGN KEY (`id_machine`) REFERENCES `machine`(`id_machine`)
);



