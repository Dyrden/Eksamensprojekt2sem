-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: team-baever.mysql.database.azure.com    Database: bilabonnement
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `abonnementstype`
--

DROP TABLE IF EXISTS `abonnementstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abonnementstype` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bil`
--

DROP TABLE IF EXISTS `bil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bil` (
  `vognNummer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `stelNummer` varchar(17) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `staalpris` double DEFAULT NULL,
  `registreringsAfgift` double DEFAULT NULL,
  `CO2Udledning` double DEFAULT NULL,
  `produktionsaar` int DEFAULT NULL,
  `distance` int DEFAULT NULL,
  `maanedspris` double DEFAULT NULL,
  `status_ID` int NOT NULL DEFAULT '3',
  `model_ID` int NOT NULL,
  PRIMARY KEY (`vognNummer`),
  UNIQUE KEY `vognNummer_UNIQUE` (`vognNummer`),
  UNIQUE KEY `stelNummer_UNIQUE` (`stelNummer`),
  KEY `fk_bil_status1_idx` (`status_ID`),
  KEY `fk_bil_model1_idx` (`model_ID`),
  CONSTRAINT `fk_bil_model1` FOREIGN KEY (`model_ID`) REFERENCES `model` (`ID`),
  CONSTRAINT `fk_bil_status1` FOREIGN KEY (`status_ID`) REFERENCES `status` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `udlejningsStartDato` timestamp NULL DEFAULT NULL,
  `udlejningsSlutDato` timestamp NULL DEFAULT NULL,
  `kilometerStart` int DEFAULT NULL,
  `overvaaget` tinyint NOT NULL DEFAULT '0',
  `bruger_ID` int NOT NULL,
  `abonnementstype_ID` int NOT NULL,
  `udleveringssted_ID` int NOT NULL,
  `bil_vognNummer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_booking_bil_idx` (`bil_vognNummer`),
  KEY `fk_booking_bruger1_idx` (`bruger_ID`),
  KEY `fk_booking_abonnementstype1_idx` (`abonnementstype_ID`),
  KEY `fk_booking_udleveringssted1_idx` (`udleveringssted_ID`),
  CONSTRAINT `fk_booking_abonnementstype1` FOREIGN KEY (`abonnementstype_ID`) REFERENCES `abonnementstype` (`ID`),
  CONSTRAINT `fk_booking_bil` FOREIGN KEY (`bil_vognNummer`) REFERENCES `bil` (`vognNummer`),
  CONSTRAINT `fk_booking_bruger1` FOREIGN KEY (`bruger_ID`) REFERENCES `bruger` (`ID`),
  CONSTRAINT `fk_booking_udleveringssted1` FOREIGN KEY (`udleveringssted_ID`) REFERENCES `udleveringssted` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bruger`
--

DROP TABLE IF EXISTS `bruger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bruger` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `fornavn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `efternavn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tlf` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CPR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `energitype`
--

DROP TABLE IF EXISTS `energitype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `energitype` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `farve`
--

DROP TABLE IF EXISTS `farve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farve` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `farve` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `gearboks`
--

DROP TABLE IF EXISTS `gearboks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gearboks` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `gearType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `maerke`
--

DROP TABLE IF EXISTS `maerke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maerke` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `maerke` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `energiType_ID` int NOT NULL,
  `gearboks_ID` int NOT NULL,
  `udstyrsniveau_ID` int NOT NULL,
  `maerke_ID` int NOT NULL,
  `farve_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_model_energitype1_idx` (`energiType_ID`),
  KEY `fk_model_udstyrsniveau1_idx` (`udstyrsniveau_ID`),
  KEY `fk_model_gearboks1_idx` (`gearboks_ID`),
  KEY `fk_model_maerke1_idx` (`maerke_ID`),
  KEY `fk_model_farve1_idx` (`farve_ID`),
  CONSTRAINT `fk_model_energitype1` FOREIGN KEY (`energiType_ID`) REFERENCES `energitype` (`ID`),
  CONSTRAINT `fk_model_farve1` FOREIGN KEY (`farve_ID`) REFERENCES `farve` (`ID`),
  CONSTRAINT `fk_model_gearboks1` FOREIGN KEY (`gearboks_ID`) REFERENCES `gearboks` (`ID`),
  CONSTRAINT `fk_model_maerke1` FOREIGN KEY (`maerke_ID`) REFERENCES `maerke` (`ID`),
  CONSTRAINT `fk_model_udstyrsniveau1` FOREIGN KEY (`udstyrsniveau_ID`) REFERENCES `udstyrsniveau` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rapport`
--

DROP TABLE IF EXISTS `rapport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rapport` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `booking_ID` int NOT NULL,
  `dato` date DEFAULT NULL,
  `kilometerSlut` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_rapport_booking1_idx` (`booking_ID`),
  CONSTRAINT `fk_rapport_booking1` FOREIGN KEY (`booking_ID`) REFERENCES `booking` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `skade`
--

DROP TABLE IF EXISTS `skade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skade` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `placering` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `beskrivelse` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pris` double DEFAULT NULL,
  `rapport_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_skade_rapport1_idx` (`rapport_ID`),
  CONSTRAINT `fk_skade_rapport1` FOREIGN KEY (`rapport_ID`) REFERENCES `rapport` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `udleveringssted`
--

DROP TABLE IF EXISTS `udleveringssted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `udleveringssted` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `sted` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `udstyrsniveau`
--

DROP TABLE IF EXISTS `udstyrsniveau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `udstyrsniveau` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `niveau` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-15 16:53:47
