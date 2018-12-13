CREATE DATABASE  IF NOT EXISTS `ecole` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `ecole`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: ecole
-- ------------------------------------------------------
-- Server version	8.0.13

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
  `PHONE` varchar(20) NOT NULL,
  `EMAIL` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'CARDOSO','Olivier','25 avenue de la republique','06257598','o.c@lo54.fr'),(2,'PERROT','Mathilde','2 rue de la France','06257598','m.p@lo54.fr'),(3,'MICHAEL','Jordan','3 rue de la France','06257598','J.k@lo54.fr'),(4,'IZY','Jean-Luis','4 rue de la France','06257598','J.k@lo54.fr'),(5,'LIZZY','Kevin','5 rue de la France','06257598','J.k@lo54.fr'),(6,'PIZZY','Roger','6 rue de la France','06257598','J.k@lo54.fr'),(7,'ICHI','Marion','7 rue de la France','06257598','J.k@lo54.frJ.k@lo54.fr'),(8,'OKI','Charlotte','8 rue de la France','06257598','J.k@lo54.fr'),(9,'MINIE','Marine','9 rue de la France','06257598','J.k@lo54.fr'),(10,'TEDDY','Carole','10 rue de la France','06257598','J.k@lo54.fr'),(11,'PICCINI','Franck','11 rue de la France','06257598','J.k@lo54.fr'),(12,'Dubois','Jean-Du','21000 Dijon','0325456321','blabla@free.fr'),(29,'CARDIN','Rolland','21 rue machin','0635214896','rcardin@free.fr'),(31,'Janvier','Robert','4 rue Emile Zozo','0365478520','robertdu82@free.fr');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-13 18:40:51
