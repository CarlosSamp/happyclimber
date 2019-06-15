-- MySQL dump 10.17  Distrib 10.3.14-MariaDB, for osx10.14 (x86_64)
--
-- Host: localhost    Database: mydatabase
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `climber`
--

DROP TABLE IF EXISTS `climber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `climber` (
  `id` bigint(20) NOT NULL,
  `birthday` datetime NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `living` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `nation` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `climber`
--

LOCK TABLES `climber` WRITE;
/*!40000 ALTER TABLE `climber` DISABLE KEYS */;
INSERT INTO `climber` VALUES (1,'2019-01-05 23:06:00','Carlos','Thun','Sampaio Peredo','Schweiz','root','Carlito'),(2,'1993-12-31 23:02:00','Kevin','Hünibach','Meier','Schweiz','123','Kev'),(3,'1993-01-09 23:03:00','Filippo','Worb','Gaiani','Schweiz','123','Pipo');
/*!40000 ALTER TABLE `climber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','init','SQL','V1__init.sql',0,'root','2019-06-08 16:06:55',1,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journalpos`
--

DROP TABLE IF EXISTS `journalpos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalpos` (
  `id` bigint(20) NOT NULL,
  `ascent` varchar(255) DEFAULT NULL,
  `date` datetime NOT NULL,
  `climber_fk` bigint(20) NOT NULL,
  `route_fk` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi3ieratb3ki1cwrqj89nfc5pg` (`climber_fk`),
  KEY `FK5kf71drri6m2j0rls5k5ivf1y` (`route_fk`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journalpos`
--

LOCK TABLES `journalpos` WRITE;
/*!40000 ALTER TABLE `journalpos` DISABLE KEYS */;
INSERT INTO `journalpos` VALUES (3,'FL','2019-01-05 23:06:00',2,6),(4,'RP','2019-01-02 23:05:00',2,2),(6,'FL','2018-01-04 23:12:00',2,7),(11,'RP','2019-01-04 23:04:00',2,9),(12,'TR','2019-01-29 23:04:00',2,8),(13,'PP','2017-12-31 23:06:00',2,7),(17,'FS','2019-01-16 23:05:00',3,10),(21,'ON','2019-01-11 23:06:00',1,1),(22,'RP','2019-01-13 23:03:00',1,2),(24,'FL','2019-01-04 23:06:00',1,9),(25,'RP','2019-01-04 23:06:00',1,10);
/*!40000 ALTER TABLE `journalpos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `id` bigint(20) NOT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `sector_fk` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK993olx7nui1t1rsnphtxbls1` (`sector_fk`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'FIVECP','Lindenstrasse',1),(2,'SIXBP','Troja',2),(4,'SEVENA','Vegitrip',2),(6,'SIXB','Flex',6),(7,'SIXA','Sunshine',8),(8,'SIXAP','Uprising',8),(9,'SEVENA','Wackelstein',2),(10,'SEVENB','Via Flacca',2),(11,'NINEC','Nestlé',8),(12,'SEVENA','Rameli',2);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sector` (
  `id` bigint(20) NOT NULL,
  `country` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `place` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` VALUES (1,'Schweiz','Neuhaus','Interlaken'),(2,'Schweiz','Lehn','Interlaken'),(3,'Schweiz','Staldifluh','Brienz'),(6,'Schweiz','Eden','Susten'),(8,'Schweiz','Hannibalturm','Furka');
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_climber`
--

DROP TABLE IF EXISTS `seq_climber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_climber` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_climber`
--

LOCK TABLES `seq_climber` WRITE;
/*!40000 ALTER TABLE `seq_climber` DISABLE KEYS */;
INSERT INTO `seq_climber` VALUES (4);
/*!40000 ALTER TABLE `seq_climber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_journalpos`
--

DROP TABLE IF EXISTS `seq_journalpos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_journalpos` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_journalpos`
--

LOCK TABLES `seq_journalpos` WRITE;
/*!40000 ALTER TABLE `seq_journalpos` DISABLE KEYS */;
INSERT INTO `seq_journalpos` VALUES (26);
/*!40000 ALTER TABLE `seq_journalpos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_route`
--

DROP TABLE IF EXISTS `seq_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_route` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_route`
--

LOCK TABLES `seq_route` WRITE;
/*!40000 ALTER TABLE `seq_route` DISABLE KEYS */;
INSERT INTO `seq_route` VALUES (13);
/*!40000 ALTER TABLE `seq_route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_sector`
--

DROP TABLE IF EXISTS `seq_sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_sector` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_sector`
--

LOCK TABLES `seq_sector` WRITE;
/*!40000 ALTER TABLE `seq_sector` DISABLE KEYS */;
INSERT INTO `seq_sector` VALUES (11);
/*!40000 ALTER TABLE `seq_sector` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-15 16:30:11
