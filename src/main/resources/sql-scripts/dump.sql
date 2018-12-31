-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: conferences
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `conferences_cf`
--

DROP TABLE IF EXISTS `conferences_cf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conferences_cf` (
  `id_cf` int(11) NOT NULL AUTO_INCREMENT,
  `name_cf` varchar(45) NOT NULL,
  `info_cf` text,
  PRIMARY KEY (`id_cf`),
  UNIQUE KEY `conferences_cf_id_cf_uindex` (`id_cf`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conferences_cf`
--

LOCK TABLES `conferences_cf` WRITE;
/*!40000 ALTER TABLE `conferences_cf` DISABLE KEYS */;
INSERT INTO `conferences_cf` VALUES (2,'test','test'),(3,'asd','asd');
/*!40000 ALTER TABLE `conferences_cf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions_qs`
--

DROP TABLE IF EXISTS `questions_qs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions_qs` (
  `id_qs` int(11) NOT NULL AUTO_INCREMENT,
  `question_qs` varchar(150) DEFAULT NULL,
  `rating_qs` int(11) DEFAULT '0',
  `fk_id_rp` int(11) NOT NULL,
  `fk_id_usr` int(11) NOT NULL,
  PRIMARY KEY (`id_qs`),
  UNIQUE KEY `questions_qs_id_qs_uindex` (`id_qs`),
  KEY `fk_id_rp` (`fk_id_rp`),
  KEY `fk_id_usr` (`fk_id_usr`),
  CONSTRAINT `fk_id_rp` FOREIGN KEY (`fk_id_rp`) REFERENCES `reports_rp` (`id_rp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_usr` FOREIGN KEY (`fk_id_usr`) REFERENCES `users_usr` (`id_usr`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions_qs`
--

LOCK TABLES `questions_qs` WRITE;
/*!40000 ALTER TABLE `questions_qs` DISABLE KEYS */;
INSERT INTO `questions_qs` VALUES (4,'some question.',0,1,21),(5,'Hello, what is the chief objective of this report?',0,1,21),(6,'Another user\'s question here..',0,1,4),(10,NULL,0,4,21),(11,NULL,0,5,21),(12,NULL,0,1,21),(13,NULL,0,1,21),(14,NULL,0,1,21),(15,NULL,0,1,21);
/*!40000 ALTER TABLE `questions_qs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports_rp`
--

DROP TABLE IF EXISTS `reports_rp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reports_rp` (
  `id_rp` int(11) NOT NULL AUTO_INCREMENT,
  `name_rp` varchar(45) NOT NULL,
  `announcer_rp` varchar(45) NOT NULL,
  `fk_id_cf` int(11) NOT NULL,
  PRIMARY KEY (`id_rp`),
  UNIQUE KEY `reports_rp_id_rp_uindex` (`id_rp`),
  KEY `fk_id_cf` (`fk_id_cf`),
  CONSTRAINT `fk_id_cf` FOREIGN KEY (`fk_id_cf`) REFERENCES `conferences_cf` (`id_cf`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports_rp`
--

LOCK TABLES `reports_rp` WRITE;
/*!40000 ALTER TABLE `reports_rp` DISABLE KEYS */;
INSERT INTO `reports_rp` VALUES (1,'new report','John Doe',2),(4,'another report','Nathan Lynch',2),(5,'new new ','Brian M',2),(7,'super new report','John Koehn',3);
/*!40000 ALTER TABLE `reports_rp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_usr`
--

DROP TABLE IF EXISTS `users_usr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_usr` (
  `id_usr` int(11) NOT NULL AUTO_INCREMENT,
  `nickname_usr` varchar(45) DEFAULT NULL,
  `email_usr` varchar(45) NOT NULL,
  `role_usr` enum('ADMIN','MODER','USER') NOT NULL DEFAULT 'USER',
  `password_usr` varchar(64) NOT NULL,
  PRIMARY KEY (`id_usr`),
  UNIQUE KEY `user_usr_id_usr_uindex` (`id_usr`),
  UNIQUE KEY `user_usr_email_usr_uindex` (`email_usr`),
  UNIQUE KEY `users_usr_nickname_usr_uindex` (`nickname_usr`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_usr`
--

LOCK TABLES `users_usr` WRITE;
/*!40000 ALTER TABLE `users_usr` DISABLE KEYS */;
INSERT INTO `users_usr` VALUES (4,'sparksaway','andriymykytyn@yahoo.com','USER','kosmones1'),(9,'andrew1231','andrew1231@gmail.com','USER','resque27'),(18,'exampleusr','some@gmail.com','USER','somesome'),(20,'jagari','standart@yahoo.com','USER','ribboco'),(21,'swelly','swilliams@yahoo.com','USER','kosmones1'),(24,'nicky','nicky@yahoo.com','USER','kosmones1'),(25,'goodusr','goodemail@yahoo.com','USER','good123'),(27,'superpuper','kosmones@kosmones.kosmones','USER','kosmones123'),(32,'boomboom','supermail@yahoo.com','USER','kosmones'),(34,'somenewuser','123123kosmones@yahoo.com','USER','kosmones1');
/*!40000 ALTER TABLE `users_usr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr_has_cf`
--

DROP TABLE IF EXISTS `usr_has_cf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usr_has_cf` (
  `id_usr_has_cf` int(11) NOT NULL AUTO_INCREMENT,
  `cf_id_cf` int(11) NOT NULL,
  `usr_id_usr` int(11) NOT NULL,
  PRIMARY KEY (`id_usr_has_cf`),
  UNIQUE KEY `usr_has_cf_id_usr_has_cf_uindex` (`id_usr_has_cf`),
  KEY `usr_id_usr` (`usr_id_usr`),
  KEY `cf_id_cf` (`cf_id_cf`),
  CONSTRAINT `cf_id_cf` FOREIGN KEY (`cf_id_cf`) REFERENCES `conferences_cf` (`id_cf`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usr_id_usr` FOREIGN KEY (`usr_id_usr`) REFERENCES `users_usr` (`id_usr`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr_has_cf`
--

LOCK TABLES `usr_has_cf` WRITE;
/*!40000 ALTER TABLE `usr_has_cf` DISABLE KEYS */;
/*!40000 ALTER TABLE `usr_has_cf` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-31 11:02:04
