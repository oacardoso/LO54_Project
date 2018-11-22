CREATE DATABASE  IF NOT EXISTS `ecole` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `ecole`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ecole
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LAST_NAME` varchar(128) NOT NULL,
  `FIRST_NAME` varchar(128) NOT NULL,
  `ADDRESSE` varchar(128) NOT NULL,
  `PHONE` char(10) NOT NULL,
  `EMAIL` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'CARDOSO','Olivier','25 avenue de la republique','06257598','o.c@lo54.fr'),(2,'PERROT','Mathilde','2 rue de la France','06257598','m.p@lo54.fr'),(3,'MICHAEL','Jordan','3 rue de la France','06257598','J.k@lo54.fr'),(4,'IZY','Jean-Luis','4 rue de la France','06257598','J.k@lo54.fr'),(5,'LIZZY','Kevin','5 rue de la France','06257598','J.k@lo54.fr'),(6,'PIZZY','Roger','6 rue de la France','06257598','J.k@lo54.fr'),(7,'ICHI','Marion','7 rue de la France','06257598','J.k@lo54.frJ.k@lo54.fr'),(8,'OKI','Charlotte','8 rue de la France','06257598','J.k@lo54.fr'),(9,'MINIE','Marine','9 rue de la France','06257598','J.k@lo54.fr'),(10,'TEDDY','Carole','10 rue de la France','06257598','J.k@lo54.fr'),(11,'PICCINI','Franck','11 rue de la France','06257598','J.k@lo54.fr');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `course` (
  `CODE` char(4) NOT NULL,
  `TITLE` varchar(128) NOT NULL,
  PRIMARY KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('ER25','chepa'),('IF41','chepa2'),('IN51','math '),('IN52','math2'),('LO54','Java enterprises'),('PJ53','lavande'),('SM57','ene2');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_session`
--

DROP TABLE IF EXISTS `course_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `course_session` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_CODE` char(5) NOT NULL,
  `LOCATION_ID` int(11) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `MAX` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `I_FK_COURSE_SESSION_COURSE` (`COURSE_CODE`),
  KEY `I_FK_COURSE_SESSION_LOCATION` (`LOCATION_ID`),
  CONSTRAINT `FK_COURSE_SESSION_COURSE` FOREIGN KEY (`COURSE_CODE`) REFERENCES `course` (`code`),
  CONSTRAINT `FK_COURSE_SESSION_LOCATION` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_session`
--

LOCK TABLES `course_session` WRITE;
/*!40000 ALTER TABLE `course_session` DISABLE KEYS */;
INSERT INTO `course_session` VALUES (1,'ER25',2,'2001-01-19','2001-05-19',15),(2,'IF41',2,'2026-01-18','2004-12-18',50),(3,'IN51',3,'2026-01-18','2004-12-18',50),(4,'IN52',4,'2026-01-18','2004-12-18',50),(5,'LO54',5,'2026-01-18','2004-12-18',50),(6,'PJ53',1,'2026-01-18','2016-08-19',50),(7,'SM57',2,'2026-01-18','2007-05-19',50),(8,'SM57',3,'2026-01-18','2008-09-19',50),(9,'LO54',4,'2026-01-18','2005-11-19',50),(10,'IN51',5,'2026-01-18','2004-12-18',50);
/*!40000 ALTER TABLE `course_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `location` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(128) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'BELFORTZOO'),(2,'PARIS'),(3,'DIJON'),(4,'STRASBOURG'),(5,'HAWAI');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participe`
--

DROP TABLE IF EXISTS `participe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `participe` (
  `CLIENT_ID` int(11) NOT NULL,
  `COURSE_SESSION_ID` int(11) NOT NULL,
  PRIMARY KEY (`CLIENT_ID`,`COURSE_SESSION_ID`),
  KEY `I_FK_PARTICIPE_CLIENT` (`CLIENT_ID`),
  KEY `I_FK_PARTICIPE_COURSE_SESSION` (`COURSE_SESSION_ID`),
  CONSTRAINT `FK_PARTICIPE_CLIENT` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`id`),
  CONSTRAINT `FK_PARTICIPE_COURSE_SESSION` FOREIGN KEY (`COURSE_SESSION_ID`) REFERENCES `course_session` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participe`
--

LOCK TABLES `participe` WRITE;
/*!40000 ALTER TABLE `participe` DISABLE KEYS */;
INSERT INTO `participe` VALUES (1,1),(2,1),(3,2),(4,2),(5,3),(6,3),(7,4),(8,4),(9,5),(10,5),(11,6);
/*!40000 ALTER TABLE `participe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-22 16:45:21
