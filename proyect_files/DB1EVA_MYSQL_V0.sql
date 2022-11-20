-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.9.3-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------


DROP DATABASE IF EXISTS `db1eva`;
CREATE DATABASE IF NOT EXISTS `db1eva` 
USE `db1eva`;

DROP TABLE IF EXISTS `listaempleados`;
CREATE TABLE IF NOT EXISTS `listaempleados` (
  `MATRICULA` varchar(10)  DEFAULT NULL,
  `DEPARTAMENTO` varchar(32)  DEFAULT NULL,
  `APENOM` varchar(64)  DEFAULT NULL,
  `TOTGASTOS` double DEFAULT NULL,
  `TOTVENTAS` double DEFAULT NULL,
  `FECHA` date DEFAULT NULL
);
