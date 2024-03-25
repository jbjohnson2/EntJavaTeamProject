-- MySQL dump 10.13  Distrib 8.3.0, for macos14 (arm64)
--
-- Host: 127.0.0.1    Database: wisconsin_festivals_local_test
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `Festival`
--

DROP TABLE IF EXISTS `Festival`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Festival` (
  `festival_id` int NOT NULL AUTO_INCREMENT,
  `festival_name` varchar(25) NOT NULL,
  `region_id` int NOT NULL,
  `type_id` int NOT NULL,
  `festival_start_date` date NOT NULL COMMENT 'YYYY-MM-DD',
  PRIMARY KEY (`festival_id`),
  KEY `FestivalType_fk` (`type_id`),
  KEY `FestivalRegion_fk` (`region_id`),
  KEY `festivalName_ix` (`festival_name`),
  KEY `festivalDate_ix` (`festival_start_date`),
  CONSTRAINT `FestivalRegion_fk` FOREIGN KEY (`region_id`) REFERENCES `Region` (`region_id`),
  CONSTRAINT `FestivalType_fk` FOREIGN KEY (`type_id`) REFERENCES `Type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Festival`
--

LOCK TABLES `Festival` WRITE;
/*!40000 ALTER TABLE `Festival` DISABLE KEYS */;
INSERT INTO `Festival` VALUES (1,'A Festival',1,3,'2025-12-04'),(2,'The 2nd Festival',4,6,'2024-02-02'),(3,'Free Festival',2,4,'2024-07-08'),(4,'Freshly Foods Festival',3,2,'2025-01-15');
/*!40000 ALTER TABLE `Festival` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Region`
--

DROP TABLE IF EXISTS `Region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Region` (
  `region_id` int NOT NULL AUTO_INCREMENT,
  `region_name` varchar(30) NOT NULL,
  PRIMARY KEY (`region_id`),
  KEY `regionName_ix` (`region_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Region`
--

LOCK TABLES `Region` WRITE;
/*!40000 ALTER TABLE `Region` DISABLE KEYS */;
INSERT INTO `Region` VALUES (3,'Fox Valley'),(7,'Greater Milwaukee'),(1,'North Central'),(4,'Northeastern'),(2,'Northwestern'),(5,'South Central'),(6,'South Eastern');
/*!40000 ALTER TABLE `Region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Type`
--

DROP TABLE IF EXISTS `Type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(15) NOT NULL,
  PRIMARY KEY (`type_id`),
  KEY `type_ix` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Type`
--

LOCK TABLES `Type` WRITE;
/*!40000 ALTER TABLE `Type` DISABLE KEYS */;
INSERT INTO `Type` VALUES (5,'arts'),(6,'community'),(4,'cultural'),(2,'film'),(3,'food'),(7,'misc/other'),(1,'music');
/*!40000 ALTER TABLE `Type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-24 19:50:07
