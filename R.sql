-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2024 at 08:22 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `railwayreservation`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `after_insert_ticket` (IN `seat_no` INT, IN `no` INT)   UPDATE train_detail SET available_ticket=(available_ticket-seat_no) ,booked_ticket=(booked_ticket+seat_no) WHERE train_no=no$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `ticket_detail`
--

CREATE TABLE `ticket_detail` (
  `ticket_id` int(10) NOT NULL,
  `seat_no` int(100) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `train_name` varchar(50) NOT NULL,
  `train_no` int(10) NOT NULL,
  `ticket_price` double NOT NULL,
  `date` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ticket_detail`
--

INSERT INTO `ticket_detail` (`ticket_id`, `seat_no`, `user_name`, `train_name`, `train_no`, `ticket_price`, `date`) VALUES
(5, 3, 'Vrisha', 'Karnavati', 2970, 0, '2024-09-08'),
(6, 2, 'Dhruvi', 'KaviGuru', 1235, 0, '2024-09-10'),
(7, 2, 'Rutvi', 'Karnavati', 3, 460, '2024-12-02'),
(8, 2, 'Krisha', 'Karnavati', 2013, 0, '2024-09-10'),
(9, 2, 'tithie', 'karnavati', 4, 460, '2024-09-12'),
(10, 21, 'jai', 'karnavati', 4, 4830, '2024-09-12'),
(11, 3, 'jaiva', 'karnavati', 4, 690, '2024-3-23');

-- --------------------------------------------------------

--
-- Table structure for table `train_detail`
--

CREATE TABLE `train_detail` (
  `train_no` int(10) NOT NULL,
  `train_name` varchar(50) NOT NULL,
  `source` varchar(50) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `available_ticket` int(11) NOT NULL,
  `booked_ticket` int(11) NOT NULL,
  `departure_time` varchar(50) NOT NULL,
  `arrival_time` varchar(50) NOT NULL,
  `ticket_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `train_detail`
--

INSERT INTO `train_detail` (`train_no`, `train_name`, `source`, `destination`, `available_ticket`, `booked_ticket`, `departure_time`, `arrival_time`, `ticket_price`) VALUES
(4, 'karnavati', 'Ahmed', 'Surat', 74, 26, '8', '12', 230);

-- --------------------------------------------------------

--
-- Table structure for table `user_detail`
--

CREATE TABLE `user_detail` (
  `user_id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(6) NOT NULL,
  `ac_no` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_detail`
--

INSERT INTO `user_detail` (`user_id`, `name`, `phone_no`, `address`, `email`, `password`, `ac_no`) VALUES
(1, 'vrisha', '8140779834', 'Surat', 'vr12@gmail.com', 'Vr@12', '123456789111');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ticket_detail`
--
ALTER TABLE `ticket_detail`
  ADD PRIMARY KEY (`ticket_id`);

--
-- Indexes for table `train_detail`
--
ALTER TABLE `train_detail`
  ADD PRIMARY KEY (`train_no`);

--
-- Indexes for table `user_detail`
--
ALTER TABLE `user_detail`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ticket_detail`
--
ALTER TABLE `ticket_detail`
  MODIFY `ticket_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `train_detail`
--
ALTER TABLE `train_detail`
  MODIFY `train_no` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user_detail`
--
ALTER TABLE `user_detail`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
