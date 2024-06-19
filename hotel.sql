-- MariaDB dump 10.19-11.3.1-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: hotel
-- ------------------------------------------------------
-- Server version	11.3.1-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `Dni` char(10) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Surnames` varchar(50) DEFAULT NULL,
  `Phone` char(9) NOT NULL,
  `Mail` varchar(40) NOT NULL,
  `password` varchar(140) NOT NULL,
  `admin` int(1) NOT NULL,
  PRIMARY KEY (`Dni`),
  UNIQUE KEY `Phone` (`Phone`),
  UNIQUE KEY `Mail` (`Mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES
('111BB','Manolo','CP','644553342','manolo@gmail.com','987654321',1),
('3333A','Juan','Castro','644112200','manuelcosanopalma@gmail.com','87cd084d190e436f147322b90e7384f6a8e0676c99d21ef519ea718e51d45f9c',4),
('3333P','Antonio','','655443322','juancarlos54@gmail.com','d0b052a5e7b3b18163829bb073b3d3a2156b153c1cab714770b40cf54cbd6843',4),
('333BB','Manolo','Cosano','644778899','manuelcp@gmail.com','c431f3e8f53c2d843e6b5d753efef8619e2f616567b3537fc0d7d6734a317171',0),
('4444W','Juandabid','Domingas','723445522','juandabid@gmail.com','9136df8800a789b2667870f4109a7c85c095696bc1c7168c4bb5cfe6bd43bdb9',0),
('444BV','Manolo','Cosano','644110022','manolocosano@gmail.com','0f7985b98ee6c5d1df0a54a3a215904bfdf9e33ab8a1de12c63fc26ea9818cc0',1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dor`
--

DROP TABLE IF EXISTS `dor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dor` (
  `Dni` char(10) NOT NULL,
  `CodReserve` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`Dni`,`CodReserve`),
  KEY `FK_dor_reserva2` (`CodReserve`),
  CONSTRAINT `FK_dor_reserva2` FOREIGN KEY (`CodReserve`) REFERENCES `reserva2` (`CodReserve`),
  CONSTRAINT `dor_ibfk_1` FOREIGN KEY (`Dni`) REFERENCES `client` (`Dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dor`
--

LOCK TABLES `dor` WRITE;
/*!40000 ALTER TABLE `dor` DISABLE KEYS */;
INSERT INTO `dor` VALUES
('3333A',4),
('3333A',5);
/*!40000 ALTER TABLE `dor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva2`
--

DROP TABLE IF EXISTS `reserva2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva2` (
  `CodReserve` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `CodRoom` char(5) DEFAULT NULL,
  PRIMARY KEY (`CodReserve`),
  KEY `CodRoom` (`CodRoom`),
  CONSTRAINT `CodRoom` FOREIGN KEY (`CodRoom`) REFERENCES `room` (`CodRoom`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva2`
--

LOCK TABLES `reserva2` WRITE;
/*!40000 ALTER TABLE `reserva2` DISABLE KEYS */;
INSERT INTO `reserva2` VALUES
(1,'2024-07-07','2222C'),
(2,'2024-07-07','8888W'),
(3,'2024-04-23','VVV67'),
(4,'2024-03-23','8888W'),
(5,'2023-09-09','8888W'),
(6,'2024-04-05','2222C');
/*!40000 ALTER TABLE `reserva2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserve`
--

DROP TABLE IF EXISTS `reserve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserve` (
  `CodReserve` char(10) NOT NULL,
  `Date` date DEFAULT NULL,
  `CodRoom` char(10) DEFAULT NULL,
  PRIMARY KEY (`CodReserve`),
  KEY `CodRoom` (`CodRoom`),
  CONSTRAINT `reserve_ibfk_1` FOREIGN KEY (`CodRoom`) REFERENCES `room` (`CodRoom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve`
--

LOCK TABLES `reserve` WRITE;
/*!40000 ALTER TABLE `reserve` DISABLE KEYS */;
INSERT INTO `reserve` VALUES
('6DDDD','2024-03-03','2222C'),
('77777','2024-04-03','8888W'),
('AAAA9','2024-08-09','VVV67');
/*!40000 ALTER TABLE `reserve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `CodRoom` char(10) NOT NULL,
  `beds` int(1) unsigned NOT NULL DEFAULT 1,
  `windows` int(1) unsigned NOT NULL DEFAULT 1,
  `TypeR` enum('SUITE','BIGGER','DELUXE') NOT NULL,
  `price` int(4) NOT NULL,
  PRIMARY KEY (`CodRoom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES
('2222C',3,8,'BIGGER',444),
('33333',1,2,'SUITE',234),
('44444',3,6,'BIGGER',322),
('7388K',1,1,'DELUXE',3000),
('8888W',4,3,'DELUXE',500),
('VVV67',7,7,'BIGGER',777);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-19 22:19:33
