	SET GLOBAL log_bin_trust_function_creators = 1;


-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: team-baever.mysql.database.azure.com    Database: bilabonnement
-- ------------------------------------------------------
-- Server version	8.0.28

DROP SCHEMA IF EXISTS bilabonnement;
CREATE SCHEMA bilabonnement;
USE bilabonnement;

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

--
-- Dumping routines for database 'bilabonnement'
--
/*!50003 DROP FUNCTION IF EXISTS `maanederBooked` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE FUNCTION `maanederBooked`(`$start` date, $slut date) RETURNS int
BEGIN
-- returnerer de antal måneder mellem 2 datoer rundet op.
-- Afrundningen sker i det at hvis en bruger har bestilt for 2 og and halv måned så skal den halve stadig betales
	RETURN ceiling(
			TIMESTAMPDIFF(
				MONTH, `$start`, $slut
			) + 
			DATEDIFF(
				$slut, `$start` + 
				INTERVAL TIMESTAMPDIFF(
					MONTH, `$start`, $slut
				) 
				MONTH
			) /  
			DATEDIFF(
				`$start` + 
				INTERVAL TIMESTAMPDIFF(
					MONTH, `$start`, $slut
				) + 1 MONTH , 
				`$start` + INTERVAL 
				TIMESTAMPDIFF(
					MONTH, `$start`, $slut
				) MONTH 
			)
		);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Bil_FindAlleUdlejet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Bil_FindAlleUdlejet`()
BEGIN

select vognnummer, stelnummer, staalpris, registreringsafgift,
co2udledning, produktionsaar, distance, maanedspris, model, type, geartype,
niveau, maerke, farve, status 

from bil

inner join status on status.id = status_ID
inner join model on model.id = model_ID
	inner join energitype on energitype.id = energitype_ID
    inner join gearboks on gearboks.id = gearboks_ID
    inner join udstyrsniveau on udstyrsniveau.id = udstyrsniveau_ID
    inner join maerke on maerke.id =  maerke_ID
    inner join farve on farve.id = farve_ID

-- status_ID = 2 betyder udlejet
where status_ID = 2;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Bil_Opret` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Bil_Opret`(
IN $vognnummer varchar(255),
IN $stelnummer varchar(255),
IN $staalpris varchar(255),
IN $registreringsAfgift varchar(255),
IN $CO2Udledning varchar(255),
IN $productionsaar varchar(255),
IN $distance varchar(255),
IN $maanedspris varchar(255),
IN $model_ID varchar(255)
)
BEGIN
INSERT INTO `bilabonnement`.`bil`
(`vognNummer`,
`stelNummer`,
`staalpris`,
`registreringsAfgift`,
`CO2Udledning`,
`produktionsaar`,
`distance`,
`maanedspris`,
`model_ID`)
VALUES
($vognnummer COLLATE utf8mb4_0900_ai_ci,
$stelnummer COLLATE utf8mb4_0900_ai_ci,
$staalpris COLLATE utf8mb4_0900_ai_ci,
$registreringsAfgift COLLATE utf8mb4_0900_ai_ci,
$CO2Udledning COLLATE utf8mb4_0900_ai_ci,
$productionsaar COLLATE utf8mb4_0900_ai_ci,
$distance COLLATE utf8mb4_0900_ai_ci,
$maanedspris COLLATE utf8mb4_0900_ai_ci,
$model_ID COLLATE utf8mb4_0900_ai_ci);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Bil_RedigerStatusTilIkkeUdlejet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Bil_RedigerStatusTilIkkeUdlejet`(
IN vognNum varchar(255)
)
BEGIN

UPDATE bil
-- Status til "Ikke Udlejet" er 3.
SET Status_ID = 3 
WHERE vognNummer = vognNum COLLATE utf8mb4_0900_ai_ci;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Bil_RedigerStatusTilIkkeUdlejetBookingID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Bil_RedigerStatusTilIkkeUdlejetBookingID`(
IN $booking_ID varchar(10)
)
BEGIN

UPDATE bil
-- Status til "Ikke udlejet" er 3.

INNER JOIN booking ON vognNummer = booking.bil_vognNummer

SET Status_ID = 3 

WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Bil_RedigerStatusTilSolgtBookingID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Bil_RedigerStatusTilSolgtBookingID`(
IN $booking_ID varchar(10)
)
BEGIN

UPDATE bil
-- Status til "Solgt" er 4.

INNER JOIN booking ON vognNummer = booking.bil_vognNummer

SET Status_ID = 4 

WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Bil_RedigerStatusTilTotalskadetBookingID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Bil_RedigerStatusTilTotalskadetBookingID`(
IN $booking_ID varchar(10)
)
BEGIN

UPDATE bil
-- Status til "Totalskadet" er 1.

INNER JOIN booking ON vognNummer = booking.bil_vognNummer

SET Status_ID = 1 

WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Bil_RedigerStatusTilUdlejet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Bil_RedigerStatusTilUdlejet`(
IN vognNum varchar(255)
)
BEGIN

UPDATE bil
-- Status til "Udlejet" er 2.
SET status_ID = 2 
WHERE vognNummer = vognNum COLLATE utf8mb4_0900_ai_ci;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Bil_Update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Bil_Update`()
BEGIN
-- bliver kun bruge i update test
update bil

set staalpris = 12345678

where staalpris = 12348765;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Booking_Opret` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Booking_Opret`(
-- Format:
-- vognnummer,BrugerID,abonnementstype,sted,udlejningsStartDato,udlejningsSlutDato,kilometerStart
IN $vognNummer varchar(25),
IN $BrugerID varchar(25),
IN $typeID varchar(25),
IN $stedID varchar(255),
IN $udlejningsStartDato varchar(19),
IN $udlejningsSlutDato varchar(19),
IN $kilometerStart varchar(10)
)
BEGIN
-- Inserts data into booking table. -----

INSERT INTO booking(
bruger_ID,
abonnementstype_ID,
udleveringssted_ID,
udlejningsStartDato,
udlejningsSlutDato,
kilometerStart,
bil_vognNummer)

VALUES(
$BrugerID COLLATE utf8mb4_0900_ai_ci,
$typeID COLLATE utf8mb4_0900_ai_ci, -- AbonnementsTypeID
$stedID COLLATE utf8mb4_0900_ai_ci, -- UdleveringsStedID
$udlejningsStartDato COLLATE utf8mb4_0900_ai_ci,
$udlejningsSlutDato COLLATE utf8mb4_0900_ai_ci,
$kilometerStart COLLATE utf8mb4_0900_ai_ci,
$vognNummer COLLATE utf8mb4_0900_ai_ci
);
-- Ændrer booked bil til udlejet. ----------
CALL Bil_RedigerStatusTilUdlejet($vognNummer);
-- ----------
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Bruger_Opret` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Bruger_Opret`(
IN fornavn varchar(255), IN efternavn varchar(255), IN email varchar(255), IN tlf varchar(255), IN CPR varchar(255)
)
BEGIN

INSERT INTO bruger (`fornavn`,`efternavn`,`email`,`tlf`,`CPR`)
VALUES (fornavn, efternavn, email, tlf, CPR);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Model_Opret` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Model_Opret`(
IN $model varchar(255),
IN $energitype varchar(255),
IN $gearboks varchar(255),
IN $udstyrsniveau varchar(255),
IN $maerke varchar(255),
IN $farve varchar(255)
)
BEGIN
INSERT INTO `bilabonnement`.`model`
(`model`,
`energiType_ID`,
`gearboks_ID`,
`udstyrsniveau_ID`,
`maerke_ID`,
`farve_ID`)
VALUES
($model,
(SELECT ID FROM energitype WHERE `type`=$energitype COLLATE utf8mb4_0900_ai_ci ),
(SELECT ID FROM gearboks WHERE gearType=$gearboks COLLATE utf8mb4_0900_ai_ci ),
(SELECT ID FROM udstyrsniveau WHERE niveau=$udstyrsniveau COLLATE utf8mb4_0900_ai_ci ),
(SELECT ID FROM maerke WHERE maerke=$maerke COLLATE utf8mb4_0900_ai_ci ),
(SELECT ID FROM farve WHERE farve=$farve COLLATE utf8mb4_0900_ai_ci ));

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Rapport_OpretFraBookingID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Rapport_OpretFraBookingID`(
IN $booking_ID varchar(25)
)
BEGIN

INSERT INTO rapport(booking_ID,dato)
VALUES($booking_ID,now());

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Rapport_RedigerSlutKilometerFraRapportID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Rapport_RedigerSlutKilometerFraRapportID`(
IN $rapport_ID varchar(25), IN $kilometerSlut varchar(25)
)
BEGIN

UPDATE rapport
SET kilometerSlut = $kilometerSlut
WHERE ID = $rapport_ID;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `saetBookingOvervaaget` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `saetBookingOvervaaget`(IN $booking_ID int)
BEGIN

UPDATE booking
SET overvaaget = 1
WHERE ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Skade_Opret` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Skade_Opret`(
IN $rapport_ID varchar(25), IN $placering varchar(255), IN $beskrivelse varchar(255), IN $pris varchar(10)
)
BEGIN

INSERT INTO skade (placering,beskrivelse,pris,rapport_ID)
VALUES ($placering,$beskrivelse,$pris,$rapport_ID);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Skade_Slet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `Skade_Slet`(IN $skade_ID int)
BEGIN
	DELETE FROM skade
	WHERE ID = $skade_ID COLLATE utf8mb4_0900_ai_ci;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafAbonnementsTyper` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafAbonnementsTyper`()
BEGIN

SELECT * FROM abonnementstype;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafAktiveBookingOgBilData` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafAktiveBookingOgBilData`()
BEGIN
SELECT  
-- Bil information
		vognNummer,
		stelNummer,
        maerke.maerke, 
        model.model,
		energitype.`type`, 
        gearboks.gearType,
        udstyrsniveau.niveau,
        `status`.`status`,
		farve.farve, 
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        bil.maanedsPris,
        
-- Booking information
		booking.kilometerStart,
        booking.ID,
        booking.Bruger_ID,
        
        abonnementstype.type,
        udleveringssted.sted,
        
        booking.udlejningsStartDato,
        booking.udlejningsSlutDato,
		ceiling(
			TIMESTAMPDIFF(
				MONTH, booking.udlejningsStartDato, booking.udlejningsSlutDato
			) + 
			DATEDIFF(
				booking.udlejningsSlutDato, booking.udlejningsStartDato + 
				INTERVAL TIMESTAMPDIFF(
					MONTH, booking.udlejningsStartDato, booking.udlejningsSlutDato
				) 
				MONTH
			) /  
			DATEDIFF(
				booking.udlejningsStartDato + 
				INTERVAL TIMESTAMPDIFF(
					MONTH, booking.udlejningsStartDato, booking.udlejningsSlutDato
				) + 1 MONTH , 
                booking.udlejningsStartDato + INTERVAL 
                TIMESTAMPDIFF(
					MONTH, booking.udlejningsStartDato, booking.udlejningsSlutDato
				) MONTH 
			)
		) AS maanederUdlejet
        

    FROM bil

    -- Laver forbindelse fra bil til model, hvor model så vil forbinde sig til alle andre variabler.
	INNER JOIN model ON model_ID = model.ID
    
    INNER JOIN `status` ON status_ID = `status`.ID
    INNER JOIN farve ON farve.ID = model.farve_ID
    INNER JOIN maerke ON maerke.ID = model.maerke_ID
    
		INNER JOIN energitype ON energitype.ID = model.energitype_ID
		INNER JOIN gearboks ON gearboks.ID = model.gearboks_ID
		INNER JOIN udstyrsniveau ON udstyrsniveau.ID = model.udstyrsniveau_ID
        
        -- Booking info
        INNER JOIN booking ON vognNummer = booking.bil_vognNummer
        INNER JOIN udleveringssted ON udleveringssted.ID = booking.UdleveringsSted_ID
        INNER JOIN abonnementstype ON abonnementstype.ID = booking.AbonnementsType_ID
        
        
		WHERE booking.udlejningsSlutDato > now() AND booking.udlejningsStartDato < now();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafAlleBiler` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafAlleBiler`()
BEGIN
	SELECT 
		vognNummer,
		stelNummer,
        maerke.maerke, 
        model.model,
		energitype.`type`, 
        gearboks.gearType,
        udstyrsniveau.niveau,
        `status`.`status`,
		farve.farve, 
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil
    
    -- Laver forbindelse fra bil til model, hvor model så vil forbinde sig til alle andre variabler.
	INNER JOIN model ON model_ID = model.ID
    
    INNER JOIN `status` ON status_ID = `status`.ID
    INNER JOIN farve ON farve.ID = model.farve_ID
    INNER JOIN maerke ON maerke.ID = model.maerke_ID
    
		INNER JOIN energitype ON energitype.ID = model.energitype_ID
		INNER JOIN gearboks ON gearboks.ID = model.gearboks_ID
		INNER JOIN udstyrsniveau ON udstyrsniveau.ID = model.udstyrsniveau_ID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafAlleBrugere` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafAlleBrugere`()
BEGIN
SELECT * FROM bruger;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafAntalMaanederFraBookingID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafAntalMaanederFraBookingID`(
IN $booking_ID varchar(25)
)
BEGIN

SELECT 
timestampdiff(MONTH,(SELECT udlejningsStartDato FROM booking WHERE ID = $booking_ID),now()) AS maaneder;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafbileraf1parameter` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafbileraf1parameter`(IN param1 varchar(50))
BEGIN
	SELECT 
        vognNummer, 
        stelNummer,
        maerke.maerke,
        model.model,
        energitype.type,
        gearboks.gearType,
        udstyrsniveau.niveau,
        status.status,
        farve.farve,
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil

    
    
    INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
	-- 
        
    WHERE CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param1 , '%') COLLATE utf8mb4_0900_ai_ci
    AND status.status = "Ikke udlejet";

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafbileraf2parametre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafbileraf2parametre`(IN param1 varchar(50), IN param2 varchar(50))
BEGIN
	SELECT 
        vognNummer, 
        stelNummer,
        maerke.maerke,
        model.model,
        energitype.type,
        gearboks.gearType,
        udstyrsniveau.niveau,
        status.status,
        farve.farve,
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil

    
	INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
    WHERE CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param1 , '%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param2 ,'%') COLLATE utf8mb4_0900_ai_ci 
    AND status.status = "Ikke udlejet";
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafbileraf3parametre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafbileraf3parametre`(IN param1 varchar(50), IN param2 varchar(50), IN param3 varchar(50))
BEGIN
	SELECT 
        vognNummer, 
        stelNummer,
        maerke.maerke,
        model.model,
        energitype.type,
        gearboks.gearType,
        udstyrsniveau.niveau,
        status.status,
        farve.farve,
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil

    
	INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
    WHERE CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param1 , '%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param2 ,'%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param3 ,'%') COLLATE utf8mb4_0900_ai_ci 
    AND status.status = "Ikke udlejet";

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafbileraf4parametre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafbileraf4parametre`(IN param1 varchar(50), IN param2 varchar(50), IN param3 varchar(50), IN param4 varchar(50))
BEGIN
	SELECT 
        vognNummer, 
        stelNummer,
        maerke.maerke,
        model.model,
        energitype.type,
        gearboks.gearType,
        udstyrsniveau.niveau,
        status.status,
        farve.farve,
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil

	INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
    WHERE CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param1 , '%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param2 ,'%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param3 ,'%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param4 ,'%') COLLATE utf8mb4_0900_ai_ci
    AND status.status = "Ikke udlejet";

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafbileraf5parametre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafbileraf5parametre`(IN param1 varchar(50), IN param2 varchar(50), IN param3 varchar(50), IN param4 varchar(50), IN param5 varchar(50))
BEGIN
	SELECT
		vognNummer, 
        stelNummer,
        maerke.maerke,
        model.model,
        energitype.type,
        gearboks.gearType,
        udstyrsniveau.niveau,
        status.status,
        farve.farve,
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil


	INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
    WHERE CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param1 , '%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param2 ,'%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param3 ,'%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param4 ,'%') COLLATE utf8mb4_0900_ai_ci 
    AND CONCAT_WS(' ', vognNummer, stelNummer, produktionsaar, registreringsAfgift, distance, maerke.maerke, farve.farve, energitype.`type`, gearboks.geartype, model.model, maanedspris, udstyrsniveau.niveau,' ') 
    LIKE CONCAT('%', param5 ,'%') COLLATE utf8mb4_0900_ai_ci
    AND status.status = "Ikke udlejet";

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafBilerManglerOvervaagning` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafBilerManglerOvervaagning`()
BEGIN
SELECT  
-- Bil information
		vognNummer,
		stelNummer,
        maerke.maerke, 
        model.model,
		energitype.`type`, 
        gearboks.gearType,
        udstyrsniveau.niveau, 
        `status`.`status`, 
        farve.farve,  
        bil.staalpris, 
        registreringsAfgift, 
        CO2Udledning, 
        produktionsaar, 
        distance, 
        bil.maanedsPris, 
        booking.kilometerStart,
        
-- Booking information

         booking.ID,
         booking.Bruger_ID,
        
         abonnementstype.type,
         udleveringssted.sted,
        
         booking.udlejningsStartDato,
         booking.udlejningsSlutDato,
         booking.overvaaget
        
    FROM bil
    
    -- Bil Info
    INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
		-- Forbindelse fra bil til booking.
        INNER JOIN booking ON bil.vognNummer = booking.bil_vognNummer
        
        -- Booking info
       INNER JOIN udleveringssted ON udleveringssted.ID = booking.UdleveringsSted_ID
       INNER JOIN abonnementstype ON abonnementstype.ID = booking.AbonnementsType_ID
		WHERE `status`.`status` = "Udlejet" AND booking.overvaaget = 0 AND booking.udlejningsSlutDato < now()
        ORDER BY booking.udlejningsSlutDato ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafBilFraBookingID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafBilFraBookingID`(IN $Booking_ID varchar(50))
BEGIN
	SELECT 
		vognNummer,
		stelNummer,
        maerke.maerke, 
        model.model,
		energitype.`type`, 
        gearboks.gearType,
        udstyrsniveau.niveau,
        `status`.`status`,
		farve.farve, 
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil
    
    -- Laver forbindelse fra bil til model, hvor model så vil forbinde sig til alle andre variabler.
	INNER JOIN model ON model_ID = model.ID
    
    INNER JOIN `status` ON status_ID = `status`.ID
    INNER JOIN farve ON farve.ID = model.farve_ID
    INNER JOIN maerke ON maerke.ID = model.maerke_ID
    INNER JOIN booking ON vognnummer = booking.bil_vognnummer

    
		INNER JOIN energitype ON energitype.ID = model.energitype_ID
		INNER JOIN gearboks ON gearboks.ID = model.gearboks_ID
		INNER JOIN udstyrsniveau ON udstyrsniveau.ID = model.udstyrsniveau_ID
        
        
    WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafBilFraVognNummer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafBilFraVognNummer`(IN $vognnummer varchar(50))
BEGIN
	SELECT 
		vognNummer,
		stelNummer,
        maerke.maerke, 
        model.model,
		energitype.`type`, 
        gearboks.gearType,
        udstyrsniveau.niveau,
        `status`.`status`,
		farve.farve, 
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil
    
    -- Laver forbindelse fra bil til model, hvor model så vil forbinde sig til alle andre variabler.
	INNER JOIN model ON model_ID = model.ID
    
    INNER JOIN `status` ON status_ID = `status`.ID
    INNER JOIN farve ON farve.ID = model.farve_ID
    INNER JOIN maerke ON maerke.ID = model.maerke_ID
    
		INNER JOIN energitype ON energitype.ID = model.energitype_ID
		INNER JOIN gearboks ON gearboks.ID = model.gearboks_ID
		INNER JOIN udstyrsniveau ON udstyrsniveau.ID = model.udstyrsniveau_ID

    WHERE vognnummer = $vognnummer COLLATE utf8mb4_0900_ai_ci;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafBookingerFraVognNum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafBookingerFraVognNum`(
IN $vognNum varchar(255)
)
BEGIN
SELECT 
		booking.ID,
        bruger_ID,
        abonnementstype.type,
        udleveringssted.sted,
        udlejningsStartDato,
        udlejningsSlutDato,
        kilometerStart,
        bil_vognNummer
        
        FROM booking
        
        INNER JOIN abonnementstype ON booking.abonnementstype_ID = abonnementstype.ID
		INNER JOIN udleveringssted ON booking.udleveringssted_ID = udleveringssted.ID
        
        WHERE bil_vognNummer = $vognNum COLLATE utf8mb4_0900_ai_ci;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafBookingFraID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafBookingFraID`(
IN $booking_ID varchar(255)
)
BEGIN
SELECT 
		booking.ID,
        bruger_ID,
        abonnementstype.type,
        udleveringssted.sted,
        udlejningsStartDato,
        udlejningsSlutDato,
        kilometerStart,
        bil_vognNummer
        
        FROM booking
        
        INNER JOIN abonnementstype ON booking.abonnementstype_ID = abonnementstype.ID
		INNER JOIN udleveringssted ON booking.udleveringssted_ID = udleveringssted.ID
        
        WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafBookingfraRapportID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafBookingfraRapportID`(
IN $rapportID varchar(25)
)
BEGIN
SELECT 
		booking.ID,
        bruger_ID,
        abonnementstype.type,
        udleveringssted.sted,
        udlejningsStartDato,
        udlejningsSlutDato,
        kilometerStart,
        bil_vognNummer
        
        FROM booking
        
        INNER JOIN abonnementstype ON booking.abonnementstype_ID = abonnementstype.ID
		INNER JOIN udleveringssted ON booking.udleveringssted_ID = udleveringssted.ID
        INNER JOIN rapport ON booking.ID = rapport.booking_ID
        
        WHERE rapport.ID = $rapportID COLLATE utf8mb4_0900_ai_ci;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafBrugerFraCPR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafBrugerFraCPR`(
IN $CPR varchar(25)
)
BEGIN
SELECT  
		ID,
        fornavn,
        efternavn,
        email,
        tlf,
        CPR
        
    FROM bruger
    
		WHERE CPR = $CPR COLLATE utf8mb4_0900_ai_ci;
        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafenergityper` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafenergityper`()
BEGIN
	SELECT * 
    FROM energitype;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skaffarver` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skaffarver`()
BEGIN
	SELECT 
		* 
    FROM farve;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafForetningsInformationer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafForetningsInformationer`()
BEGIN
		SELECT  
		bil.maanedsPris,
		maanederBooked(booking.udlejningsStartDato, booking.udlejningsSlutDato) AS maanederUdlejet


		FROM bil
		INNER JOIN booking ON vognNummer = booking.bil_vognNummer
        -- 2 = udlejet
		WHERE `status_ID` = 2 AND MONTH(booking.udlejningsSlutDato) = MONTH(now());
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafgearboks` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafgearboks`()
BEGIN
	SELECT * 
    FROM gearboks;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafHoejsteKundeID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafHoejsteKundeID`()
BEGIN

SELECT ID FROM bruger ORDER BY ID DESC LIMIT 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafIndtaegt` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafIndtaegt`()
BEGIN
		SELECT  
		bil.maanedsPris,
		maanederBooked(booking.udlejningsStartDato, booking.udlejningsSlutDato) AS maanederUdlejet


		FROM bil
		INNER JOIN booking ON vognNummer = booking.bil_vognNummer
        -- 2 = udlejet
		WHERE `status_ID` = 2;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafIndtaegtForDenneMaaned` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafIndtaegtForDenneMaaned`()
BEGIN
		SELECT  
		bil.maanedsPris,
		maanederBooked(booking.udlejningsStartDato, booking.udlejningsSlutDato) AS maanederUdlejet


		FROM bil
		INNER JOIN booking ON vognNummer = booking.bil_vognNummer

		WHERE booking.udlejningsSlutDato > now() AND booking.udlejningsStartDato < now();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafKilometerKoert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafKilometerKoert`(IN $booking_ID int)
BEGIN

	SELECT rapport.kilometerSlut-booking.kilometerStart AS kilometerKoert
    FROM booking
	INNER JOIN rapport ON booking.ID = rapport.booking_ID
    WHERE booking.ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafmaerker` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafmaerker`()
BEGIN
	SELECT 
		* 
    FROM maerke;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafModelMedPraeciseParametre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafModelMedPraeciseParametre`(
IN $model varchar(255),
IN $energitype varchar(255),
IN $gearboks varchar(255),
IN $udstyrsniveau varchar(255),
IN $maerke varchar(255),
IN $farve varchar(255)
)
BEGIN

SELECT ID 
FROM model

WHERE model.model = $model COLLATE utf8mb4_0900_ai_ci 
AND energitype_ID = (SELECT ID FROM energitype WHERE `type`=$energitype COLLATE utf8mb4_0900_ai_ci )
AND gearboks_ID = (SELECT ID FROM gearboks WHERE gearType=$gearboks COLLATE utf8mb4_0900_ai_ci )
AND udstyrsniveau_ID = (SELECT ID FROM udstyrsniveau WHERE niveau=$udstyrsniveau COLLATE utf8mb4_0900_ai_ci )
AND maerke_ID = (SELECT ID FROM maerke WHERE maerke=$maerke COLLATE utf8mb4_0900_ai_ci )
AND farve_ID = (SELECT ID FROM farve WHERE farve=$farve COLLATE utf8mb4_0900_ai_ci );



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafRapportFraBookingID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafRapportFraBookingID`(
IN $bookingID varchar(255)
)
BEGIN
	SELECT * 
    FROM Rapport
    WHERE booking_ID = $bookingID COLLATE utf8mb4_0900_ai_ci;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafRapportHvorVognNummerSpecifik` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafRapportHvorVognNummerSpecifik`(
IN $vognNum varchar(255)
)
BEGIN

select rapport.id, dato, vognnummer, kilometerslut

from rapport
inner join booking on booking.id = booking_id
	inner join bil on bil.vognnummer = bil_vognnummer
    
where vognnummer = $vognnum COLLATE utf8mb4_0900_ai_ci;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafSkaderFraBookingID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafSkaderFraBookingID`(
IN $bookingID varchar(255)
)
BEGIN
	SELECT 
    skade.*
    FROM rapport
    
    INNER JOIN skade ON rapport.ID = skade.rapport_ID
    
    WHERE booking_ID = $bookingID COLLATE utf8mb4_0900_ai_ci;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafSkaderFraRapportID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafSkaderFraRapportID`(IN $rapport_ID int)
BEGIN

	SELECT 
    *
    FROM skade
    
    WHERE skade.rapport_ID = $rapport_ID COLLATE utf8mb4_0900_ai_ci;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafSlutKilometerFraRapportID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafSlutKilometerFraRapportID`(
IN $rapport_ID varchar(25)
)
BEGIN

SELECT kilometerSlut
FROM rapport
WHERE ID = $rapport_ID;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafSpecifikBilFraVognNum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafSpecifikBilFraVognNum`(
IN $vognNum varchar(255)
)
BEGIN
	SELECT 
		vognNummer,
		stelNummer,
        maerke.maerke, 
        model.model,
		energitype.`type`, 
        gearboks.gearType,
        udstyrsniveau.niveau,
        `status`.`status`,
		farve.farve, 
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil
    
    -- Bil Info
    INNER JOIN `status` ON bil.Status_ID=`status`.ID
    INNER JOIN model ON model.id = model_ID
		inner join farve on farve_ID = farve.id
		INNER JOIN maerke ON Maerke_ID = maerke.ID
		INNER JOIN energitype ON model.EnergiType_ID = energitype.ID
		INNER JOIN gearboks ON model.Gearboks_ID = gearboks.ID
		INNER JOIN udstyrsniveau ON model.Udstyrsniveau_ID = udstyrsniveau.ID
        
-- Bruger en metode til at sammenligne disse to Strings, da vognnummeret er 
-- for højt til at være en int, så både parameteren og værdien er varchar.as
-- COLLATE er til at programmet kan forstå hvilket "sprog", eller karakterer som bliver brugt her. (En form for ordbog)
WHERE vognNummer = $vognNum COLLATE utf8mb4_0900_ai_ci;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafTilgængeligeBiler` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafTilgængeligeBiler`()
BEGIN
	SELECT 
		vognNummer,
		stelNummer,
        maerke.maerke, 
        model.model,
		energitype.`type`, 
        gearboks.gearType,
        udstyrsniveau.niveau,
        `status`.`status`,
		farve.farve, 
        staalpris,
        registreringsAfgift,
        CO2Udledning,
        produktionsaar,
        distance,
        maanedspris

    FROM bil
    
    -- Laver forbindelse fra bil til model, hvor model så vil forbinde sig til alle andre variabler.
	INNER JOIN model ON model_ID = model.ID
    
    INNER JOIN `status` ON status_ID = `status`.ID
    INNER JOIN farve ON farve.ID = model.farve_ID
    INNER JOIN maerke ON maerke.ID = model.maerke_ID
    
		INNER JOIN energitype ON energitype.ID = model.energitype_ID
		INNER JOIN gearboks ON gearboks.ID = model.gearboks_ID
		INNER JOIN udstyrsniveau ON udstyrsniveau.ID = model.udstyrsniveau_ID
        WHERE status = "Ikke udlejet";
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafUdleveringssteder` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafUdleveringssteder`()
BEGIN

SELECT * FROM udleveringssted;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafUdregnetKilometerKoertOgOpdaterBilOgRapport` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafUdregnetKilometerKoertOgOpdaterBilOgRapport`(IN $booking_ID int,IN $indtastetDistance int)
BEGIN

-- Assigner variabler
DECLARE $kilometerStart int;
DECLARE $kilometerKoert int;
DECLARE $bilVognNummer varchar(25);

-- bruger en subquery til at finde ud af bilens booking kilometerstart.
SET $kilometerStart = 
(SELECT kilometerStart FROM booking WHERE ID = $booking_ID COLLATE utf8mb4_0900_ai_ci LIMIT 1);

-- Kilometer kørt bliver udregnet ved at minus det nye indtastet distance med kilometerstart.
SET $kilometerKoert = 
$indtastetDistance - $kilometerStart;

-- bruger en subquery til at finde bilens vognnummer.
SET $bilVognNummer = 
(SELECT bil_vognNummer FROM booking WHERE ID = $booking_ID COLLATE utf8mb4_0900_ai_ci LIMIT 1);

-- Opdaterer Rapportens kilometerslut.alter
UPDATE rapport
SET kilometerSlut = $indtastetDistance
WHERE booking_ID = $booking_ID COLLATE utf8mb4_0900_ai_ci;

-- Opdaterer bilen, så den indtastet distance er den nye distance.
UPDATE bil
SET distance = $indtastetDistance
WHERE vognNummer = $bilVognNummer COLLATE utf8mb4_0900_ai_ci;

SELECT $kilometerKoert;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `skafudstyrsniveau` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE  PROCEDURE `skafudstyrsniveau`()
BEGIN
	SELECT * 
    FROM udstyrsniveau;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-15 15:31:51




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
-- Dumping data for table `abonnementstype`
--

LOCK TABLES `abonnementstype` WRITE;
/*!40000 ALTER TABLE `abonnementstype` DISABLE KEYS */;
INSERT INTO `abonnementstype` VALUES (1,'Unlimited'),(2,'Limited');
/*!40000 ALTER TABLE `abonnementstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bruger`
--

LOCK TABLES `bruger` WRITE;
/*!40000 ALTER TABLE `bruger` DISABLE KEYS */;
INSERT INTO `bruger` VALUES (112,'Mark','Denner','Marksmail@example.com','+45 20 35 40 51','2604001005'),(113,'Ferhat','Baran','frrt@gmail.com','42568686','1706062000'),(114,'Mikkel','Hansen','hansenMikkel@ecex.org','+43 98 42 49 43','0103794356'),(115,'Bjørn','Haastrup','Bogus@gmail.com','12341253','1907965233'),(116,'Sara','Sørensen','GandamStyler69@gmail.com','+45 88 64 94 03','0304017634'),(117,'Ole','Fabelsen','gnomeMan90@youvebeengnomed.com','+45 88 85 25 99','0502885988'),(118,'Peter','Henriksen','TotalDanskerMan3@stemdf.com','+45 99 85 44 14','0104737586'),(119,'Bob','Larsen','BopperMan@gmail.com','+45 88 99 91 44','0405998471');
/*!40000 ALTER TABLE `bruger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `energitype`
--

LOCK TABLES `energitype` WRITE;
/*!40000 ALTER TABLE `energitype` DISABLE KEYS */;
INSERT INTO `energitype` VALUES (1,'Diesel'),(2,'Elektrisk'),(3,'Benzin');
/*!40000 ALTER TABLE `energitype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `farve`
--

LOCK TABLES `farve` WRITE;
/*!40000 ALTER TABLE `farve` DISABLE KEYS */;
INSERT INTO `farve` VALUES (1,'Sølv'),(2,'Hvid'),(3,'Orange'),(4,'Lilla'),(5,'Carbon'),(6,'Gul'),(7,'Blå'),(8,'Gylden'),(9,'Sort'),(10,'Rød');
/*!40000 ALTER TABLE `farve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gearboks`
--

LOCK TABLES `gearboks` WRITE;
/*!40000 ALTER TABLE `gearboks` DISABLE KEYS */;
INSERT INTO `gearboks` VALUES (1,'Manuel'),(2,'Automatisk');
/*!40000 ALTER TABLE `gearboks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `maerke`
--

LOCK TABLES `maerke` WRITE;
/*!40000 ALTER TABLE `maerke` DISABLE KEYS */;
INSERT INTO `maerke` VALUES (1,'Skoda'),(2,'Tesla'),(3,'Mercedes'),(4,'BMW'),(5,'Toyota'),(6,'Audi'),(7,'Volvo'),(8,'Ford'),(9,'Nissan'),(10,'VolksWagen');
/*!40000 ALTER TABLE `maerke` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `udstyrsniveau`
--

LOCK TABLES `udstyrsniveau` WRITE;
/*!40000 ALTER TABLE `udstyrsniveau` DISABLE KEYS */;
INSERT INTO `udstyrsniveau` VALUES (1,'Fuldt Udstyr'),(2,'Minimal Udstyr'),(3,'Intet Udstyr');
/*!40000 ALTER TABLE `udstyrsniveau` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (68,'OP825',1,1,1,6,4),(69,'Octavia',1,1,1,1,7),(70,'Bobsled',2,2,2,2,7),(71,'Fabia',3,1,2,1,1),(72,'XC40',2,2,1,7,2),(73,'NF2341',3,1,3,1,8),(74,'T-Cross',1,1,2,10,7),(75,'LEAF',1,1,2,9,3),(76,'Boef',3,1,1,7,1),(77,'GR Supra',3,2,1,5,5),(78,'UM573',2,2,2,3,10),(79,'X5',3,1,1,4,9),(80,'Roadster',2,2,2,2,3),(81,'GN342',2,1,2,5,2),(82,'UV384',3,2,1,8,3),(83,'GM324',1,2,1,9,9),(84,'AMG GT',1,1,2,3,7),(85,'823HE',1,1,2,5,4),(86,'UP',3,1,2,10,2),(87,'EJ384',2,1,2,3,2),(88,'Qashqai',2,2,1,9,9);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Totalskadet'),(2,'Udlejet'),(3,'Ikke Udlejet'),(4,'Solgt'),(5,'Under Reparation');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `udleveringssted`
--

LOCK TABLES `udleveringssted` WRITE;
/*!40000 ALTER TABLE `udleveringssted` DISABLE KEYS */;
INSERT INTO `udleveringssted` VALUES (1,'5260 Lyda Wall Suite 927\nLake Kelsiburgh, NV 22711'),(2,'274 Britney Parks Apt. 468\nSouth Zella, NY 29606-8378'),(3,'852 Maiya Route\nWest Vernland, NC 16636'),(4,'11846 Marcelo Mission Suite 224\nLake Diamondbury, WA 22899'),(5,'1086 Pfeffer Locks Apt. 704\nPort Dayanaport, OR 14695'),(6,'007 Dicki Grove\nMrazfurt, IA 16287-2879'),(7,'144 Caleb Ports Suite 947\nPort Brielleport, WI 99059'),(8,'151 Beatty Bridge Suite 871\nWunschfort, CO 06226'),(9,'536 Tania Overpass Apt. 289\nNew Jaydebury, MS 78468-1232'),(10,'729 Dicki Mill Suite 635\nSouth Maidaville, CA 15822');
/*!40000 ALTER TABLE `udleveringssted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bil`
--

LOCK TABLES `bil` WRITE;
/*!40000 ALTER TABLE `bil` DISABLE KEYS */;
INSERT INTO `bil` VALUES ('AA21233','TH8KV324671686548',65000,330,520,2004,1000,4500,1,71),('AD88789','POOP4737898450114',95000,700,0,2014,4000,3500,3,88),('DD32849','AW342F32G21462D25',55000,350,500,1999,4000,8000,3,68),('FK45842','JS8G2568202689452',55000,440,600,2000,19000,3900,3,84),('GH18463','KH8KV859692562628',60000,400,480,2008,25000,2300,3,79),('HJ37472','JE4328985QA213425',72134,792,459,1995,783,3487,2,85),('IF32747','PA273457WK3278457',37462,329,347,2010,7432,8435,3,78),('KW23452','YH2384892JE327851',82879,382,450,2005,4000,8324,3,87),('LE85327','UG38284IS2342485',40000,350,600,1999,8000,4500,3,73),('ME32845','EM3274293LW324289',59645,438,405,1999,8493,3475,3,83),('OI82479','EH8KV324671686548',45000,350,550,2000,10000,2600,2,75),('OL44657','OOPD8374958478581',56000,400,450,2016,6500,3500,2,86),('PF32845','GH3248923TJ238491',97234,378,473,2003,3745,3274,3,81),('PO57489','XQCT5586989300098',60000,600,0,2008,9000,1200,2,80),('PP42569','FGEJ3928181175923',65000,600,500,2019,100,3000,3,74),('QL38245','KW38249TM4324582',99435,328,564,2005,1000,7843,2,82),('UD89437','UDEJ8274918593028',55000,430,0,2015,4000,12000,3,72),('UG43785','TH238182JE384328',327847,532,375,2003,3254,4543,2,76),('XE22324','KPEO5849983985734',90000,700,600,2020,500,8000,2,77),('YD12934','AD129312DR2342113',60000,500,400,2020,2000,10000,2,70),('YD29832','YV1JV324271643584',50000,350,50,2020,500,2600,3,69);
/*!40000 ALTER TABLE `bil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (127,'2022-12-15 00:00:00','2023-02-23 00:00:00',3254,0,112,2,3,'UG43785'),(128,'2019-10-10 00:00:00','2020-10-10 00:00:00',17500,1,113,1,2,'FK45842'),(129,'2022-12-15 00:00:00','2023-02-19 00:00:00',500,0,114,1,4,'XE22324'),(130,'2022-12-02 00:00:00','2023-02-17 00:00:00',9000,0,115,1,9,'PO57489'),(131,'2022-12-08 00:00:00','2023-03-23 00:00:00',2000,0,115,2,5,'YD12934'),(132,'2022-10-05 00:00:00','2022-12-15 00:00:00',783,0,116,1,8,'HJ37472'),(133,'2022-12-04 00:00:00','2023-03-18 00:00:00',783,0,115,2,9,'QL38245'),(134,'2022-07-06 00:00:00','2022-11-16 00:00:00',0,1,117,1,2,'AA21233'),(135,'2022-12-03 00:00:00','2023-02-21 00:00:00',1000,0,115,1,6,'AD88789'),(136,'2022-08-10 00:00:00','2022-11-16 00:00:00',10000,0,118,2,1,'OI82479'),(137,'2019-04-18 00:00:00','2019-06-16 00:00:00',6500,0,119,2,7,'OL44657');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rapport`
--

LOCK TABLES `rapport` WRITE;
/*!40000 ALTER TABLE `rapport` DISABLE KEYS */;
INSERT INTO `rapport` VALUES (113,134,'2022-12-16',1000),(114,128,'2022-12-16',19000);
/*!40000 ALTER TABLE `rapport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `skade`
--

LOCK TABLES `skade` WRITE;
/*!40000 ALTER TABLE `skade` DISABLE KEYS */;
INSERT INTO `skade` VALUES (140,'Venstre forhjul','Blev ramt af en påfugl, smadrede hele dækket.',4000,113),(141,'Forruden','Stenkast fra en ukendt person.',500,114);
/*!40000 ALTER TABLE `skade` ENABLE KEYS */;
UNLOCK TABLES;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-16  1:18:14
