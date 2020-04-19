-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 19, 2020 at 07:22 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pafprojectdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointmenttable`
--

DROP TABLE IF EXISTS `appointmenttable`;
CREATE TABLE IF NOT EXISTS `appointmenttable` (
  `appointmentID` int(11) NOT NULL AUTO_INCREMENT,
  `patientName` varchar(255) NOT NULL,
  `doctorName` varchar(255) NOT NULL,
  `appointmentNumber` int(35) NOT NULL,
  `hospitalName` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `date` varchar(155) NOT NULL,
  PRIMARY KEY (`appointmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `doctortable`
--

DROP TABLE IF EXISTS `doctortable`;
CREATE TABLE IF NOT EXISTS `doctortable` (
  `doctorID` int(11) NOT NULL AUTO_INCREMENT,
  `doctorName` varchar(255) NOT NULL,
  `doctorSpecialization` varchar(255) NOT NULL,
  PRIMARY KEY (`doctorID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hospitaltable`
--

DROP TABLE IF EXISTS `hospitaltable`;
CREATE TABLE IF NOT EXISTS `hospitaltable` (
  `hospitalID` int(11) NOT NULL AUTO_INCREMENT,
  `hospitalCode` varchar(255) NOT NULL,
  `hospitalName` varchar(255) NOT NULL,
  `hospitalType` varchar(255) NOT NULL,
  `hospitalNumber` int(255) NOT NULL,
  `hospitalDesc` varchar(255) NOT NULL,
  `hospitalPlace` varchar(255) NOT NULL,
  PRIMARY KEY (`hospitalID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospitaltable`
--

INSERT INTO `hospitaltable` (`hospitalID`, `hospitalCode`, `hospitalName`, `hospitalType`, `hospitalNumber`, `hospitalDesc`, `hospitalPlace`) VALUES
(1, 'Hos-1', 'Lanka Hospital', 'All', 755589865, 'description', 'Colombo');

-- --------------------------------------------------------

--
-- Table structure for table `patienttable`
--

DROP TABLE IF EXISTS `patienttable`;
CREATE TABLE IF NOT EXISTS `patienttable` (
  `patientID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `cNumber` int(255) NOT NULL,
  `age` varchar(255) NOT NULL,
  `nic` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  PRIMARY KEY (`patientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
