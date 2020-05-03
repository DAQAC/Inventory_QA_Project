-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory_project
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Shonen','2020-05-03 13:50:53','2020-05-03 15:41:57'),(2,'isekai','2020-05-03 15:05:03','2020-05-03 15:42:38');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CID` int NOT NULL,
  `first_name` varchar(32) NOT NULL,
  `last_name` varchar(32) NOT NULL,
  `age` tinyint NOT NULL,
  `address` varchar(150) NOT NULL,
  `email` varchar(320) NOT NULL,
  `city` varchar(64) NOT NULL,
  `post_code` char(10) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Daryl','Atienza',21,'82  Kent Street','DAtienza@email.com','Newcastle','NE26-4OL','2020-05-03 13:54:51','2020-05-03 13:59:42'),(2,'Luca','Garison',25,'69  Holgate Rd','LGarison@email.com','Liverpool','L32-0RR','2020-05-03 13:54:51','2020-05-03 13:58:17'),(3,'Joe','Mahmood',18,'57  Long Street','JMahmood@email.com','Manchester','M46-0PE','2020-05-03 13:54:51','2020-05-03 13:58:17'),(4,'Sophie','Bishop',20,'78  Newgate Street','SBishop@email.com','Leeds','LS19-6PE','2020-05-03 13:54:51','2020-05-03 13:58:17'),(5,'Noah','Nicholson',21,'79  Berkeley Rd','NNicholson@email.com','Newcastle','NE13-R23','2020-05-03 13:54:51','2020-05-03 13:58:17'),(6,'Sadiik','Hussain',25,'20 Richmond Lane','SHussain@email.com','Bradford','BD7-9LK','2020-05-03 13:54:51','2020-05-03 13:58:17'),(7,'Joshua','Entowe',22,'56 Little Horton Ln','JEntowe@email.com','Essex','CB1 6NY','2020-05-03 13:54:51','2020-05-03 13:58:17'),(8,'Raqeem','Tanweer',16,'78 Crossbidge St','RTanweer@email.com','Bradford','BD4-4RS','2020-05-03 13:54:51','2020-05-03 13:58:17'),(9,'Lucy','Heathwood',32,'Grandmanor Household','LHeathwood@gmail.com','London','NW7-2LL','2020-05-03 13:54:51','2020-05-03 13:58:17'),(10,'James','Tiffany',30,'66 Ham ln','JTiffany@gmail.com','London','E20-H78','2020-05-03 13:54:51','2020-05-03 13:58:17');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `OID` int NOT NULL,
  `total` decimal(4,2) NOT NULL,
  `fk_CID` int NOT NULL,
  PRIMARY KEY (`OID`),
  KEY `fk_CID` (`fk_CID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`fk_CID`) REFERENCES `customer` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,9.99,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_products`
--

DROP TABLE IF EXISTS `orders_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_products` (
  `PID` int DEFAULT NULL,
  `OID` int DEFAULT NULL,
  KEY `PID` (`PID`),
  KEY `OID` (`OID`),
  CONSTRAINT `orders_products_ibfk_1` FOREIGN KEY (`PID`) REFERENCES `products` (`PID`),
  CONSTRAINT `orders_products_ibfk_2` FOREIGN KEY (`OID`) REFERENCES `orders` (`OID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_products`
--

LOCK TABLES `orders_products` WRITE;
/*!40000 ALTER TABLE `orders_products` DISABLE KEYS */;
INSERT INTO `orders_products` VALUES (1,1);
/*!40000 ALTER TABLE `orders_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `PID` int NOT NULL,
  `name` varchar(128) NOT NULL,
  `age_rating` tinyint NOT NULL,
  `release_date` varchar(32) NOT NULL,
  `price` decimal(4,2) NOT NULL,
  `stock` int NOT NULL,
  `new_volume_released` varchar(8) NOT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'One Piece',13,'20-08-1999',9.99,100,'YES','2020-05-03 15:38:46'),(2,'Bleach',16,'05-08-2004',7.00,100,'YES','2020-05-03 15:38:46'),(3,'Dragon Ball',16,'26-02-1986',20.00,100,'YES','2020-05-03 15:38:46'),(4,'Dragonball Z',16,'26-04-1989',18.00,100,'YES','2020-05-03 15:38:46'),(5,'Dragonball Super',16,'05-04-2015',20.99,100,'YES','2020-05-03 15:38:46'),(6,'My Hero Academia',13,'03-04-2016',14.99,100,'YES','2020-05-03 15:38:46'),(7,'Attack on Titans',18,'06-04-2013',15.00,100,'YES','2020-05-03 15:38:46'),(8,'Demon Slayer',18,'06-04-2019',5.99,100,'YES','2020-05-03 15:38:46'),(9,'The Promised Neverland',18,'11-01-2019',15.00,100,'YES','2020-05-03 15:38:46'),(10,'Sword Art Online',16,'07-04-2012',10.99,100,'YES','2020-05-03 15:38:46');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-03 16:56:18
