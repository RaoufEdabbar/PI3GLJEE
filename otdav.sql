-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2019 at 07:10 PM
-- Server version: 5.7.14
-- PHP Version: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


--
-- Database: `otdav`
--
CREATE DATABASE IF NOT EXISTS `otdav` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `otdav`;

-- --------------------------------------------------------
--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(254) DEFAULT NULL,
  `price` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- --------------------------------------------------------
--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(254) DEFAULT NULL,
  `password` varchar(254) DEFAULT NULL,
  `birth_date` timestamp NULL DEFAULT NULL,
  `cin` int(11) DEFAULT NULL,
  `applied_at` int(11) DEFAULT NULL,
  `validated_at` timestamp NULL DEFAULT NULL,
  `adress` varchar(254) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `mail` varchar(254) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `gender` ENUM('M', 'F'),
  `child_number` int(11) DEFAULT NULL,
  `rib` varchar(254) DEFAULT NULL,
  `photo` varchar(254) DEFAULT NULL,
  `immatriculation` varchar(254) DEFAULT NULL,
  `role` ENUM ('ADMIN', 'USER'),
  `status` varchar(254) DEFAULT NULL,
   PRIMARY KEY (id)

) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `organizations`
--

CREATE TABLE `organizations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` INT  NOT NULL,
  PRIMARY KEY (id),
  INDEX (member_id),
  FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE RESTRICT On UPDATE RESTRICT

) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `persons`
--

CREATE TABLE `persons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` INT  NOT NULL,
  PRIMARY KEY (id),
  INDEX (member_id),
  FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE RESTRICT On UPDATE RESTRICT

) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `resignations`
--

CREATE TABLE `resignations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` INT  NOT NULL,
  `resignatied_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX (member_id),
  FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE RESTRICT On UPDATE RESTRICT

) ENGINE=InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `works`
--

CREATE TABLE `works` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` int(11) DEFAULT NULL,
  `category_id` INT NOT NULL,
  `status` varchar(254) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `renewed_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX (category_id),
  FOREIGN KEY  (category_id) REFERENCES categories(id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;



--
-- Table structure for table `fees`
--

CREATE TABLE `fees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `work_id` INT  NOT NULL,
  `payed_at` timestamp NULL DEFAULT NULL,
  `canceled_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX (work_id),
  FOREIGN KEY (work_id) REFERENCES works(id) ON DELETE RESTRICT On UPDATE RESTRICT

) ENGINE=InnoDB;
-- --------------------------------------------------------

--
-- Table structure for table `depots`
--

CREATE TABLE `depots` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `work_id` INT NOT NULL,
  `member_id` INT  NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX (work_id),
  INDEX (member_id),
  FOREIGN KEY (work_id) REFERENCES works(id) ON DELETE RESTRICT On UPDATE RESTRICT,
  FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE RESTRICT On UPDATE RESTRICT
) ENGINE=InnoDB;

