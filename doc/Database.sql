-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 06-Out-2023 às 00:32
-- Versão do servidor: 8.0.27
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `borrachadb`
--
CREATE DATABASE IF NOT EXISTS `borrachadb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `borrachadb`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `cpf` varchar(18) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int UNSIGNED NOT NULL,
  `street_address` varchar(150) DEFAULT NULL,
  `number_address` varchar(20) DEFAULT NULL,
  `district_address` varchar(50) DEFAULT NULL,
  `city_address` varchar(50) DEFAULT NULL,
  `zip_code` varchar(10) DEFAULT NULL,
  `phone` varchar(14) DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `payment_status` tinyint DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clients_has_health_plans`
--

DROP TABLE IF EXISTS `clients_has_health_plans`;
CREATE TABLE IF NOT EXISTS `clients_has_health_plans` (
  `client_id` int UNSIGNED NOT NULL,
  `health_plan_id` int UNSIGNED NOT NULL,
  PRIMARY KEY (`client_id`,`health_plan_id`),
  KEY `fk_clients_has_health_plans_health_plans1_idx` (`health_plan_id`),
  KEY `fk_clients_has_health_plans_clients_idx` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clients_has_schedules`
--

DROP TABLE IF EXISTS `clients_has_schedules`;
CREATE TABLE IF NOT EXISTS `clients_has_schedules` (
  `client_id` int UNSIGNED NOT NULL,
  `schedule_id` int UNSIGNED NOT NULL,
  PRIMARY KEY (`client_id`,`schedule_id`),
  KEY `fk_clients_has_schedules_schedules1_idx` (`schedule_id`),
  KEY `fk_clients_has_schedules_clients1_idx` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estrutura da tabela `health_plans`
--

DROP TABLE IF EXISTS `health_plans`;
CREATE TABLE IF NOT EXISTS `health_plans` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `is_active` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `health_plans`
--

INSERT INTO `health_plans` (`id`, `name`, `is_active`) VALUES
(1, 'Unimed Belém', 0),
(2, 'Hapvida', 0),
(3, 'SUS', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `physiotherapists`
--

DROP TABLE IF EXISTS `physiotherapists`;
CREATE TABLE IF NOT EXISTS `physiotherapists` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cpf` varchar(18) NOT NULL,
  `coffito` varchar(25) NOT NULL,
  `street_address` varchar(150) DEFAULT NULL,
  `number_address` varchar(20) DEFAULT NULL,
  `district_address` varchar(50) DEFAULT NULL,
  `city_address` varchar(50) DEFAULT NULL,
  `zip_code` varchar(10) DEFAULT NULL,
  `is_active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pilates_classes`
--

DROP TABLE IF EXISTS `pilates_classes`;
CREATE TABLE IF NOT EXISTS `pilates_classes` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `shift` varchar(45) NOT NULL,
  `is_active` tinyint NOT NULL,
  `physiotherapist_id` int UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pilates_classes_physiotherapists1_idx` (`physiotherapist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pilates_classes_has_clients`
--

DROP TABLE IF EXISTS `pilates_classes_has_clients`;
CREATE TABLE IF NOT EXISTS `pilates_classes_has_clients` (
  `pilates_classe_id` int UNSIGNED NOT NULL,
  `client_id` int UNSIGNED NOT NULL,
  PRIMARY KEY (`pilates_classe_id`,`client_id`),
  KEY `fk_pilates_classes_has_clients_clients1_idx` (`client_id`),
  KEY `fk_pilates_classes_has_clients_pilates_classes1_idx` (`pilates_classe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estrutura da tabela `schedules`
--

DROP TABLE IF EXISTS `schedules`;
CREATE TABLE IF NOT EXISTS `schedules` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `service_id` int UNSIGNED NOT NULL,
  `is_active` tinyint NOT NULL,
  `physiotherapist_id` int UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_schedules_services1_idx` (`service_id`),
  KEY `fk_schedules_physiotherapists1_idx` (`physiotherapist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estrutura da tabela `services`
--

DROP TABLE IF EXISTS `services`;
CREATE TABLE IF NOT EXISTS `services` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `is_active` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `clients_has_health_plans`
--
ALTER TABLE `clients_has_health_plans`
  ADD CONSTRAINT `fk_clients_has_health_plans_clients` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `fk_clients_has_health_plans_health_plans1` FOREIGN KEY (`health_plan_id`) REFERENCES `health_plans` (`id`);

--
-- Limitadores para a tabela `clients_has_schedules`
--
ALTER TABLE `clients_has_schedules`
  ADD CONSTRAINT `fk_clients_has_schedules_clients1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `fk_clients_has_schedules_schedules1` FOREIGN KEY (`schedule_id`) REFERENCES `schedules` (`id`);

--
-- Limitadores para a tabela `pilates_classes`
--
ALTER TABLE `pilates_classes`
  ADD CONSTRAINT `fk_pilates_classes_physiotherapists1` FOREIGN KEY (`physiotherapist_id`) REFERENCES `physiotherapists` (`id`);

--
-- Limitadores para a tabela `pilates_classes_has_clients`
--
ALTER TABLE `pilates_classes_has_clients`
  ADD CONSTRAINT `fk_pilates_classes_has_clients_clients1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `fk_pilates_classes_has_clients_pilates_classes1` FOREIGN KEY (`pilates_classe_id`) REFERENCES `pilates_classes` (`id`);

--
-- Limitadores para a tabela `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `fk_schedules_physiotherapists1` FOREIGN KEY (`physiotherapist_id`) REFERENCES `physiotherapists` (`id`),
  ADD CONSTRAINT `fk_schedules_services1` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
