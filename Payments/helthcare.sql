-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2020 at 09:40 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `helthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `appoiment`
--

CREATE TABLE `appoiment` (
  `appoimentID` int(11) NOT NULL,
  `appoimentDate` datetime NOT NULL,
  `pid` int(10) NOT NULL,
  `did` int(10) NOT NULL,
  `hid` int(10) NOT NULL,
  `createDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `appoiment`
--

INSERT INTO `appoiment` (`appoimentID`, `appoimentDate`, `pid`, `did`, `hid`, `createDate`) VALUES
(1, '2020-04-29 10:02:56', 1, 1, 1, '2020-04-18'),
(2, '2020-04-30 10:03:27', 2, 2, 2, '2020-04-18'),
(3, '2020-04-29 12:10:56', 3, 1, 1, '2020-04-18');

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `CID` int(10) NOT NULL,
  `paymentID` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `cname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ctype` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `cardNo` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `cvv` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `expDate` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `card`
--

INSERT INTO `card` (`CID`, `paymentID`, `cname`, `ctype`, `cardNo`, `cvv`, `expDate`) VALUES
(1, '1', 'eee', 'MasterCard', '4565555555555555', '555', '2020-04-29'),
(2, '2', 'www', 'VISA', '4545444444444444', '444', '2020-04-29'),
(3, '3', 'sss', 'MasterCard', '4533333333333333', '333', '2020-04-29');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctorID` int(10) NOT NULL,
  `doctorName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `doctorfees` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctorID`, `doctorName`, `doctorfees`) VALUES
(1, 'asas', 2000),
(2, 'rfrf', 2500);

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `hosID` int(10) NOT NULL,
  `hosName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `hosAddress` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `hosPhone` int(11) NOT NULL,
  `hosFees` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`hosID`, `hosName`, `hosAddress`, `hosPhone`, `hosFees`) VALUES
(1, 'rrr', 'colombo 3', 114576389, 1000),
(2, 'ttt', 'colombo 6', 112343234, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patientID` int(10) NOT NULL,
  `patientName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `patientAge` int(3) NOT NULL,
  `patientPhone` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `addresss` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientID`, `patientName`, `patientAge`, `patientPhone`, `email`, `addresss`, `username`, `password`) VALUES
(1, 'www', 32, 112456789, 'dssd@gmail.com', 'colombo13', 'www', 'www'),
(2, 'eee', 45, 112456778, 'eee@gmail.com', 'colombo 10', 'eee', 'eee'),
(3, 'sss', 33, 112456789, 'sss@gmail.com', 'colombo13', 'sss', 'sss');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `paymentID` int(10) NOT NULL,
  `appoimentDate` datetime DEFAULT NULL,
  `patientName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `doctorName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `hosName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `hosFees` int(10) NOT NULL,
  `doctorfees` int(10) DEFAULT NULL,
  `total` int(10) NOT NULL,
  `paydate` date NOT NULL,
  `appoiment` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentID`, `appoimentDate`, `patientName`, `doctorName`, `hosName`, `hosFees`, `doctorfees`, `total`, `paydate`, `appoiment`) VALUES
(1, '2020-04-30 10:03:27', 'eee', 'rfrf', 'ttt', 1000, 2500, 3500, '2020-04-18', 2),
(2, '2020-04-29 10:02:56', 'www', 'asas', 'rrr', 1000, 2000, 3000, '2020-04-18', 1),
(3, '2020-04-29 12:10:56', 'sss', 'asas', 'rrr', 1000, 2000, 3000, '2020-04-18', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appoiment`
--
ALTER TABLE `appoiment`
  ADD PRIMARY KEY (`appoimentID`),
  ADD KEY `fk1` (`pid`),
  ADD KEY `fk2` (`did`),
  ADD KEY `fk3` (`hid`);

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`CID`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctorID`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`hosID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`paymentID`),
  ADD KEY `fk22` (`appoiment`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appoiment`
--
ALTER TABLE `appoiment`
  MODIFY `appoimentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `card`
--
ALTER TABLE `card`
  MODIFY `CID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doctorID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `hosID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patientID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `paymentID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appoiment`
--
ALTER TABLE `appoiment`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`pid`) REFERENCES `patient` (`patientID`),
  ADD CONSTRAINT `fk2` FOREIGN KEY (`did`) REFERENCES `doctor` (`doctorID`),
  ADD CONSTRAINT `fk3` FOREIGN KEY (`hid`) REFERENCES `hospital` (`hosID`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `fk22` FOREIGN KEY (`appoiment`) REFERENCES `appoiment` (`appoimentID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
