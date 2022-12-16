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
