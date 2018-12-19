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
  `PHONE` varchar(20) NOT NULL,
  `EMAIL` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'CARDOSO','Olivier','25 avenue de la republique','0625759847','o.c@lo54.fr'),(2,'PERROT','Mathilde','2 rue de la France','0625759858','m.p@lo54.fr'),(3,'MICHAEL','Jordan','3 rue de la France','0625759847','J.k@lo54.fr'),(4,'IZY','Jean-Louis','4 rue de la France','0625759896','J.k@lo54.fr'),(5,'LIZZY','Kevin','5 rue de la France','0625759898','J.k@lo54.fr'),(6,'PIZZY','Roger','6 rue de la France','0625759885','J.k@lo54.fr'),(7,'ICHI','Marion','7 rue de la France','0625759878','J.k@lo54.frJ.k@lo54.fr'),(8,'KLAUS','Charlotte','8 rue de la France','0625759885','J.k@lo54.fr'),(9,'MINIE','Marine','9 rue de la France','0625759847','J.k@lo54.fr'),(10,'TEDDY','Carole','10 rue de la France','0625759858','J.k@lo54.fr'),(11,'PICCINI','Franck','11 rue de la France','0625759814','J.k@lo54.fr'),(12,'DUBOIS','Jean','15 rue du Pont','0325456321','blabla@free.fr'),(29,'CARDIN','Rolland','21 rue de la Poste','0635214896','rcardin@free.fr'),(31,'JAVIER','Robert','4 rue Emile Zola','0365478520','robertdu82@free.fr'),(51,'BANNWARTH','Elora','1 rue jules ferry','06257489565','e.b@gmail.com'),(52,'MABROUKI','Fares','24 rue denfer rochereau','062538465','f.m@utbm.fr'),(53,'REMY','Leo','24 rue denfer rochereau','0525251535','L.r@utbm.fr'),(54,'FRANCK','Franco','1 rue jules ferry','062538465','e.b@gmail.com'),(55,'PERROT','Mathilda','1 rue jules ferry','0525251535','e.b@gmail.com'),(56,'MTCHEL','Eddie','a','0525251535','e.b@gmail.com'),(57,'CARDOSO','Sophie','1 rue jules ferry','062538465','e.b@gmail.com'),(58,'RICHARD','Olivier','14 rue thierry Mieg','0625458565','o.r@ubm.fr'),(59,'DUPONT','Jean','1 rue de la banque','0525251535','e.b@gmail.com'),(60,'DUPONTAIGNANT','Jean','1 rue de la banque','0525251535','e.b@gmail.com'),(61,'ECOLO','Jean','1 rue de la banque','0525251535','e.b@gmail.com'),(62,'ADAMO','Stephane','Paris','0625153654','a.d@utbm.fr'),(63,'AMELLAL','Viviane','Paris','0521154585','A.v@utbm.fr'),(64,'AZOURA','Marie-France','DIJON','052856454','a.m.f@utbm.fr'),(65,'VINCENT','Francky','ANTILLE','0658456525','f.c@gmail.com'),(66,'FRANCK','Jean','1 rue de la banque','0525251535','e.b@gmail.com'),(67,'CARDOSO','Jean','1 rue jules ferry','0412188546','a');
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

-- Dump completed on 2018-12-19 20:44:25
